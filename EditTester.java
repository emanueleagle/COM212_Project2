import java.util.Scanner;

/**
* @author Emanuel Eagle <eeagle@conncoll.edu>
* @class COM212 
* @dueDate 11/6/2020
**/

class EditTester {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); //intialize a scanner object to take user input
		EditManager history = new EditManager(); //intialize history object to use EditManager class
    while(true){ //continously run
      System.out.println("Type expression:"); //prints prompt to input command
      String command = input.nextLine(); //takes command and stores it as a string
      if(command.equals("quit")){ //if command is the quit command
        System.out.println("Good-bye!"); 
        break; //breaks the continously running while loop
      }
      else{ //if the command is not the word "quit"
        history.maintainLimit(); //first checks to make sure that the history queue doesnt have 10 entries
        if(command.equals("undo")){ //checks if command is the special command "undo"
          history.undoFunction(); //if it is, runs the undo method
        }
        else if(command.equals("redo")){ //checks if the command is the special commad "redo"
          history.redoFunction(); //if it is, runs the redo method
        }
        else{
          history.add2History(command); //since we have already checked for all three special commands, 
          //we know that any other string inputted is just going to be a command to be stored in the history
        }
      }
    }
  }
}