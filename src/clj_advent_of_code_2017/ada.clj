(ns clj-advent-of-code-2017.ada
  (:require [clojure.java.io :as io]))

(defn repetition-free?
  "Checks whether words are not repeated in a passphrase"
  [passphrase]
  (let [words (clojure.string/split passphrase #"\s")
        freqs (frequencies words)
        freqs (->> freqs
                  (map #(second %)))]
    (every? #(<= % 1) freqs)))

(defn has-anagram?
  "Checks whether the given word has an anagram in the
  provided words list"
  [word words]
  (let [anagram-candidates (filter #(and (= (count word) (count %))
                                         (not= word %))
                                   words)]
    (if (nil? (some #(= (frequencies word)
                        (frequencies %))
                    anagram-candidates))
      false
      true)))

(defn anagram-free?
  "Checks whether words are not anagrams of any other words
  in a passphrase"
  [passphrase]
  (let [words (clojure.string/split passphrase #"\s")]
    (if (false? (repetition-free? passphrase))
      false
      (every? #(false? %) (map #(has-anagram? % words) words)))))

(defn valid-passphrase-number
  "Returns the number of valid passphrases from the input file
  given a validation function f"
  [filename f]
  (let [passphrases-file (io/resource filename)
        file-content (slurp passphrases-file)
        lines (clojure.string/split file-content #"\n")]
    (->> (map #(f %) lines)
         (filter true?)
         count)))