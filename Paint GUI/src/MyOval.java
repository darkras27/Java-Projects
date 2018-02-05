import java.awt.Color;
import java.awt.Graphics;

/**
 * This class of Line shape-extends MyBoundedShape
 * Will initialize the shape with or without arguments
 * @author AlexeyRaskin ID306058611
 */

public class MyOval extends MyBoundedShape {

	/**
	 * default constractor - initilize the coordinate by zero and color to black
	 */
	public MyOval() {super();}
	
   /**
    * constructor with input values
    * @param x1
    * @param y1
    * @param x2
    * @param y2
    * @param myColor
	* @param filled
    */
	
	public MyOval(int x1, int y1, int x2, int y2, Color myColor, boolean filled) {
		super(x1,y1,x2,y2,myColor, filled);	
	}

	/**This method will draw the shape with the resulted values from the user
	 *@param g
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
	      
	      if (isFilled())
	         g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	      else
	         g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());		
	}
}


