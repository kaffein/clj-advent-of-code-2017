(ns clj-advent-of-code-2017.anastasius
  (:require [clojure.java.io :as io]))

(defn maze
  "Computes the maze as each instruction is executed"
  [filename]
  (with-open [rdr (io/reader (io/resource filename))]
    (loop [maze (into [] (map #(Integer/parseInt %) (line-seq rdr)))
           idx 0
           steps 0]
      (let [instruction (nth maze idx)
            next-instruction-idx (+ idx instruction)]
        (if (<= (count maze) next-instruction-idx)
          (inc steps)
          (recur (assoc maze idx (inc instruction))
                 next-instruction-idx
                 (inc steps)))))))

(defn a-maze-ing
  "Computes the maze as each instruction is executed but this time
  if the offset was three or more, instead decrease it by 1. Otherwise,
  increase it by 1 as before."
  [filename]
  (with-open [rdr (io/reader (io/resource filename))]
    (loop [maze (into [] (map #(Integer/parseInt %) (line-seq rdr)))
           idx 0
           steps 0]
      (let [instruction (nth maze idx)
            next-instruction-idx (+ idx instruction)
            f (if (<= 3 instruction)
              dec
              inc)]
        (if (<= (count maze) next-instruction-idx)
          (inc steps)
          (recur (assoc maze idx (f instruction))
                 next-instruction-idx
                 (inc steps)))))))