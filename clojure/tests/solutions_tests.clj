(ns solutions-tests
  (:require
   day01
   [clojure.test :refer [deftest is run-tests successful?]]))

(deftest day01
  (is (= (day01/solve-part-one) 280))
  (is (= (day01/solve-part-two) 1797)))

(let [summary (run-tests)]
  (when-not (successful? summary)
    (throw (Exception. "tests failed"))))
