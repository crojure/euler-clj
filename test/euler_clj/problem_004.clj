(ns euler-clj.problem-004
  (:require [clojure.test :refer :all]
            [clojure.string :as string]))

; Project Euler
;
; Largest palindrome product
;
; Problem 4
;
; A palindromic number reads the same both ways. The largest palindrome made from
; the product of two 2-digit numbers is 9009 = 91 × 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.
;
; Solution by twcrone

(defn palindromic? [num] (= (str num) (string/reverse (str num))))

(defn range-for [val]
  (range val 1 -1))

(defn palidromic-products [val]
  (filter palindromic? (map (partial * val) (range-for val))))

(defn solve-for [val]
  (apply max (flatten (map palidromic-products (range-for val)))))

; test
(deftest palindromic-number-true
  (is (palindromic? 101)))

(deftest solve-for-base-case
  (is (= (solve-for 99) 9009)))

(run-tests 'euler-clj.problem-004)

; main
(println "Problem 4 Solution: " (solve-for 999))
