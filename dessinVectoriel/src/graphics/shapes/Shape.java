package graphics.shapes;

import graphics.shapes.attributes.Attributes;

import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public abstract class Shape {

	private Map<String, Attributes> attributes = new TreeMap<>();

	public void addAttributes(Attributes attr) {
		this.attributes.put(attr.getId(), attr);
	}

	public Map<String, Attributes> getAttributes() {
		return attributes;
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point point);

	public void translate(int horiz, int vert) {
		this.setLoc(new Point(this.getLoc().x + horiz, this.getLoc().y + vert));
	}

	public abstract Rectangle getBounds();

	public abstract void accept(ShapeVisitor visitor);

}
