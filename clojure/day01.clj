(ns day01
  "https://adventofcode.com/2015/day/1")

(def input
  (slurp "inputs/input1.txt"))

(def directions
  (map {\( 1 \) -1} input))

(defn solve-part-one []
  (apply + directions))

(defn solve-part-two []
  (->>
    directions
    (reductions +)
    (take-while (complement neg?))
    count
    inc))
