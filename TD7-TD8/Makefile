
DIR=formation
javaMain=Formation.java

all: doc compile tests appli exe

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(DIR)

# generates Robot.class and the dependant classes
compile:
	mkdir -p classes
	javac -sourcepath src src/$(DIR)/$(javaMain) -d classes

# operates some tests (in the background)
tests:
# javac -classpath JUNIT.jar test/BoxTest.java
# javac -classpath JUNIT.jar test/RobotTest.java
# java -jar JUNIT.jar BoxTest &
# java -jar JUNIT.jar RobotTest &

# creates the jar archive
appli:
	jar cvfm $(DIR).jar MANIFEST.MF docs test -C classes .

# execute the executable archive
exe:
	java -jar $(DIR).jar

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes $(DIR).jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
