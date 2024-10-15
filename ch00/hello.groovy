print "Hello, groovy world\n"

def langs = ["groovy", "c++", "java"]
println(langs)
println(langs.findAll {it.length() < 4}.join " ")
println(langs.findAll {it.length() >= 3}.join " ")

// print each using a type of foreach
langs.each {println it}
