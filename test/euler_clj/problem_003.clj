(ns euler-clj.problem-003
  (:require [clojure.test :refer :all]))

; Project Euler
;
; Largest Prime Factor
;
; Problem 3
;
; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?
;
; Solution by twcrone

(defn is-factor-of? [base num]
  (zero? (mod base num)))

(defn prime? [n]
  (not-any? (partial is-factor-of? n) (range 2 (long (Math/ceil (Math/sqrt n))))))

(defn candidates [n]
  (range (long (Math/floor (Math/sqrt n))) 2 -1))

(defn prime-factors-of [n]
  (filter prime? (filter (partial is-factor-of? n) (candidates n))))

(defn solve-for [n]
  (first (prime-factors-of n)))

; test
(deftest is-factor-of-true
  (is (is-factor-of? 10 2)))

(deftest is-factor-of-false
  (is (not (is-factor-of? 10 3))))

(deftest base-case
  (is (= (solve-for 13195) 29)))

(run-tests 'euler-clj.problem-003)

; main
(println "Problem 3 Solution: " (solve-for 600851475143))
