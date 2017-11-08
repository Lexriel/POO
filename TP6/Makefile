PACKAGE1=image
PACKAGE2=
JAVAMAIN=Main.java

all: doc compil tests arch

# generates documentation
doc:
	mkdir -p docs
	javadoc -sourcepath src -d docs -subpackages $(PACKAGE1) $(PACKAGE2)

# generates the main class and its dependant classes
compil:
	mkdir -p classes
	javac -sourcepath src src/$(PACKAGE1)/$(JAVAMAIN) -d classes

# operates some tests (in the background)
# JUNIT.jar is test-1.7.jar (rename it)
tests:
	javac -classpath JUNIT.jar test/ImageTest.java
	javac -classpath JUNIT.jar test/PixelTest.java
	javac -classpath JUNIT.jar test/GrayColorTest.java
	java -jar JUNIT.jar ImageTest &
	java -jar JUNIT.jar PixelTest &
	java -jar JUNIT.jar GrayColorTest &

# creates the jar archive
arch:
	jar cvfm $(PACKAGE1).jar MANIFEST.MF docs test images -C classes $(PACKAGE1) # -C classes $(PACKAGE2)
# Décommentez la fin de ligne ci-dessus si PACKAGE2 non vide

# standard execution of the executable archive
exe:
	java -jar $(PACKAGE1).jar # /images/fruit.pgm 15 16

# specific execution of the executable archive
exeFruit:
	java -jar $(PACKAGE1).jar /images/fruit.pgm 15 16

# deletes classes, executable jar and files of which names end by ~
clean:
	rm -rf classes $(PACKAGE1).jar
	find . -name "*~" -print | xargs rm -rf

# deletes the documentation
cleanDoc:
	rm -rf docs

# clean a lot of things
realclean: clean cleanDoc
