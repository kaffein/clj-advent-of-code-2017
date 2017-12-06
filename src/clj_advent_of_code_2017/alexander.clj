(ns clj-advent-of-code-2017.alexander)

(defn get-row-min-max-diff
  "Calculates the min and max difference"
  [row]
  (- (apply max row) (apply min row)))

(defn find-first
  "Find the first item satisfying the predicate"
  [pred coll]
  (first (filter pred coll)))

(defn divisible?
  "Returns true if num is divisible by div"
  [num div]
  (= 0 (mod num div)))

(defn evenly-divisible?
  "Returns true if the two numbers are evenly divisible"
  [x y]
  (if (or (divisible? y x)
          (divisible? x y))
    true
    false))

(defn divide-evenly-divisible-values
  "Calculates the return value of dividing x by y or y by x"
  [x y]
  (if (> x y)
    (/ x y)
    (/ y x)))

(defn get-row-evenly-divisible-value
  "Calculates for each row evenly divisible values division"
  [row]
  (let [duals (for [x row
                    y (filter #(not= x %) row)]
                [x y])
        matched-dual (find-first #(evenly-divisible? (first %) (last %)) duals)]
    (divide-evenly-divisible-values (first matched-dual) (last matched-dual))))

(defn checksum-sum
  "Calculates the checksum of all rows by getting the sum of
  each rows max and min values"
  [rows]
  (reduce + (map #(get-row-min-max-diff %) rows)))

(defn checksum-div
  "Calculates the checksum of all rows by getting the div of
  each rows evenly distributed values"
  [rows]
  (reduce + (map #(get-row-evenly-divisible-value %) rows)))