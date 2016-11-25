(ns euler-clj.problem-004
  (:require [clojure.test :refer :all]
            [clojure.string :as string]))



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

(defn palindromic? [num] (= (str num) (string/reverse (str num))))

(defn palidromic-products [val]
  (filter palindromic? (map (partial * val) (range val 1 -1))))

(println (palidromic-products 999))

(defn solve-for [val]
  (apply max (flatten (map palidromic-products (range val 1 -1)))))

; test
(deftest palindromic-number-true
  (is (palindromic? 101)))

(deftest solve-for-base-case
  (is (= (solve-for 99) 9009)))

(run-tests 'euler-clj.problem-004)

; main
(println "Problem 4 Solution: " (solve-for 999))
