PCK1=goosegame
PCK2=
MAIN=Main.java

all: doc compile tests jar exe

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(PCK1) $(PCK2)

# compiles the main class and its dependant classes
compile:
	mkdir -p classes
	javac -sourcepath src src/$(PCK1)/$(MAIN) -d classes

tests:
	make GameTest
	make PlayerTest

# operates some tests (in the background)
%Test:
	javac -classpath JUNIT.jar test/$@.java
	java -jar JUNIT.jar $@ &

# creates the jar archive
jar:
	jar cvfm $(PCK1).jar MANIFEST.MF docs test -C classes .

# execute the executable archive
exe:
	java -jar $(PCK1).jar

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes $(PCK1).jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
