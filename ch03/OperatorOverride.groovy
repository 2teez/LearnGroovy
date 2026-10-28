package com.practice.operatoroverride;

import groovy.transform.Immutable

@Immutable
class Money {
  int amount
  String currency

  Money plus (Money other) {
      if (other == null) return this
      if (other.currency != currency)
          throw new IllegalArgumentException('Can\'t add different type of Money')
      return new Money(amount + other.amount, currency)
  }

  Money plus (int other) {
      return new Money(amount + other, currency);
  }

}

def buck = new Money(1, 'Naira')
assert buck
assert buck == new Money(1, 'Naira')
assert buck + buck == new Money(2, 'Naira')
assert buck + 3 == new Money(4, 'Naira')
