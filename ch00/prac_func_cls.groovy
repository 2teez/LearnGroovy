import groovy.transform.*

def p = new Person(firstName: 'Kunle', lastName: 'Onanuga')
println p

doing()
doing("walking")

def doing(action="Flying") { println action}

@EqualsAndHashCode
@TupleConstructor
@ToString
class Person {
  String firstName; String lastName;
}
