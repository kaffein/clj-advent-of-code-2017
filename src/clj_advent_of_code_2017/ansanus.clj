(ns clj-advent-of-code-2017.ansanus
  (:require [clojure.java.io :as io]))

(defn valid?
  "Checks whether a passphrase is valid or not"
  [passphrase]
  (let [words (clojure.string/split passphrase #"\s")
        freqs (frequencies words)
        freqs (->> freqs
                  (map #(second %)))]
    (every? #(<= % 1) freqs)))

(defn valid-passphrase-number
  "Returns the number of valid passphrases from the input file"
  [filename]
  (let [passphrases-file (io/resource filename)
        file-content (slurp passphrases-file)
        lines (clojure.string/split file-content #"\n")]
    (->> (map #(valid? %) lines)
         (filter true?)
         count)))