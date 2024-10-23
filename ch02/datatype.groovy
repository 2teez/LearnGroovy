#!/usr/bin/env groovy

println fac(896)

BigInteger fac(number) {
  if (number == 0) return 1
  else return number * fac(number -1)
}
