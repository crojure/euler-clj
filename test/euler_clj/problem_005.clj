(ns euler-clj.problem-005
  (:require [clojure.test :refer :all]
            [clojure.string :as string]))


; Project Euler
;
; Smallest Multiple
;
; Problem 5
;
; 2520 is the smallest number that can be divided by each of the numbers from 1
; to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all of the
; numbers from 1 to 20?
;
; Solution by twcrone

(defn divisible-by? [n d]
  (= (mod n d) 0))

(defn divisible-by-all? [vals num]
  (every? (partial divisible-by? num) vals))

(defn solve-for [top]
  (first (filter (partial divisible-by-all? (range 2 top)) (iterate (partial + top) top))))

; tests
(deftest base-case
  (is (= (solve-for 10) 2520)))

(deftest solve-for-1
  (is (= (solve-for 1) 1)))

(deftest solve-for-5
  (is (= (solve-for 5) 60)))

(deftest solve-for-15
  (is (= (solve-for 15) 360360)))

(run-tests 'euler-clj.problem-005)

; main
(println "Problem 5 Solution: " (solve-for 20))
