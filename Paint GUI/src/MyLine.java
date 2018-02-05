import java.awt.Color;
import java.awt.Graphics;

/**
 * This class of Line shape-extends MyShape
 * Will initialize the shape with or withput arguments
 * @author AlexeyRaskin ID306058611
 */
 
public class MyLine extends MyShape{

	/**
	 * constructor initializes private variables with default values using-the super
	 */
	public MyLine() {super();}
	
	/**
    * constructor with input values
    * @param x1
    * @param y1
    * @param x2
    * @param y2
    * @param myColor
    */
	public MyLine(int x1, int y1, int x2, int y2, Color myColor) 
	{
		super(x1,y1,x2,y2,myColor);	
	}
	
	/**
    * draw the line in the specified color
    * @param g
    */
	@Override
	public void draw(Graphics g) 
	{
		g.setColor(getColor());
	    g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}

