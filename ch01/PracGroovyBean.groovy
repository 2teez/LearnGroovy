#!/usr/bin/env groovy
package com.practice.pracgroovybean;

import groovy.transform.Immutable

@Immutable class FixedBean {
    String title
}

def gina = new FixedBean(title: 'Groovy in Action')
def regina = new FixedBean('Groovy in Action')

assert gina == regina
assert gina.title == 'Groovy in Action'

try {
  gina.title = 'Oops'
  assert false, 'shouldn\'t get here'
} catch(ReadOnlyPropertyException ex) {
  println "Expected Error: '$ex.message'"
}
