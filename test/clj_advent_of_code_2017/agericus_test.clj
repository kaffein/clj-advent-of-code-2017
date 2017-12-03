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