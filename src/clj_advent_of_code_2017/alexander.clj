(ns clj-advent-of-code-2017.alexander)

(defn row-min-max-diff
  "Calculates the min and max difference"
  [row]
  (- (apply max row) (apply min row)))

(defn checksum
  "Calculates the checksum of all rows"
  [rows]
  (reduce + (map #(row-min-max-diff %) rows)))