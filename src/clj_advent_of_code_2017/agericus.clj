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


(defn pre-process-data-halfway
  "Pre-processes input by extracting the digits but this time add the first
  half of the digits list at the end to make the sequence circular"
  [input]
  (let [digits (vec (map
                      #(Character/getNumericValue %)
                      (seq (str input))))]
    (into digits (take (/ (count digits) 2) digits))))

(defn get-input-size
  "Returns the number of digits in the sequence"
  [input]
  (count (str input)))

(defn captcha-halfway
  "Processes the captcha by taking into account the digit halfway around
  the circular list instead of the next one in line"
  [input]
  (let [digits (pre-process-data-halfway input)]
    (loop [acc 0
           partitioned-digits (partition (+ 1 (/ (get-input-size input) 2)) 1 digits)]
      (if (empty? partitioned-digits)
        acc
        (if (= (-> partitioned-digits first first)
               (-> partitioned-digits first last))
          (recur (+ acc (-> partitioned-digits first first))
                 (rest partitioned-digits))
          (recur acc (rest partitioned-digits)))))))