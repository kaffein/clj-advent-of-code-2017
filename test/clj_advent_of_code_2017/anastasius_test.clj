(ns clj-advent-of-code-2017.anastasius-test
  (:require [clojure.test :refer :all]
            [clj-advent-of-code-2017.anastasius :refer :all]))

(deftest test-maze
  (testing "Testing maze"
    (is (= (maze "day5_test_input.txt") 5))))

(deftest test-a-maze-ing
  (testing "Testing a-maze-ing"
    (is (= (a-maze-ing "day5_test_input.txt") 10))))