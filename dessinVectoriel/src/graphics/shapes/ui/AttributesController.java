package graphics.shapes.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.shapes.SRectangle;
import graphics.shapes.Shape;
import graphics.ui.View;

// The Controller coordinates interactions
// between the View and Model

public class AttributesController {
	
	private AttributesView aView;
	private View mainView;
	private Shape model;
	
	public AttributesController(View mainView, AttributesView view, Shape s) {
		this.aView = view;
		this.mainView= mainView;
		this.model = s;
		aView.setInputWidth((int)((SRectangle) model).getRect().getWidth());
		this.aView.addSetListener(new AttributesListener());
	}
	
	class AttributesListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int width=aView.getInputWidth();
			((SRectangle) model).setWidth(width);
			mainView.updateUI();
		}
		
	}
	
}