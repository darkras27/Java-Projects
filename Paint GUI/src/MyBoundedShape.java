import java.awt.Color;

/**
 * This Class of MyBoundedShape extends MyShape.
 * it returns the sizes of Rectangle and Oval shapes.
 * @author AlexeyRaskin ID306058611
 * @author AlexeyPodberezskiy ID323367789
 */

public abstract class MyBoundedShape extends MyShape{
	
	private boolean filled; // initialized to false
	
	/**
	 * an empty constructor, initialize the shape to '0' and black color
	 **/
	 
	public MyBoundedShape() {super();}
	
	/**
	 * Rectangle constructor, initialize with non-zero values
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param myColor
	 * @param filled
	 */
	 
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color myColor, boolean filled) {
		super(x1,y1,x2,y2,myColor);
		this.filled = filled;		
	}
	
	 /**
	 * This method returns upper left x coordinate
	 * @return min(getX1(), getX2())
	 */
		
	   public int getUpperLeftX()
	   {
	      return Math.min(getX1(), getX2());
	   }	

	 /**
	  * This method returns upper left y coordinate
	  * @return min(getY1(), getY2())
	  */
	   public int getUpperLeftY()
	   {
	      return Math.min(getY1(), getY2());
	   } 

	 /**
	  * This method returns shape width
	  * @return abs(getX2() - getX1())
	  */
	   public int getWidth()
	   {
	      return Math.abs(getX2() - getX1());
	   }

	 /**
	  * This method returns shape height
	  * @return abs(getY2() - getY1())
	  */
		
	   public int getHeight()
	   {
	      return Math.abs(getY2() - getY1());
	   } 
	   
	 /**
	  * checks if the shape is filled or nor
	  * @return true if filled or faulse else
	  */
	   public boolean isFilled()
	   {
	      return filled;
	   } 

	 /**
	  * sets the drawing to filled/unfilled 
	  * @param filled - true
	  *		   unfilled - false
	  */
	   public void setFilled(boolean filled)
	   {
	      this.filled = filled;
	   }
}









