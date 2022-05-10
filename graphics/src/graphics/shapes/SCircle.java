package graphics.shapes;

import java.awt.*;

public class SCircle extends Shape{

	private int radius;
	private Point loc;
	
    public SCircle(Point loc, int radius)
    {
    	super();
        this.loc=loc;
        this.radius=radius;
    }
    
    public int getRadius(){
        return this.radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    @Override
    public Point getLoc() {
        return this.loc;
    }

    @Override
    public void setLoc(Point p) {
    	this.loc=p;
    }

    @Override
    public void translate(int dx, int dy) {
    	this.loc.x=loc.x+dx;
    	this.loc.y=loc.y+dy;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(loc.x-radius,loc.y-radius,2*radius,2*radius);
    }

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCircle(this);
	}

}