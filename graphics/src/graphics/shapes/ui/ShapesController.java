
package graphics.shapes.ui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.Shape;

import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	private Point point;
	private boolean mousein = true;
	private boolean shift = false;
	private SCollection sc;
	private int prevX, prevY, currentX, currentY;

	public ShapesController(Object newModel) {
		super(newModel);
	}

	MultipleStrokes ms = new MultipleStrokes();
	ToolBar t = new ToolBar();
	// les évènements vont changer selon le mode attributé par la ToolBar (allant de
	// 1 à 5)

	public void mousePressed(MouseEvent e) {
		this.point = e.getPoint();
		this.prevX = this.point.x;
		this.prevY = this.point.y;

		if (t.getMode() == 0) {
			this.getView().repaint();

			if (!this.shift) {
				sc = (SCollection) super.getModel();
				Iterator<Shape> i = sc.iterator();
				while (i.hasNext()) {
					Shape s = i.next();
					SelectionAttributes sa = (SelectionAttributes) s.getAttributes().get(SelectionAttributes.Id);
					if (s.getBounds().contains(this.point)) {
						sa.select();
					}
				}
			}

			this.getView().updateUI();
		}
	}

	public void mouseReleased(MouseEvent e) {
		this.point = e.getPoint();
		this.currentX = this.point.x;
		this.currentY = this.point.y;
		if (t.getMode() == 3) {
			ms.changePosition(this.prevX, this.prevY, this.currentX, this.currentY);
		}
		if (!this.shift) {
			SCollection sc = (SCollection) this.getModel();
			Iterator<Shape> i = sc.iterator();
			while (i.hasNext()) {
				SelectionAttributes sa = (SelectionAttributes) i.next().getAttributes().get(SelectionAttributes.Id);
				sa.unselected();
			}
			this.getView().updateUI();
		}
		for (int j = 0; j < 5; j++) {
			if (t.getBox(j).contains(this.point)) {

				if (t.getToolBar(this.point.y / 25) == false) {

					t.changeSelection(j);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(t.getMode());
		if (t.getMode() == 0) {
			sc = (SCollection) this.getModel();
			Iterator<Shape> i = sc.iterator();
			while (i.hasNext()) {
				Shape s = i.next();
				SelectionAttributes sa = (SelectionAttributes) s.getAttributes().get(SelectionAttributes.Id);
				if (s.getBounds().contains(this.point)) {
					if (this.shift) {
						sa.toggleSelection();
					} else {
						sa.select();
					}
					if(e.getButton()==MouseEvent.BUTTON3)
					{
						if(s instanceof SRectangle || s instanceof SCircle)
						{
						AttributesView aView = new AttributesView();
						AttributesController aController= new AttributesController(this.getView(),aView,s);
						aView.setVisible(true);
						}
					}
				} else {
					if (!this.shift) {
						sa.unselected();
					}
					}
				
			}
		}
		for (int j = 0; j < 5; j++) {
			if (t.getBox(j).contains(this.point)) {

				if (t.getToolBar(this.point.y / 25) == false) {

					t.changeSelection(j);
				}
			}
		}
		if (t.getMode() == 2 && t.getBox(2).contains(this.point)) {
			new HandDrawingDisplay().display();
		}

		this.getView().updateUI();
	}

	public Rectangle getBoundsSelected() {
		Rectangle r = new Rectangle();
		Iterator<Shape> i = sc.iterator();
		while (i.hasNext()) {
			Shape s = i.next();
			SelectionAttributes sa = (SelectionAttributes) s.getAttributes().get(SelectionAttributes.Id);
			if (sa.isSelected()) {
				r = r.union(s.getBounds());
			}
		}
		return r;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		sc = (SCollection) this.getModel();
		if (sc.getBounds().contains(this.point)) {
			Iterator<Shape> i = sc.iterator();
			while (i.hasNext()) {
				Shape s = i.next();
				SelectionAttributes sa = (SelectionAttributes) s.getAttributes().get(SelectionAttributes.Id);
				if (sa.isSelected() && this.mousein && getBoundsSelected().contains(this.point)) {
					s.translate(e.getPoint().x - this.point.x, e.getPoint().y - this.point.y);
				}
			}
			if (this.mousein == true) {
				this.point = e.getPoint();
				this.getView().updateUI();
			}
		}

		this.getView().updateUI();
	}

	public void keyReleased(KeyEvent e) {
		this.shift = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
			t.toggleSelection(t.getMode());
			this.getView().updateUI();
		}
		if ((e.getModifiers() & ActionEvent.ALT_MASK) == ActionEvent.ALT_MASK) {
			System.out.println("test");
			ms.changePosition(0, 0, 0, 0);
			this.getView().updateUI();

		}
	}
}
