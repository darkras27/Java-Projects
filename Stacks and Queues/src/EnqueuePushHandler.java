import javax.swing.JOptionPane;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class. 
 * @author AlexeyRaskin
 */
 
 public class EnqueuePushHandler extends GeneralHandler 
 {
	 String arr[]=new String[2];
	 
	 /**
	 * EnqueuePushHandler constructor, initializes a new  EnqueuePushHandler with a reference to a Queue of Integers 
	 * @param intQ
	 */
	 public EnqueuePushHandler(Queue<Integer> intQ)
	{
		super(intQ);
		arr[0]="Enqueue";
		arr[1]="Queue";
	}
	/**
	 * EnqueuePushHandler overloaded constructor, initializes a new EnqueuePushHandler with a reference to a Stack of Integers
	 * @param intSt
	 */
	public EnqueuePushHandler(Stack<Integer> intSt)
	{
		super(intSt);
		arr[0]="Push";
		arr[1]="Stack";
	}
	/**
	 * This method implements the abstract method "processRequest", inherited from GeneralHandler class.
	 * This method acquires input from the user via showInputDialog method of JOptionPane Java swing class (input dialog GUI).
	 * It validate the input and if valid puts it in the Queue/Stack respectively.
	 */
	public void processRequest()
	{
		String message=String.format("Please enter a number to %s the %s ",arr[0],arr[1]);
		int val;
		String input=JOptionPane.showInputDialog(message);
		try
		{
			val=Integer.parseInt(input);
		}
		catch(Exception e)
		{
			message=String.format("%s is Not numeric,operation aborted!",input);
			JOptionPane.showMessageDialog(null,message);
			return;
		}
		message=String.format("%s operation of %d successfully completed!",arr[0],val);
		JOptionPane.showMessageDialog(null,message);
		
		if(this.intQ==null)
			this.intSt.push(val);
		else this.intQ.enqueue(val);
		
	}
 }
 