import java.awt.Color;
import java.awt.Graphics;
/**
 * This abstract class inherits from 'java.lang.Object' and holds all the functions which will used by the other
 * classes such as: MyLine,MyOval and MyRect.
 * By that, the lower classes will inherit this class and receive the characteristics
 * of the Shape class.
 * @author AlexeyRaskin
 **/
 
public abstract class MyShape 
{
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color myColor;
	
	/**
	 * an empty constructor, initialize the shape to '0' and black color
	 **/
	public MyShape()
	{
		this(0,0,0,0,Color.BLACK);
	}
	
	/**MyShape constructor, initialize with non-zero values
	 *@param x1 - - x1 coordinate of the shape
	 *@param y1 - - y1 coordinate of the shape
	 *@param x2 - x2 coordinate of the shape
	 *@param y2 - y2 coordinate of the shape
	 *@param myColor - the color of the shape
	 */
	public MyShape(int x1,int y1,int x2,int y2,Color myColor)
	{
		setX1(x1);
		setX2(x2);
		setY1(y1);
		setY2(y2);
		setColor(myColor);
	}
	
	/**
	 * Set X1 coordinate
	 *@param  x1
	 **/
	public void setX1(int x1)
	{
		this.x1=(x1 >= 0 ? x1 : 0);
	}
	
	/**
	 * Set X2 coordinate
	 * @param x2
	**/
	public void setX2(int x2)
	{
		this.x2=(x2 >= 0 ? x2 : 0);
	}
	
	/**
	 * Set Y1 coordinate
	 * @param y1
	 **/
	public void setY1(int y1)
	{
		this.y1=(y1 >= 0 ? y1 : 0);
	}
	
	/**
	 * Set Y2 coordinate
	 * @param y2
	 **/
	public void setY2(int y2)
	{
		this.y2=(y2 >= 0 ? y2 : 0);
	}
	
	/**
	 * Set the color of the shape coordinate
	 * @param myColor
	**/
	public void setColor(Color myColor)
	{
		this.myColor=myColor;
	}
	
	/**
	 * Get X1 coordinate
	 * @return x1 
	**/
	public int getX1()
	{
		return x1;
	}
	
	/**
	 * Get X2 coordinate
	 * @return x2 
	 */
	public int getX2()
	{
		return x2;
	}
	
	/**
	 * Get Y1 coordinate
	 * @return y1 
	 */
	public int getY1()
	{
		return y1;
	}
	
	/**
	 * Get Y2 coordinate
	 * @return y2 
	 */
	public int getY2()
	{
		return y2;
	}
	
	/**
	 * Get the color of the shape
	 * @return myColor
	 */
	public Color getColor()
	{
		return myColor;
	}
	
	/**
	 * Get the smallest x coordinates
	 * @return minimum between X1 and X2
	 */
	public int getUpperLeftX()
	{
	     return Math.min(getX1(), getX2());
    }
	
	/**
	 * Get the smallest y coordinates
	 * @return the minimum between Y1 and Y2
	 */
	public int getUpperLeftY()
	{
	     return Math.min(getY1(), getY2());
    }
	
	/**
	 * Get the width of the shape
	 * @return the minimum between X1 and X2
	 */
	public int getWidth()
	{
		return Math.abs(getX1()-getX2());
	}
	
	/**
	 * Get the height of the shape
	 * @return the height of the shape
	 */
	public int getHeight()
	{
		return Math.abs(getY1()-getY2());
	}
	
	/**
	 * Abstract function which will draw the shape
	 * Every inherited class will has to execute this function in order to use it
	 * @param g
	 */
	public abstract void draw(Graphics g);

}
