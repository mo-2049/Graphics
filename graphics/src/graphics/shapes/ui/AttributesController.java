package graphics.shapes.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.shapes.SCircle;
import graphics.shapes.SRectangle;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.ui.View;


public class AttributesController {
	
	private AttributesView aView;
	private View mainView;
	private Shape model;
	
	public AttributesController(View mainView, AttributesView view, Shape s) {
		this.aView = view;
		this.mainView= mainView;
		this.model = s;
		this.aView.addSetListener(new AttributesListener());
		if(s instanceof SCircle)
		{
			aView.getWidthField().setEnabled(false);
		}
		if(s instanceof SCircle)
		{
			aView.setInputRadius((int)((SCircle) model).getRadius());
			aView.getWidthField().setEnabled(false);
			aView.getHeightField().setEnabled(false);
		}
		if(s instanceof SRectangle)
		{
			aView.setInputWidth((int)((SRectangle) model).getRect().getWidth());
			aView.setInputHeight((int)((SRectangle) model).getRect().getHeight());
			aView.getRadiusField().setEnabled(false);
		}
	}
	
	class AttributesListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(model instanceof SRectangle)
			{
			((SRectangle) model).setWidth(aView.getInputWidth());
			((SRectangle) model).setHeight(aView.getInputHeight());
			((SRectangle) model).addAttributes(new ColorAttributes (true, true, Color.RED, Color.RED));
			}
			if(model instanceof SCircle)
			{
			((SCircle) model).setRadius(aView.getInputRadius());
			((SCircle) model).addAttributes(new ColorAttributes (true, true, Color.RED, Color.RED));
			}

			mainView.updateUI();
		}
		
	}
	
}