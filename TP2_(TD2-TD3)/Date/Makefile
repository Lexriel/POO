CC=javac
ARCH=test-1.7.jar

all: Date Month DateMain test

Date: Date.java
	$(CC) $<

Month: Month.java
	$(CC) $<

DateMain: DateMain.java
	$(CC) $<

test: DateTest.java
	javac -classpath .:$(ARCH) $<
	java -jar $(ARCH) DateTest

clear:
	rm -rf *~
	rm -rf *.class
