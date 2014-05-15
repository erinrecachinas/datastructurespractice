JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(CLASSES)

CLASSES = \
	Node.java \
	Bst.java

default: 
	$(JC) Bst.java Node.java

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
