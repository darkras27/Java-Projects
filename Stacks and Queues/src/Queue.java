
/**
 * This Class implements the state and behavior of Queue infrastructure. It inherits from DDLinkedList class.
 * @author AlexeyRaskin 
 */
public class Queue <T> extends DDLinkedList<T> {
	/**
	 * enqueue an element to the Back of the Queue.
	 * @param val - the integer value to be added to the Back of the Queue.
	 */
	public void enqueue(T val){
		addToTail(val);
	}
	
	
		/**
	 * dequeue an element from the Front of the Queue.
	 * @return the value of the element dequeued from the Front of the Queue. If the Queue is empty, returns -1.
	 */
	public T dequeue(){
		if(isEmpty()) 
			return null;
		return removeFromHead()	;
	}
}