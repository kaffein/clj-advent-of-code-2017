(ns clj-advent-of-code-2017.agericus-test
  (:require [clojure.test :refer :all]
            [clj-advent-of-code-2017.agericus :refer :all]))

(deftest test-pre-process-data
  (testing "Testing pre-process-data"
    (is (= (pre-process-data 1122) [1 1 2 2 1] ))
    (is (= (pre-process-data 409) [4 0 9 4]))))

(deftest test-catpcha
  (testing "Testing captcha"
    (is (= (captcha 1122) 3))
    (is (= (captcha 1111) 4))
    (is (= (captcha 1234) 0))
    (is (= (captcha 91212129) 9))))

(deftest test-pre-process-data-halfway
  (testing "Testing pre-process-data-halfway"
    (is (= (pre-process-data-halfway 1122) [1 1 2 2 1 1]))
    (is (= (pre-process-data-halfway 4091) [4 0 9 1 4 0]))))

(deftest test-get-input-size
  (testing "Get input size"
    (is (= (get-input-size 1212) 4))
    (is (= (get-input-size 123425) 6))))

(deftest test-catpcha-halfway
  (testing "Testing captcha-halfway"
    (is (= (captcha-halfway 1212) 6))
    (is (= (captcha-halfway 1221) 0))
    (is (= (captcha-halfway 123425) 4))
    (is (= (captcha-halfway 123123) 12))
    (is (= (captcha-halfway 12131415)) 4)))