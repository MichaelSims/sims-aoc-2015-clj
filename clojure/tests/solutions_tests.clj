(ns solutions-tests
  (:require
    day01
    day02
    [clojure.test :refer [deftest is run-tests successful?]]))

(deftest day01
  (is (= (day01/solve-part-one) 280))
  (is (= (day01/solve-part-two) 1797)))

(deftest day02
  (is (= (day02/solve-part-one) 1606483))
  (is (= (day02/solve-part-two) 3842356)))

(let [summary (run-tests)]
  (when-not (successful? summary)
    (throw (Exception. "tests failed"))))
