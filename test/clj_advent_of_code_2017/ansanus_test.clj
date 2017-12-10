(ns clj-advent-of-code-2017.ansanus-test
  (:require [clojure.test :refer :all]
              [clj-advent-of-code-2017.ansanus :refer :all]))

(deftest test-valid?
  (testing "Testing valid? function"
    (is (= true (valid? "aa bb cc dd ee")))
    (is (= false (valid? "aa bb cc dd aa")))
    (is (= true (valid? "aa bb cc dd aaa")))))