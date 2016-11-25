(ns euler-clj.problem-001
  (:require [clojure.test :refer :all]
            [euler-clj.core :refer :all]))

; Project Euler
;
; Multiples of 3 and 5
;
; Problem 1
;
; If we list all the natural numbers below 10 that are multiples of 3 or 5,
; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;
; Find the sum of all the multiples of 3 or 5 below 1000.;
;
; Solution by twcrone

(defn multiple-of? [num denom]
  (= (mod num denom) 0))

(defn multiple-of-3-and-5 [num]
  (if (or (multiple-of? num 3) (multiple-of? num 5))
    num 0))

(defn sum-multiples-of-3-and-5 [max]
  (reduce + (map multiple-of-3-and-5 (range 1 max))))

; test
(deftest base-case
  (is (= (sum-multiples-of-3-and-5 10) 23)))

(run-tests 'euler-clj.problem-001)

; main
(println (sum-multiples-of-3-and-5 999))

