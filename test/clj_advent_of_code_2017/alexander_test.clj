(ns clj-advent-of-code-2017.alexander-test
  (:require [clojure.test :refer :all]
            [clj-advent-of-code-2017.alexander :refer :all]))

(deftest test-row-min-max-diff
  (testing "Testing row-min-max-diff"
    (is (= (row-min-max-diff [5 1 9 5]) 8))
    (is (= (row-min-max-diff [7 5 3]) 4))
    (is (= (row-min-max-diff [2 4 6 8]) 6))))

(deftest test-checksum
  (testing "Testing checksum"
    (is (= (checksum [[5 1 9 5] [7 5 3] [2 4 6 8]]))) 18))