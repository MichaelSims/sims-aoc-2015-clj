(ns day02
  "https://adventofcode.com/2015/day/2"
  (:require [clojure.string :as str]))

(def input
  (slurp "inputs/input2.txt"))

(def input-lines (str/split-lines input))

(defn str->int [str] (Integer/parseInt str))

(defn line->dimensions [line] (map str->int (str/split line #"x")))

(defn min-side-area [[l w h]] (min (* l w) (* w h) (* l h)))

(defn surface-area [[l w h]] (+ (* 2 l w) (* 2 w h) (* 2 h l)))

(defn min-perimeter [[l w h]]
  (min
    (* 2 (+ w h))
    (* 2 (+ l h))
    (* 2 (+ w l))))

(defn volume [[l w h]] (* l w h))

(defn solve-part-one []
  (apply
    +
    (map
      (fn [line]
        (let [box (line->dimensions line)]
          (+ (min-side-area box) (surface-area box))))
      input-lines)))

(defn solve-part-two []
  (apply
    +
    (map
      (fn [line]
        (let [box (line->dimensions line)]
          (+ (min-perimeter box) (volume box))))
      input-lines)))
