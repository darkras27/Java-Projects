/**
 * @author AlexeyRaskin
 */
 
 public abstract class GeneralHandler implements IntQueueStackHandler
 {
	 protected Queue<Integer> intQ;
	 protected Stack<Integer> intSt;
	 
	 /**
	 * GeneralHandler constructor, initializes a new GeneralHandler 
	 * with a reference to a Queue of Integers (the Stack reference will be
	 * initialized to null by default).
	 **/
	 
	 public GeneralHandler(Queue<Integer> intQ)     //Queue constructor
	{
		this.intQ = intQ;
	}
	 
	 public GeneralHandler(Stack<Integer> intSt)   //Stack constructor
	{
	    this.intSt = intSt;
	}
 }