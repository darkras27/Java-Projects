import javax.swing.JOptionPane;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class.
 * @author AlexeyRaskin ID306058611
 * @author AlexeyPodberezskiy ID323367789
 */
 
 public class DisplayHandler extends GeneralHandler
 {
	 String msg; //no need to initialize, it's null by default
	 
	 /**
	 * DisplayHandler constructor, initializes a new  EnqueuePushHandler with a reference to a Queue of Integers 
	 * @param intQ
	 */
	public DisplayHandler(Queue<Integer> intQ)
	{
		super(intQ);
		msg="Queue";
	}
	 /**
	 *  * DisplayHandler constructor, initializes a new  EnqueuePushHandler with a reference to a Stack of Integers 
	 * @param intSt
	 */
	public DisplayHandler(Stack<Integer> intSt)
	{
		super(intSt);
		msg="Stack";
	}
	 
	 /**
	 * This method implements the abstract method "processRequest", inherited from GeneralHandler class.
	 * This method display the contents of the Queue/Stack respectively - present it on a GUI message dialog, using showMessageDialog method of JOptionPane Java swing class.
	 */
	public void processRequest()
	{
		String message;
		String st;
		if(this.intQ!=null)
		{
			st=intQ.toString();
			message=String.format("%s contents is: %s",msg,st);
		}
		else
		{
			st=intSt.toString();
			message=String.format("%s contents is: %s",msg,st);
		}
		JOptionPane.showMessageDialog(null,message);
	}
	 
 }