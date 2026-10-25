#!/usr/bin/env groovy
import com.practice.jbook.JBook

JBook gina = new JBook('Groovy in Action')

assert gina.getTitle() == 'Groovy in Action'
assert getTitleBackWard(gina) == 'noitcA ni yvoorG'

def getTitleBackWard(book) {
    return book.getTitle().reverse()
}
