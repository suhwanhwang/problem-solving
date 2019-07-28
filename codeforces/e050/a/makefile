GS = -g
JC = javac
TEST_INPUT = test_in.txt

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java 

default: run

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run: classes
	java Main < $(TEST_INPUT)
