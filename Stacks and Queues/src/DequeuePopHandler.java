import javax.swing.JOptionPane;
/**
 * This Class inherits from the abstract class "GeneralHandler" - it defines two overloaded constructors, in order to match the overloaded constructors in "GeneralHandler" class.
 * @author AlexeyRaskin ID306058611
 * @author AlexeyPodberezskiy ID323367789
 */
public class DequeuePopHandler extends GeneralHandler
{
	String arr[]=new String[2];
	/**
	 * DequeuePopHandler constructor, initializes a new  EnqueuePushHandler with a reference to a Queue of Integers
	 * @param intQ
	 */
	public DequeuePopHandler(Queue<Integer> intQ)
	{
		super(intQ);
		arr[0]="Dequeued";
		arr[1]="Queue";
	}
	/**
     * DequeuePopHandler constructor, initializes a new  EnqueuePushHandler with a reference to a Stack of Integers
     * @param intSt
     */
	public DequeuePopHandler(Stack<Integer> intSt)
	{
		super(intSt);
		arr[0]="Poped";
		arr[1]="Stack";
	}
	 /**
	   * This method implements the abstract method "processRequest", inherited from GeneralHandler class. This method Dequeue/Pop an item from the Queue/Stack respectively, and presents it on via showMessageDialog method of JOptionPane.
	   */
	public void processRequest()
	{
		int val;
		String message;
		if(this.intQ!=null)  //case of Queue
		{
			if(this.intQ.isEmpty()==true)
			{
				message=String.format("%s is Empty!!!",arr[1]);
				JOptionPane.showMessageDialog(null,message);
				return;
			}
			else val=this.intQ.dequeue();
		}
		else
		{
			if(this.intSt.isEmpty()==true) //case of Stack
			{
				message=String.format("%s is Empty!!!",arr[1]);
				JOptionPane.showMessageDialog(null,message);
				return;
			}
			else val=this.intSt.pop();
		}
		message=String.format("Value %s from %s is: %d",arr[0],arr[1],val);
		JOptionPane.showMessageDialog(null,message);
		
	}

}
