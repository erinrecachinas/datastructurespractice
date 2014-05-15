JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(CLASSES)

CLASSES = \
	List.java \
	ListItr.java \
	Node.java

default: 
	$(JC) List.java ListItr.java Node.java

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
