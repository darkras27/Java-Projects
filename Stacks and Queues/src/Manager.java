import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * This Class implements the state and behavior of the Manager
 * It uses a "Polymorphic" array, that holds references to 6 class 
 *objects that implement the "IntQueueStackHandler" interface.
 * Each implements the "processRequest" abstract method, 
 * in a way that will serve the menu item needed. 
 * @author AlexeyRaskin
 */
 
 class Manager
 {
	 /**
	 * Manager no-argument constructor, initializes a new Stack object and a new Queue object.
	 */
	private Stack <Integer> st=new Stack<Integer>();
	private Queue <Integer> q=new Queue<Integer>();
	private IntQueueStackHandler[] handlers;
	
	
	private void initHandlers()
	{
		handlers = new IntQueueStackHandler[6];
		handlers[0]=new EnqueuePushHandler(q);
		handlers[1]=new DequeuePopHandler(q);
		handlers[2]=new DisplayHandler(q);
		handlers[3]=new EnqueuePushHandler(st);
		handlers[4]=new DequeuePopHandler(st);
		handlers[5]=new DisplayHandler(st);
	}
	
		/**
	 * Manager no-argument constructor, initializes a new Stack object and a new Queue object (of Integer type).
	 */
	public Manager()
	{
		initHandlers();
		int choice;
		int MenuSize=7;
		Scanner val = new Scanner(System.in);
		do {
			displayMenu();
			choice=val.nextInt()-1;	
			if(choice == MenuSize-1)
				break;
			else
				try
			{
				handlers[choice].processRequest();
			}
			catch(Exception e)
			{
				String message=String.format("%d is an invalid choice! Please try again",choice+1);
				JOptionPane.showMessageDialog(null,message);
			}
			
		}while(choice!=6);
		val.close();
	}
	/**
	* This function will print and display the main menu.
	*/
	private void displayMenu() {
		System.out.println("\nMENU");
		String[] MenuArayOption= {"1.Enqueue", "2.Dequeue", "3.Display Queue","4.Push","5.Pop","6.Display Stack","7.Exit"};
		for(String dispayMenu:MenuArayOption)
		{
			System.out.println(dispayMenu);
		}
		System.out.println("---------------------------------------------");
	}
	
	
	/**
	 * static main method simply defines and initializes a new manager object. 
	 * This would invoke its constructor, which then invokes the displayMenu to handle the user choices.
	 */
   public static void main(java.lang.String[] args) {
	   Manager mngr=new Manager();
}
 }