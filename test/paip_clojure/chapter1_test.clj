(ns paip-clojure.chapter1-test
  (:require [clojure.test :refer :all]
            [paip-clojure.core :refer :all]))

(deftest _1
  (testing "1.1"
    (is (= (concat '(Pat Kim) '(Robin Sandy)) '(Pat Kim Robin Sandy)))
    (is (= (concat '(Pat Kim) (list '(John Q Public) 'Sandy)) '(Pat Kim (John Q Public) Sandy)))
    (is (= (count (concat '(Pat Kim) (list '(John Q Public) 'Sandy))) 4))))
