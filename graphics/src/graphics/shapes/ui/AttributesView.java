package graphics.shapes.ui;

import java.awt.event.ActionListener;

import javax.swing.*;

public class AttributesView extends JFrame{

	private JLabel widthLabel;
	private JTextField width;
	private JLabel heightLabel;
	private JTextField height;
	private JLabel radiusLabel;
	private JTextField radius;
	private JLabel colorLabel;
	private JComboBox colorBox;
	private JButton setButton;
	private JPanel attPanel;

	
	AttributesView(){
		
		widthLabel = new JLabel("Width");
		width = new JTextField(10);
		heightLabel = new JLabel("Height");
		height = new JTextField(10);
		radiusLabel = new JLabel("radius");
		radius = new JTextField(10);
		colorLabel = new JLabel("Color");
		String colors[]= {"green","blue","red"};
		colorBox= new JComboBox(colors);
		setButton = new JButton("Set");
		attPanel = new JPanel();
		this.setSize(200, 200);
		

		
	
		attPanel.add(widthLabel);
		attPanel.add(width);
		attPanel.add(heightLabel);
		attPanel.add(height);
		attPanel.add(radiusLabel);
		attPanel.add(radius);
		attPanel.add(colorLabel);
		attPanel.add(colorBox);
		attPanel.add(setButton);
		this.add(attPanel);

		

		
		
	}
	
	public JTextField getWidthField(){
		
		return width;
	}

	public JTextField getRadiusField(){
		
		return radius;
	}
	
	public int getInputWidth(){
		
		return Integer.parseInt(width.getText());
		
	}
	
	public void setInputWidth(int width){
		
		this.width.setText(Integer.toString(width));
		
	}
	
	public void setInputRadius(int radius){
		
		this.radius.setText(Integer.toString(radius));
	}
	
	public int getInputRadius(){
		
		return Integer.parseInt(radius.getText());
	}
	
	public int getInputHeight(){
		
		return Integer.parseInt(height.getText());
		
	}
	
	public void setInputHeight(int height){
		
		this.height.setText(Integer.toString(height));
		
	}
	
	public String getSelectedColor(){
		return (String)colorBox.getSelectedItem();
	}

	void addSetListener(ActionListener listenForSetButton){
		
		setButton.addActionListener(listenForSetButton);
		
	}
	
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}

	public JTextField getHeightField() {
		return height;
	}
	
}