
/**
* @author Emanuel Eagle <eeagle@conncoll.edu>
* @class COM212 
* @dueDate 11/6/2020
**/



public class EditManager{

  /**
  *This Array DQueue variable is used to intialize a string Array DQueue class to store non special command histories */
 
  private ArrayDQueue<String> historyQueue = new ArrayDQueue<String>();

  /**
  *This Array Stack variable is used to intiailize a string array stack to store undone commands */

  private ArrayStack<String> undoneHistory = new ArrayStack<String>();

  /**
  *This int variable is used to store the value that defines the capacity of the command history dequeue */

  private int maxEntries;

  public EditManager(){

  	/**
  	*Constructor method that sets the maxEntries variable to 10 */

    maxEntries = 10; //set max entries to 10

  }

  public void maintainLimit(){

  	/**
  	* Keeps the size of the non special history dequeue to 10. 
  	*/

    if(historyQueue.size() == maxEntries){ //if size of queue is 10
      historyQueue.removeLast(); //remove last or oldest entry
    }
  }

  public void add2History(String command){

  	/**
  	* This adds non special commands to the command history dequeue
  	* <p> This class adds the string that is a parameter of the function to the history queue. This method also checks
  	to see if the undoneHistory stack has commands in it. If it does then it goes ahead and removes those commands
  	from the undoneHistory stack. 

  	@param string a command that has been inputted by the user and is read in the main method
  	*/

    historyQueue.addFirst(command); //this adds the input to the front of the queue
    if(undoneHistory.size() > 0 ){ //since to implement redo we need to clear the undo history if a command that isn't undo
    //is inputted, this checks to see if the undoneHistory stack has any values in it
      while(!undoneHistory.isEmpty()){ //if it does then this while loop runs until it is empty
        undoneHistory.pop(); //the while loop simply pops every value out until the undoneHistory.isEmpty() 
        //funtion returns true
      }
    }
  }

  public void undoFunction(){

  	/**
  	* This undo function removes the most recently inputted command from the history and stores it in the undoneHistory 
  	* <p> This starts by checking to see if the historyQueue is empty, if it is the funtion tells the user that there
  	is history to be undone. If there is history to be undone then the method removes the most recently added command from
	the history and stores it in the undoneHistory stack so that it can be accessed by the redo function. It then
	prints what command was undone. 
	*/

    if(historyQueue.isEmpty()){ //first checks if the history queue dequeue is empty
      System.out.println("No more edit history to undo"); //if empty, prints this statement
    }
    else{

      /**
      * This string variable is used to store the command that has been undone so that it can be added to the undoneHistory
      stack
      */
      
      String undoneCommand = historyQueue.removeFirst();
      System.out.println("Undone "+undoneCommand+" command"); //the print statement says what was undone
      undoneHistory.push(undoneCommand); //then the string is pushed to the top of a stack that stores the undone command
      //history, this will be accessed by the redo function
    }
  }

  public void redoFunction(){

  	/**
  	* This redo function removes the most recently undone command from the undone history and adds it back to command history 
  	* <p> This starts by checking to see if the undoneHistory stack is empty. If it is not empty then it removes (pops) 
  	the most recently added command from the undoneHistory stack and adds it back to the front of the history dequeue.
  	It then prints what command was redone. 
  	*/

    if(undoneHistory.isEmpty()){ //first checks if the undonehistory stack is empty
      System.out.println("No more edit entry to redo"); //if empty, prints this statement
    }
    else{

      /*
      This string variable is used to store the command that has been redone so that it can be added back to the
      historyQueue 
      */

      String redoneCommand = undoneHistory.pop();
      historyQueue.addFirst(redoneCommand); //this stored value is then added back to the front of the dequeue
      System.out.println("Redid "+redoneCommand+" command"); //print statement says what was redone
    }
  }
}