import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class will take control on creating the shapes array including
 * using the relevant constructors and the draw method
 * This class will extends JPanel and using all the MyShape methods {@link MyShape}
 * @author AlexeyRaskin 
 */

public class DrawPanel extends JPanel 
{
	private MyShape[] shapes;
	private int ShapeCounter; 
	private MyShape currentShape;
	private Color currentColor;
	
	private int currentShapeType;
	private boolean currentIsFilled;
	private JLabel statusLabel;
	private JFrame frame;
	
	/**
	 * DrawPanel Constructor - initializes the frame and statusLabel that came from the DrawFrame {@link DrawFrame} class,
	 * it uses mouse coordinates to get info about it.
	 * updates the array shapes to max limit 100 shapes 
	 * @param statusLabel - the Jlabel that shows the mouse coordinates in the south of the frame.
	 * @param frame - the main frame of the DrawFrame.
	 */
	 
	public DrawPanel(JFrame frame,JLabel statusLabel) 
	{
		setBackground(Color.WHITE);
		this.statusLabel = statusLabel;
		this.frame = frame;
		addMouseMotionListener(new MouseHandler());
		addMouseListener(new MouseHandler());
		shapes = new MyShape[100];
	}
	/**
	 * setCurrentShape method initializes and creates the shapes the user wants (Line Oval or Rectangle).
	 * when initialized it uses mousePressed coordinates
	 * @param x1 - coordinate of first point in X axis
	 * @param y1 - coordinate of first point in Y axis
	 * @param x2 - coordinate of second point in X axis
	 * @param y2 - coordinate of second point in Y axis
	 */
	 
	public void setCurrentShape(int x1, int y1, int x2, int y2) 
	{
		switch(currentShapeType) {
        case 0 : currentShape = new MyLine(x1, y1, x2, y2, currentColor);
        	break;
        case 1 : currentShape = new MyOval(x1, y1, x2, y2, currentColor, currentIsFilled);
        	break;
        case 2 : currentShape = new MyRectangle(x1, y1, x2, y2, currentColor, currentIsFilled);
        	break;
		}
	}
	
	/**
	 * paintComponent method uses the super class method "paintComponent"
	 * parent class MyShape {@link MyShape}.
	 */
	 
	public void paintComponent(Graphics g)
	   {
		super.paintComponent(g);
	    for(int i=0 ; i < ShapeCounter ; i++) {
	    	shapes[i].draw(g);
	    }
	    if(currentShape!=null)
	    	currentShape.draw(g);
	   } 
	
	/**
	 * This method sets which shape you wand to draw using the JComboBox
	 * @param currentShapeType - gets integer: 0-line
	 *                                         1-oval 
	 * 								   		   2-rectangle.
	 */
	 
	public void setCurrentShapeType(int currentShapeType) 
	{
		this.currentShapeType = currentShapeType;
	}

	/**
	 * This method sets the color of the shape you're drawing.
	 * gets it's values form JComboBox as well
	 * @param currentColor - gets color object {@link java.awt.Color}
	 */
	 
	public void setCurrentColor(Color currentColor) 
	{
		this.currentColor = currentColor;
	}

	/**
	 * This method sets the filled/unfilled param.
	 * can be changed through JCheckBox
	 * @param currentIsFilled - gets boolean value true - filled, false - unfilled.
	 */
	public void setCurrentIsFilled(boolean currentIsFilled) 
	{
		this.currentIsFilled = currentIsFilled;
	}
	
	/**
	 * public method that activated from DrawFrame class when the user click on Undo JButton,
	 * This method deletes the last shape that was drawn, (reduces ShapeCounter, and lets the garbage collector do the rest)
	 * redraws all the shapes excluding the pne you deleted
	 */
	 
	public void Undo() 
	{
		if(ShapeCounter>0) {
			ShapeCounter--;
			repaint();
		}
	}
	
	/**
	 * Clear method deletes all the shapes that were drawn by setting ShapeCounter to 0.
	 * repaints clear table
	 */
	 
	public void Clear() 
	{
		ShapeCounter=0;
		repaint();
	}
	
	/**
	 * This is a private inner class of DrawPanel that implements the mouseAdapter for it's events
	 * this inner class extends mouseAdapter
	 * {@link java.awt.event.MouseAdapter}. 
	 */
	 
	private class MouseHandler extends MouseAdapter
	{
		/**
		 * mouseMoved responsible to update the statusLabel in the mouse coordinates.
		 */
		@Override
		public void mouseMoved(MouseEvent e)
		{
			statusLabel.setText(String.format("(%d,%d)", e.getX(),e.getY()));
		}
		
		/**
		 * when mouseDragged it updates the coordinates of the current shape by seting X2 and Y2
		 * it overrides the super class methos of mouseDragged
		 */
		 
		@Override
		public void mouseDragged(MouseEvent e)
		{
			mouseMoved(e);
			if(currentShape!=null) {
				currentShape.setX2(e.getX());
				currentShape.setY2(e.getY());
				repaint();
			}
		}
		
		/**
		 * mouseReleased method - after releasing the mouse button, it draws the shape
		 * if X1=X2 or Y1=Y2 the shape isn't drawed
		 * overrides mouseReleased
		 * after adding the shape it redraws the whole panel, and initializes currentShape to null.
		 */
		 
		@Override
		public void mouseReleased(MouseEvent e) 
		{
			if(currentShape!=null) {
				if((currentShape.getX1()!=currentShape.getX2()) || (currentShape.getY1()!=currentShape.getY2())){
					shapes[ShapeCounter] = currentShape;
					ShapeCounter++;
					repaint();
				}
			}
			currentShape=null;
		}
		
		/**
		 * mousePressed creates the shape object,
		 * it draws only by clicking left mouse button, and if there is less then a 100 shapes
		 * overrides mousePressed
		 */
		 
		@Override
		 public void mousePressed(MouseEvent e)
		 {
			if(e.getButton()==MouseEvent.BUTTON1) {
				if (ShapeCounter==shapes.length)
					JOptionPane.showMessageDialog(frame,String.format("Cannot exceed the current number of shapes: %d",ShapeCounter),"Capacity Overload", JOptionPane.WARNING_MESSAGE);
				setCurrentShape(e.getX(),e.getY(),e.getX(),e.getY());
			}
		}
	}
}

















