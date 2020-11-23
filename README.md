# Edit History Manager

### Introduction:
This project's goal was to create a command history manger utilizing arrays and two different types of ADTs (stacks and dequeues). The project allows the user to input a 
variety of commands that are stored in an array. If the user inputs either "redo" or "undo" then the previously inputted command will either be redone or undone. I utilized 
a Array Dequeue to store "non special" commands (commands that are not redo or undo). I selected this data structure because I needed to push and pop at the front of the 
array (pushing when adding a command to the history or redoing the command and popping when undoing the command). Since we set a limit on the number of commands to be saved 
I also needed to be able to remove from the back of the array, which is why I selected Dequeue. I used an Array Stack to store the values that were undone and potentially
may be redone because all I needed to do was push and pop from the top. The Array Stack was cleared when a non special command was inputted after a command was undone. The other
special command was "quit" to exit the program. 

### How to Run:
To run the project, download the files into a directory. From there, compile EditTester.java and then run it to run the project through the command line. 
