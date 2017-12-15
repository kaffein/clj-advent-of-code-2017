(ns clj-advent-of-code-2017.bibiana-test
  (:require [clojure.test :refer :all]
            [clj-advent-of-code-2017.bibiana :refer :all]))

(deftest test-get-row-min-max-diff
  (testing "Testing get-row-min-max-diff"
    (is (= (get-row-min-max-diff [5 1 9 5]) 8))
    (is (= (get-row-min-max-diff [7 5 3]) 4))
    (is (= (get-row-min-max-diff [2 4 6 8]) 6))))

(deftest test-find-first
  (testing "Testing find-first"
    (is (= (find-first #(= 3 (/ % 3)) [5 1 9 5]) 9))
    (is (= (find-first #(= 4 (* % 2)) [2 4 6 8]) 2))))

(deftest test-divisible?
  (testing "Testing divisible?"
    (is (= (divisible? 6 5) false))
    (is (= (divisible? 8 4) true))
    (is (= (divisible? 2 4) false))))

(deftest test-are-evenly-divisible?
  (testing "Testing are-evenly-divisible?"
    (is (= (evenly-divisible? 6 5) false))
    (is (= (evenly-divisible? 8 4) true))
    (is (= (evenly-divisible? 2 4) true))))

(deftest test-divide-evenly-divisible-values
  (testing "Testing get-evenly-divisible-values"
    (is (= (divide-evenly-divisible-values 2 4) 2))
    (is (= (divide-evenly-divisible-values 8 2) 4))))

(deftest test-get-row-evenly-divisible-value
  (testing "Testing get-row-evenly-divisible-value"
    (is (= (get-row-evenly-divisible-value [5 9 2 8]) 4))
    (is (= (get-row-evenly-divisible-value [9 4 7 3]) 3))
    (is (= (get-row-evenly-divisible-value [3 8 6 5]) 2))))

(deftest test-checksum-sum
    (testing "Testing checksum-sum"
      (is (= (checksum-sum [[5 1 9 5]
                            [7 5 3]
                            [2 4 6 8]]))) 18))

(deftest test-checksum-div
    (testing "Testing checksum-div"
      (is (= (checksum-div [[5 9 2 8]
                            [9 4 7 3]
                            [3 8 6 5]]) 9))))

(deftest test-generic-checksum
  (testing "Testing generic checksum calculation"
    (is (= (generic-checksum get-row-min-max-diff [[5 1 9 5]
                                                   [7 5 3]
                                                   [2 4 6 8]]))) 18))

(deftest test-checksum-div
  (testing "Testing checksum-div"
    (is (= (generic-checksum get-row-evenly-divisible-value [[5 9 2 8]
                                                             [9 4 7 3]
                                                             [3 8 6 5]]) 9))))