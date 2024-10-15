import groovy.transform.*

def p = new Person(firstName: 'Kunle', lastName: 'Onanuga')
println p

doing()
doing("walking")

def doing(action="Flying") { println action}

println new Pet()?.name  // prints null

def pet = new Pet()
pet?.name='ologbo'

println "$pet, ${pet?.name}"

@EqualsAndHashCode
@TupleConstructor
@ToString
class Person {
  String firstName; String lastName;
}

@Canonical
class Pet { String name }
