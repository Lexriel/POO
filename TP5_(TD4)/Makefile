
DIR=hanoi
IO=io
javaMain=HanoiMain.java

all: doc compile tests appli exe

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(DIR) $(IO)

# generates Robot.class and the dependant classes
compile:
	mkdir -p classes
	javac -sourcepath src src/$(DIR)/$(javaMain) -d classes

# operates some tests (in the background)
tests:
	javac -classpath test.jar test/DiscTest.java
	javac -classpath test.jar test/TowerTest.java
	javac -classpath test.jar test/HanoiTest.java
	java -jar test.jar DiscTest &
	java -jar test.jar TowerTest &
	java -jar test.jar HanoiTest &

# creates the jar archive
appli:
	jar cvfm $(DIR).jar MANIFEST.MF docs test -C classes .

# execute the executable archive
exe:
	java -jar $(DIR).jar 4

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes $(DIR).jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
