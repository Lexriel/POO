PACKAGE1=lookup
PACKAGE2=bibliotheque
PACKAGE3=immobilier
MAIN1=LookupMain.java

all: doc compil tests arch1

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(PACKAGE1) $(PACKAGE2) $(PACKAGE3)

# generates the main class and its dependant classes
compil:
	mkdir -p classes
	javac -sourcepath src src/$(PACKAGE1)/$(MAIN1) -d classes

# operates some tests (in the background)
# JUNIT.jar is test-1.7.jar (rename it)
tests:
	# javac -classpath JUNIT.jar test/ImageTest.java
	# javac -classpath JUNIT.jar test/PixelTest.java
	# javac -classpath JUNIT.jar test/GrayColorTest.java
	# java -jar JUNIT.jar ImageTest &
	# java -jar JUNIT.jar PixelTest &
	# java -jar JUNIT.jar GrayColorTest &

# creates the jar archive
arch1:
	jar cvfm $(PACKAGE1).jar MANIFEST1.MF docs test -C classes $(PACKAGE1)

# execute the executable archive
exe:
	java -jar $(PACKAGE1).jar

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes $(PACKAGE1).jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
