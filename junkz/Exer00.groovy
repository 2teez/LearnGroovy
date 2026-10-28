#!/usr/bin/env groovy
package com.practice.exer00;

// 1
def printer = {x -> x * 3}
def result = printer(3)
println("$result, ${result.getClass()}")

counter = ''
10.downto(-2) {
  counter += it + ' '
}

assert counter == '10 9 8 7 6 5 4 3 2 1 0 -1 -2 '

counter = ''
0.upto(5) {
    counter += it + ' '
}

assert counter == "0 1 2 3 4 5 "
