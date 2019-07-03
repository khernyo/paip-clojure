(ns paip-clojure.chapter1-test
  (:require [clojure.test :refer :all]
            [paip-clojure.core :refer :all]
            [paip-clojure.chapter1 :refer :all]))

(deftest _1
  (testing "1.1 Symbolic Computation"
    (is (= (concat '(Pat Kim) '(Robin Sandy)) '(Pat Kim Robin Sandy)))
    (is (= (concat '(Pat Kim) (list '(John Q Public) 'Sandy)) '(Pat Kim (John Q Public) Sandy)))
    (is (= (count (concat '(Pat Kim) (list '(John Q Public) 'Sandy))) 4))))

(deftest _2
  (testing "1.2 Variables"
    (is (= p '(John Q Public)))
    (is (= (+ x1 x1) 20))
    (is (= (+ x1 (count p) 13)))))

(deftest _3
  (testing "1.3 Special Forms"))

(deftest _4
  (testing "1.4 Lists"
    (is (= (first p) 'John))
    (is (= (rest p) '(Q Public)))
    (is (= (second p) 'Q))
    (is (= (third p) 'Public))
    (is (= (fourth p) nil))
    (is (= (count p) 3))

    (is (= (count x) 5))
    (is (= (first x) '("1st" element)))
    (is (= (second x) 2))
    (is (= (third x) '(element 3)))
    (is (= (fourth x) '((4))))
    (is (= (first (fourth x)) '(4)))
    (is (= (first (first (fourth x))) 4))
    (is (= (fifth x) 5))
    (is (= (second (first x)) 'element))

    (is (= (cons 'Mr p) '(Mr John Q Public)))
    (is (= (cons (first p) (rest p)) p))
    (is (= (list p 'of town 'may 'have 'already 'won!) '((John Q Public) of (Anytown USA) may have already won!)))
    (is (= (concat p '(of) town '(may have already won!)) '(John Q Public of Anytown USA may have already won!)))
    (is (= p '(John Q Public)))

    (is (= (first (take-last 1 p)) 'Public))))

(deftest _5
  (testing "1.5 Defining New Functions"
    (is (= (last-name p) 'Public))
    (is (= (last-name '(Rear Admiral Grace Murray Hopper)) 'Hopper))
    (is (= (last-name '(Rex Morgan MD)) 'MD))
    (is (= (last-name '(Spot)) 'Spot))
    (is (= (last-name '(Aristotle)) 'Aristotle))
    (is (= (first-name p) 'John))
    (is (= (first-name '(Wilma Flintstone)) 'Wilma))
    (is (= (first-name (first names)) 'John))))

(deftest _6
  (testing "1.6 Using Functions"
    (is (= (map last-name names) '(Public X Hopper Spot Aristotle Milne Top Olivier Scarlet)))
    (is (= (map - '(1 2 3 4)) '(-1 -2 -3 -4)))
    (is (= (map + '(1 2 3 4) '(10 20 30 40)) '(11 22 33 44)))
    (is (= (map first-name names) '(John Malcolm Admiral Spot Aristotle A Z Sir Miss)))
    (is (= (map first-name6 names) '(John Malcolm Grace Spot Aristotle A Z Larry Scarlet)))
    (is (= (first-name6 '(Madam Major General Paula Jones)) 'Paula))))

(deftest _7
  (testing "1.7 Higher-Order Functionc"
    (is (= (apply + '(1 2 3 4)) 10))
    (is (= (apply concat '((1 2 3) (a b c))) '(1 2 3 a b c)))
    (is (= (self-and-double 3) '(3 6)))
    (is (= (apply self-and-double '(3)) '(3 6)))
    (is (= (map self-and-double '(1 10 300)) '((1 2) (10 20) (300 600))))
    (is (= (mappend self-and-double '(1 10 300)) '(1 2 10 20 300 600)))
    (is (= (numbers-and-negations '(testing 1 2 3 test)) '(1 -1 2 -2 3 -3)))
    (is (= (mappend2 self-and-double '(1 10 300)) '(1 2 10 20 300 600)))
    (is (= ((fn [x] (+ x 2)) 4) 6))
    ))

(deftest _8
  (testing "1.8 Other Data Types"
    (is (= "a string" "a string"))
    (is (= (count "a string") 8))
    (is (= (count "") 0))))

(deftest exercise1.1
  (testing "Exercise 1.1"
    (is (= (last-name2 '(Rex Morgan MD)) 'Morgan))
    (is (= (last-name2 '(Morton Downey Jr.)) 'Downey))))

(deftest exercise1.2
  (testing "Exercise 1.2"
    (is (= (power 3 2) 9))))

(deftest exercise1.3
  (testing "Exercise 1.3"
    (is (= (count-atoms '(a (b) c)) 3))
    (is (= (count-atoms '(a nil c)) 3))
    (is (= (count-atoms '(a () c)) 3))
    (is (= (count-all-atoms '(a (b) c)) 3))
    (is (= (count-all-atoms '(a nil c)) 3))
    (is (= (count-all-atoms '(a () c)) 3))))

;(deftest exercise1.4
;  (testing "Exercise 1.4"
;    (fail)))
;
;(deftest exercise1.5
;  (testing "Exercise 1.5"
;    (fail)))
