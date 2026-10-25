#!/usr/bin/env groovy
import com.practice.book.Book

Book gina = new Book('Groovy in Action')

assert gina.getTitle() == 'Groovy in Action'
assert getTitleBackWard(gina) == 'noitcA ni yvoorG'

String getTitleBackWard(book) {
    return book.getTitle().reverse()
}
