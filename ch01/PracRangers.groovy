#!/usr/bin/env groovy
package com.practice.pracrangers;

def ranges = 1..10

assert ranges.from == 1, "gets the start of range"
assert !ranges.contains(71), "check one of the value of range"
assert ranges.reverse() == 10..1, "reverse the range"
assert ranges.size() == 10, "check the size of range"
assert ranges.contains(7), "check the number 7 is contained in the range"
assert ranges.to == 10, "the end of the range."
