#!/bin/bash

source ../../../bin/settings.sh

for v in *.xcc
do
	echo testing $v

	INPUT=${v%.xcc}.input
	OUTPUT=${v%.xcc}.output

	cookcc $v
	compile $v Lexer.java
	run Lexer $v $INPUT $OUTPUT

	rm -f Lexer.java
	rm -f Lexer*.class
	rm -f output
done
