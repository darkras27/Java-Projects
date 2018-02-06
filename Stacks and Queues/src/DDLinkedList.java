
/**
 * This Class implements the state and behavior of basic doubly linked list infrastructure
 * @author AlexeyRaskin ID306058611
 * @author AlexeyPodberezskiy ID323367789
 */
 
import java.util.NoSuchElementException;
 
public class DDLinkedList <T>{
 	private ListElement <T>head;
 	private ListElement <T>tail;
	
	
	/**
	 * Add an element to the head of the list
	 * @param val - the integer value to be added to the head of the list
	 */
 	protected void addToHead(T val)
	{
		 ListElement <T> temp = new ListElement <T>(val,head,null);
		 if(head != null)
		 {
			 head.setPrev(temp);
			 head = head.getPrev();
		 }
		 else
			head=tail=temp;	
 	}
	
 	
	 /**
	 * Add an element to the tail of the list
	 * @param val - the integer value to be added to the tail of the list
	 */
 	protected void addToTail(T val){
		 ListElement <T>temp = new ListElement<T>(val,null,tail);
		 if(tail!= null)
		 {
			 tail.setNext(temp);
			 tail = tail.getNext();
		 }
		 else
			 head=tail=temp;	
 	} 	
	
	
	 /**
	 * Removes an element from the head of the list
	 * @return the value of the element removed, or -1 if the list is empty.
	 */
 	protected T removeFromHead()
	{
	 	if(head == null) return null;
	 	T tempVal=head.getVal();
		head=head.getNext();
	 	if(head == null)
		{
		 	tail=null;
		 	return tempVal;
		}
		else
		{
			
			head.setPrev(null);
		}
 		
 		return (T)tempVal;
	}
	
	 
	 /**
	 * Removes an element from the tail of the list
	 * @return the value of the element removed, or -1 if the list is empty.
	 */
 	protected T removeFromTail(){
	 	if(tail == null) return null;
	 	T tempVal=tail.getVal();
		tail = tail.getPrev();
	 	if(tail ==null)
		{
		 	head=null;
		 	return tempVal;
		}
		else
			tail.setNext(null);
 		return (T)tempVal;
 	}
	
	/**
	 * Add an already allocated element to the list, before a given element.
	 * @param newElm - the allocated element to be added to the list
	 * @param beforeElm - the existing element to add newElm before it. If beforeElm == null, means add after tail
	 * If beforeElm == NULL, means add after tail
	 */
 	protected void addElm(ListElement <T>newElm, ListElement <T>beforeElm)

	{	
		//list is empty
		if(head == null && tail == null)
		{
			System.out.println("addElm::List is Empty!");
			return;
		}
		//Case the new element should be added before the head
	 	if(head==beforeElm){
			newElm.setNext(beforeElm);
			beforeElm.setPrev(newElm);
			head=newElm;
	 	}
		//Case the new element should be added after the tail
		if (beforeElm == null)
		{
			tail.setNext(newElm);
			newElm.setPrev(tail);

			tail = newElm;

			return;
		}
		newElm.setNext(beforeElm);
		newElm.setPrev(beforeElm.getPrev());
		beforeElm.getPrev().setNext(newElm);
		beforeElm.setPrev(newElm);
 	}
	/**
	 * Display ALL the elements in the list. Notice the use of the reference to element to the ListElement in the call to System.out.println. 
	 * Since this call expects a String argument, if it gets a reference object (rather than a primitive type), it automatically invokes its "toString" method.
	 */
	 
	 public String toString()
	 {
		 if(this.isEmpty())
			return "List is empty!";
		ListElement <T>elem = head;
		String st = "";
		while(elem != null)
		{
			st += elem.toString() + ' ';
			elem = elem.getNext();
			
		}
		return st;

	 }
 	
	
	
	/**
	 * Indicates whether or not the list is empty.
	 * @return true if the list is empty; otherwise, false.
	 */
 	public boolean isEmpty(){
	 	return (head == null && tail == null);
 	}
} 


/**
* ListElement Class has all the constructors and the getters and setters
* This Class implements the state and behavior of a list element to hold
* "int" data, but also the "prev" and "next" references.
* @author AlexeyRaskin
* @author AlexeyPodberezskiy
*/

class ListElement <T>{
	
	 private T val;
	 private ListElement next;
	 private ListElement prev;
	
	/**
	 * ListElement no-argument constructor, initializes val data to 0 and 
	 * "next", "prev" references to null. 
	 */
	public ListElement()
	{
		this(null,null,null);
	}
	
	/**
	 * ListElement constructor
	 * @param val the value of to be held by the ListElement
	 */
	public ListElement(T val)
	{
		this(val,null,null);
	}
	
	/**
	 * ListElement constructor
	 * @param val the value of to be held by the ListElement
	 * @param next the reference to the elements next ListElement
	 */
	public ListElement(T val, ListElement <T>next)
	{
	this(val,next,null);	
	}
	
	/**
	 * ListElement constructor
	 * @param val the value of to be held by the ListElement
	 * @param next the reference to the element's next ListElement
	 * @param prev the reference to the element's previous ListElement
	 */
	public ListElement(T val, ListElement <T>next, ListElement <T>prev)
	{
		this.next=next;
		this.prev=prev;
		this.val=val;	
	}
	
	/**
	 * get method for the internal data value.
	 * @return the internal data value heald by this ListElement.
	 */
	public T getVal(){return val;}
	
	/**
	 * get method for the next ListElement reference.
	 * @return the reference to the next ListElement in the list.
	 */
	public ListElement getNext(){return next;}
	
	/**
	 * get method for the previous ListElement reference.
	 * @return the reference to the prev ListElement in the list.
	 */
	public ListElement getPrev(){return prev;}
	
	/**
	 * set method for the next ListElement reference.
	 * @param next the new reference to be updated as the next ListElement
	 * referenced from this element.
	 */
	public void setNext(ListElement <T>next){this.next=next;}
	
	/**
	 * set method for the prev ListElement reference.
	 * @param prev the new reference to be updated as the previous ListElement
	 * referenced from this element.
	 */
	public void setPrev(ListElement <T>prev){this.prev=prev;}
	
	/**
	 * Implementation of the toString method for this object. The toString
	 * method is defined as an empty method in Object class (the root of EVERY
	 * inheitance hierarchy in Java - see Java API documentation). Every class
	 * can override it to implement its specific conversion to String. 
	 * It is invoked automatically in context of String arguments or string
	 * operations (such as concatenation).
	 * @return the String representation of the internal integer value held by 
	 * this ListElement.
	 */	
	public String toString()
	{
		return "" + val;
	}
}
