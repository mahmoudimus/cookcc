#!/bin/bash

source ../../bin/settings.sh

v=Foo.java
echo testing $v

cp Parser.java.orig Parser.java

apt $v
compile $v $v
run Foo $v test.input test.output

rm -f Parser.java
rm -f *.class
rm -f output
