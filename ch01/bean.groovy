import groovy.transform.Immutable

class BookBean {
    String title
}

def groovyBook = new BookBean()
groovyBook.setTitle('Groovy in Action')
assert groovyBook.getTitle() == 'Groovy in Action'

groovyBook.title = 'Groovy conquers the world'
assert groovyBook.title == 'Groovy conquers the world'

@Immutable
class FixedBean {
    String title
}

def gina = new FixedBean('Groovy in Action')
def regina = new FixedBean(title: 'Groovy in Action')

assert gina.title == 'Groovy in Action'
assert gina == regina

try {
    regina.title = "Oops"
    assert false, "Should not get here"
} catch (ReadOnlyPropertyException excepted) {
    println("Excepted Error: $excepted.message")
}
