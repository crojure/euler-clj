(ns euler-clj.problem-006
  (:require [clojure.test :refer :all]
            [clojure.string :as string]))


; Project Euler
;
; 10001st prime
;
; Problem 7
;
; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;
; What is the 10 001st prime number?
;
; Solution by twcrone

(defn is-factor-of? [base num]
  (zero? (mod base num)))

(defn prime? [n]
  (not-any? (partial is-factor-of? n) (range 2 n)))

(prime? 311)

(defn nth-prime [n]
  (nth (filter prime? (range)) (+ n 1)))

(nth-prime 6)

; tests
(deftest sixth-prime
  (is (= (nth-prime 6) 13)))

; main
;(println "Problem 6 Solution: " (diff-sums 100))
