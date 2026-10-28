#!/usr/bin/env groovy
package com.practice.exer01

import groovy.transform.*

@TypeChecked
class FibonacciSeries {
  void getNumber(int count) {
    def nums = [0G, 1G]
    print "${nums.head()} "
    count.times {
      print "${nums.last()} "
      nums << nums[0] + nums[1]
      nums = nums.tail()
    }
    println()
  }
}

new FibonacciSeries().getNumber(12)
