package graphics.shapes.ui;

import java.awt.event.ActionListener;

import javax.swing.*;

public class AttributesView extends JFrame{

	private JLabel widthLabel = new JLabel("Width");
	private JTextField width = new JTextField(10);
	private JLabel heightLabel = new JLabel("Height");
	private JTextField height = new JTextField(10);
	private JLabel colorLabel = new JLabel("Color");
	private JTextField color = new JTextField(10);
	private JButton setButton = new JButton("Set");

	
	AttributesView(){
		
		// Sets up the view and adds the components
		JPanel calcPanel = new JPanel();
		this.setSize(200, 200);
		
		calcPanel.add(widthLabel);
		calcPanel.add(width);
		calcPanel.add(heightLabel);
		calcPanel.add(height);
		calcPanel.add(colorLabel);
		calcPanel.add(color);
		calcPanel.add(setButton);
		this.add(calcPanel);
		
		// End of setting up the components --------
		
	}
	
	public int getInputWidth(){
		
		return Integer.parseInt(width.getText());
		
	}
	
	public void setInputWidth(int solution){
		
		width.setText(Integer.toString(solution));
		
	}
	
	public void setInputHeight(int solution){
		
		height.setText(Integer.toString(solution));
		
	}

	void addSetListener(ActionListener listenForSetButton){
		
		setButton.addActionListener(listenForSetButton);
		
	}
	
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}