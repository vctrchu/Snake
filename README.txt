Readme file for Snake Game Project
Group 14 of CPSC 233
Authors: Austin Levesque, Chris O'Reilly, Steven Canon-Almagro, Victor Chu

All commands must be inputed from the ...\Snake\src directory



For GUI:

Compile:
Type "javac run/GUIMainMenu.java" without quotations and press enter

Run:
Type "java run.GUIMainMenu" without quotations and press enter




For Text-based:

Compile:
Type "javac run/Textbase_Run.java" without quotations and press enter

Run:
Type "java run.Textbase_Run" without quotations and press enter




For Test Files:

Compile:
Type "javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java" without quotations and press enter

Run:
Type "java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>" without quotations, where <test class> is the name of the test class file you want to run.
Eg. if you wanted to run the SnakeTest.java test, you would type "java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore SnakeTest" without quotations and press enter




Code Limitations:
- In GUI, When both snakes reach a piece of food at the exact same time, player 1 will eat the food first due to it being checked first in the code.
- In GUI, When the snakes have a combined total tail size of 1 or less, head collision will not work
- 2 Player snake not implemented in text-based
- Update rate or the "Speed" of the game is 400ms, making it somewhat slow paced. This could be increased by changing the timer on line 90 of GUI.java from 400ms to something quicker like 100ms, but the lab computers get laggy and choppy at this speed despite our own home computers running it fine.
