wandc:
	make -C wand/parser
	javac wand/backends/c/*.java wand/generators/*.java wand/*.java wand/parser/*.java

html:
	make -C docs html

cleandoc:
	make -C docs clean

test: wandc
	cd tests && python test.py