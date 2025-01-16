(ns day01
  "https://adventofcode.com/2015/day/1"
  (:require
    [clojure.string :as str]))

(defn get-input-list []
  (slurp "inputs/input1.txt"))

(defn solve-part-one []
  "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the
  directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the
  instructions one character at a time.

  An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down
  one floor.

  The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

  [examples omitted]

  To what floor do the instructions take Santa?"
  (let [directions (map {\( 1 \) -1} (get-input-list))]
    (apply + directions)))

(defn solve-part-two []
  "Now, given the same instructions, find the position of the first character that causes him to enter the basement
  (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

  [examples omitted]

  What is the position of the character that causes Santa to first enter the basement?"
  (->>
    (get-input-list)
    (map {\( 1 \) -1})
    (reductions +)
    (take-while (complement neg?))
    count
    inc))
