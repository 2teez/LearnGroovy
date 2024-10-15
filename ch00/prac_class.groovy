import groovy.transform.*

new Foo().getFibs(10)
def person = new Person();
person.firstName = "omit"
person.lastName = "programs"

println "$person.firstName - $person.lastName"

//@TypeChecked
//@CompileStatic
class Foo {
    void getFibs(int count) {
        def list = [0, 1]
        count.times {
            println "${list.last()}"
            list << list.sum()
            list = list.tail()
        }
    }
}

@TypeChecked
@CompileStatic
class Person {String firstName; String lastName}
