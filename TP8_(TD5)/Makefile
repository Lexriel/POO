all: RentalAgency.class doc appli.jar exe

# generates Robot.class and the dependant classes
RentalAgency.class: src/agence/RentalAgency.java
	mkdir -p classes
	javac -sourcepath src src/agence/RentalAgency.java -d classes

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages agence

# operates some tests (in the background)
test: #test/BoxTest.java test/RobotTest.java
# 	javac -classpath test-1.7.jar test/BoxTest.java
# 	javac -classpath test-1.7.jar test/RobotTest.java
# 	java -jar test-1.7.jar BoxTest &
# 	java -jar test-1.7.jar RobotTest &

# creates the jar archive
appli.jar:
	jar cvfm appli.jar manifest.txt docs src test -C classes agence

# execute the executable archive
exe: appli.jar
	java -jar appli.jar

# deletes classes, docs and executable jar
clean:
	rm -rf classes docs appli.jar *~
