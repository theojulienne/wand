WAND_SOURCES=\
wand/backends/c/*.java \
wand/generators/*.java \
wand/parser/*.java \
wand/util/*.java \
wand/visitors/*.java \
wand/core/*.java \
wand/*.java \
jargs/gnu/*.java

WAND_CLASSES=$(WAND_SOURCES:.java=.class)

JAVA_OPTIONS=-Xlint:unchecked

wandc:
	make -C wand/parser
	javac $(JAVA_OPTIONS) $(WAND_SOURCES)
	jar cf bin/wand.jar $(WAND_CLASSES)

html:
	make -C docs html

cleandoc:
	make -C docs clean

test: wandc
	cd tests && python test.py