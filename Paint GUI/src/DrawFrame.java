import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *This class draws the figure the user sees with all the GUI elements (JButton,JComboBox,JCheckBox,JLabel).
 * {@link javax.swing.JButton} , {@link javax.swing.JComboBox} , {@link javax.swing.JCheckBox}, {@link javax.swing.JLabel}.
 * @author AlexeyRaskin ID306058611
 */
 
public class DrawFrame extends JFrame {
	private final JButton undoButton;
	private final JButton clearButton;
	private final JComboBox<String> colorChoices;
	private final JComboBox<String> shapeChoices;
	private final JCheckBox filledCheckBox;
	private  final JLabel statusLabel;
	private final DrawPanel smartPanel;
	private final String[] colorNames = {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray","Magenta","Orange"
			,"Pink","Red","White","Yellow"};
	private final Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY
			,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED
			,Color.WHITE,Color.YELLOW};
	private final String[] shapes = {"Line","Oval","Rectangle"};
	private final JPanel northPanel;
	
	/**
	 * DrawFrame - initializes GUI elements and adds events and labels  
     * it also creates a DrawPanel.
     * {@link DrawPanel}
	 */
	public DrawFrame() {
		// set north layout
		setLayout(new BorderLayout());
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionHandler());
		northPanel.add(undoButton);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionHandler());
		northPanel.add(clearButton);
		colorChoices = new JComboBox<String>(colorNames);
		northPanel.add(colorChoices);
		colorChoices.addItemListener(new ItemHandler());
		shapeChoices = new JComboBox<>(shapes);
		northPanel.add(shapeChoices);
		shapeChoices.addItemListener(new ItemHandler());
		filledCheckBox = new JCheckBox("Filled");
		northPanel.add(filledCheckBox);
		filledCheckBox.addItemListener(new ItemHandler());
		add(northPanel,BorderLayout.NORTH);
		statusLabel = new JLabel("(0,0)");
		add(statusLabel,BorderLayout.SOUTH);
		smartPanel = new DrawPanel(this,statusLabel);
		add(smartPanel);
		
	} 
	
	/**
	 * This is a private inner class for DrawFrame class that implements ActionListener for GUI buttons
	 * {@link java.awt.event.ActionListener}.
	 */
	private class ActionHandler implements ActionListener
	{
		/**
		* this method calls the undo and clear functions 
		*/
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==undoButton)
				smartPanel.Undo();
			if(e.getSource()==clearButton)
				smartPanel.Clear();
		}
	}
	
	/**
	 * This is a private inner class for DrawFrame class that implements the ItemListener.
	 * {@link java.awt.event.ItemListener}.
	 */
	private class ItemHandler implements ItemListener
	{
		/** 
		* This method checks if the color, shape or filled we're SELECTED
		*/
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==colorChoices) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					smartPanel.setCurrentColor(colors[colorChoices.getSelectedIndex()]);
			}
			if(e.getSource()==shapeChoices) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					smartPanel.setCurrentShapeType(shapeChoices.getSelectedIndex());
			}
			if(e.getSource()==filledCheckBox) 
				smartPanel.setCurrentIsFilled(filledCheckBox.isSelected());
			
		}
	}
}























