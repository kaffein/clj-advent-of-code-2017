(ns clj-advent-of-code-2017.ada-test
  (:require [clojure.test :refer :all]
            [clj-advent-of-code-2017.ada :refer :all]))

(deftest test-repetition-free?
  (testing "Testing repetition-free? function"
    (is (= true (repetition-free? "aa bb cc dd ee")))
    (is (= false (repetition-free? "aa bb cc dd aa")))
    (is (= true (repetition-free? "aa bb cc dd aaa")))))

(deftest test-has-anagram?
  (testing "Testing has-anagram? function"
    (is (= false (has-anagram? "abcde" ["abcde" "fghij"])))
    (is (= true (has-anagram? "ecdab" ["abcde" "xyz" "ecdab"])))
    (is (= false (has-anagram? "ab" ["a" "ab" "abc" "abd" "abf" "abj"])))
    (is (= false (has-anagram? "oiii" ["iiii" "oiii" "ooii" "oooi" "oooo"])))
    (is (= true (has-anagram? "iioi" ["oiii" "ioii" "iioi" "iiio"])))))

(deftest test-anagram-free?
  (testing "Testing anagram-free? function"
    (is (= true (anagram-free? "abcde fghij")))
    (is (= false (anagram-free? "abcde xyz ecdab")))
    (is (= true (anagram-free? "a ab abc abd abf abj")))
    (is (= true (anagram-free? "iiii oiii ooii oooi oooo")))
    (is (= false (anagram-free? "oiii ioii iioi iiio")))))