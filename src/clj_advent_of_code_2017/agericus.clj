(ns clj-advent-of-code-2017.agericus)

(defn pre-process-data
  "Pre-processes input by extracting the digits and adding the first digit
  at the end to make the sequence circular"
  [input]
  (let [digits (vec (map
                      #(Character/getNumericValue %)
                      (seq (str input))))]
    (conj digits (first digits))))

(defn captcha
  "Processes the captcha"
  [input]
  (let [digits (pre-process-data input)]
    (loop [acc 0
           partitioned-digits (partition 2 1 digits)]
      (if (empty? partitioned-digits)
        acc
        (if (= (-> partitioned-digits first first)
               (-> partitioned-digits first last))
          (recur (+ acc (-> partitioned-digits first first))
                 (rest partitioned-digits))
          (recur acc (rest partitioned-digits)))))))