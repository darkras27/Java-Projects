import javax.swing.JFrame;

/**
 * Test application to display a DrawPanel
 * @author AlexeyRaskin ID306058611
 */
public class TestDraw 
{
	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();		//creates a new 'DrawPanel'
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//operation to end the drawing frame
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}



