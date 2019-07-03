(ns paip-clojure.chapter1)

(def p '(John Q Public))

(def x1 10)

(defn third [x] (first (next (next x))))
(defn fourth [x] (first (next (next (next x)))))
(defn fifth [x] (first (next (next (next (next x))))))

(def x '(("1st" element) 2 (element 3) ((4)) 5))

(def town (list 'Anytown 'USA))

(defn last-name
  "Select the last name from a name represented as a list."
  [name]
  (first (take-last 1 name)))

(defn first-name
  "Select the first name from a name represented as a list."
  [name]
  (first name))

(def names '((John Q Public)
              (Malcolm X)
              (Admiral Grace Murray Hopper)
              (Spot)
              (Aristotle)
              (A A Milne)
              (Z Z Top)
              (Sir Larry Olivier)
              (Miss Scarlet)))

(def titles
  "A list of titles that can appear at the start of a name."
  '(Mr Mrs Miss Ms Sir Madam Dr Admiral Major General))

(defn first-name6 [name]
  "Select the first name from a name represented as a list."
  (if (some #{(first name)} titles)
    (first-name6 (rest name))
    (first name)))

(defn mappend [fn the-list]
  "Apply fn to each element of list and append the results."
  (apply concat (map fn the-list)))

(defn self-and-double [x] (list x (+ x x)))

(defn number-and-negation [x]
  "If x is a number, return a list of x and -x."
  (if (number? x)
    (list x (- x))
    nil))

(defn numbers-and-negations [input]
  "Given a list, return only the numbers and their negations."
  (mappend number-and-negation input))

(defn mappend2 [fn the-list]
  "Apply fn to each element of list and append the results."
  (if (empty? the-list)
    nil
    (concat (fn (first the-list))
            (mappend2 fn (rest the-list)))))


(def suffices
  '(MD Jr.))

(defn init [coll]
  (take (- (count coll) 1) coll))

(defn last-name2 [name]
  (if (some #{(last name)} suffices)
    (last-name2 (init name))
    (last name)))


(defn power [x n]
  "Power raises x to the nth power.  N must be an integer >= 0.
   This executes in log n time, because of the check for even n."
  (cond
    (= n 0) 1
    (even? n) (let [y (power x (/ n 2))]
                (* y y))
    :else (* x (power x (- n 1)))))

; This is not a proper implementation, but it's good enough here
(defn atom? [exp]
  (or (not (coll? exp)) (empty? exp)))

(defn count-atoms [exp]
  "Return the total number of non-nil atoms in the expression."
  (cond
    (nil? exp) 0
    (atom? exp) 1
    :else (+ (count-atoms (first exp))
             (count-atoms (rest exp)))))

(defn count-all-atoms
  "Return the total number of atoms in the expression,
  counting nil as an atom only in non-tail position."
  ([exp]
    (count-all-atoms exp 1))
  ([exp if-nil]
   (cond
     (nil? exp) if-nil
     (atom? exp) 1
     :else (+ (count-all-atoms (first exp) 1)
              (count-all-atoms (rest exp) 0)))))
