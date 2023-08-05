JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
    $(JC) $(JFLAGS) $*.java

CLASSES = \
    Calculator.java \
    CalculatorImplementation.java \
    CalculatorServer.java \
    CalculatorClient.java

MAIN1 = CalculatorServer
MAIN2 = CalculatorClient

default: classes

classes: $(CLASSES:.java=.class)

run_server: classes
    $(JVM) $(MAIN1)

run_client: classes
    $(JVM) $(MAIN2)

clean:
    $(RM) *.class
