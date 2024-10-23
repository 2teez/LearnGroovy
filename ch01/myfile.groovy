Book gina = new Book('Groovy in Action')
assert gina.getTitle() == 'Groovy in Action'

assert getTitleBackwards(gina) == 'noitcA ni yvoorG'

String getTitleBackwards(book) {
    return book.getTitle().reverse()
}
