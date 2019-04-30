(ns paip-clojure.core)

(defn main
  []
  (do
    (println (concat '(Pat Kim) '(Robin Sandy)))
    (println (concat '(Pat Kim) (list '(John Q Public) 'Sandy)))
    (println (count (concat '(Pat Kim) (list '(John Q Public) 'Sandy))))))
