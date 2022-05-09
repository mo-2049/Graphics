package graphics.shapes;

import graphics.shapes.ui.ShapeDraftman;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape {

	private ArrayList<Shape> shapes = new ArrayList<>();
	int pos = 0;

	public SCollection() {
		this.shapes = new ArrayList<>();
	}

	public Iterator<Shape> iterator() {
		return shapes.iterator();
	}

	public void add(Shape s) {
		this.shapes.add(s);
	}

	@Override
	public Point getLoc() {

		return null;
	}

	@Override
	public void setLoc(Point point) {
	}

	@Override
	public void translate(int x, int y) {
		for (Shape shape : shapes) {
			shape.translate(x, y);
		}
	}

	@Override
	public Rectangle getBounds() {
		Rectangle rectangle = shapes.get(0).getBounds();
		for (Shape shape : shapes) {
			rectangle = rectangle.union(shape.getBounds());
		}
		return rectangle;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCollection(this);
	}

}