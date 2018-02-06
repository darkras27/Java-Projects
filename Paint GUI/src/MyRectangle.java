import java.awt.Color;
import java.awt.Graphics;

/**
 * This class of Rectangle shape-extends MyBoundedShape
 * Will initialize the shape with/without arguments
 * @author AlexeyRaskin ID306058611
 */

public class MyRectangle extends MyBoundedShape {

	/**
	 * An empty constructor-using the super to initialize the specific shape 
	 */
	public MyRectangle() {super();}
	
	/**
	 * Rectangle constructor, initialize with non-zero values
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param myColor
	 * @param filled
	 */
	public MyRectangle(int x1, int y1, int x2, int y2, Color myColor, boolean filled) 
	{
		super(x1,y1,x2,y2,myColor, filled);	
	}

	/**This method will draw the shape with the resulted values from the user
	 *@param g
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
	      
	      if (isFilled())
	         g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	      else
	         g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());	
	}
}



