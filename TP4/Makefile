all: doc Robot.class tests appli.jar exe

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages example

# generates Robot.class and the dependant classes
Robot.class:
	mkdir -p classes
	javac -sourcepath src src/example/Robot.java -d classes

# operates some tests (in the background)
tests:
	javac -classpath JUNIT.jar test/BoxTest.java
	javac -classpath JUNIT.jar test/RobotTest.java
	java -jar JUNIT.jar BoxTest &
	java -jar JUNIT.jar RobotTest &

# creates the jar archive
appli.jar:
	jar cvfm appli.jar MANIFEST.MF docs test -C classes example

# execute the executable archive
exe:
	java -jar appli.jar

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes appli.jar
	# command cleaning all the files finishing by ~ in the arborescence
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
