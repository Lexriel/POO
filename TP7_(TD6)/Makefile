
RPS=rps
UTIL=util

all: doc compile tests appli exe

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(RPS) $(UTIL)

# generates Robot.class and the dependant classes
compile:
	mkdir -p classes
	javac -sourcepath src src/$(RPS)/RPSGameMain.java -d classes

# operates some tests (in the background)
tests:

# javac -classpath JUNIT.jar test/BoxTest.java
# javac -classpath JUNIT.jar test/RobotTest.java
# java -jar JUNIT.jar BoxTest &
# java -jar JUNIT.jar RobotTest &

# creates the jar archive
appli:
	jar cvfm appli.jar MANIFEST.MF docs test -C classes .

# execute the executable archive
exe:
	java -jar appli.jar

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes appli.jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
