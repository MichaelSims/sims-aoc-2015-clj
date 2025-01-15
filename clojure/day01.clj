(ns day01
  (:require
    [clojure.string :as str]))

(defn get-input-list []
  (str/split (slurp "inputs/input1.txt") #""))

(defn part-one []
  (reduce
    (fn [current-floor character] ((if (= character "(") inc dec) current-floor))
    0
    (get-input-list)))

(defn part-two []
  (->>
    (reduce
      (fn [[current-floor :as full-list] character]
        (let [new-floor ((if (= character "(") inc dec) (or current-floor 0))]
          (conj full-list new-floor)))
      '()
      (get-input-list))
    reverse
    (take-while (complement neg?))
    count
    (+ 1)))
