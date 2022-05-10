package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape {
	
	private String text;
	private Point loc;
	private Rectangle rect;
	
	public SText(Point p, String str ) 
	{
		this.loc = p;
        this.text = str;
	}
	
	public String getText() 
	{
		return this.text;
	}
	
	public void setText(String str) 
	{
		this.text = str;
	}

	@Override
	public Point getLoc() 
	{
		return this.loc;
	}
	
	@Override
	public void setLoc(Point p) 
	{
		this.loc.setLocation(p);
	}
	
	@Override
	public void translate(int dx,int dy) 
	{
		this.loc.translate( dx, dy);
	}
	
	@Override
	public Rectangle getBounds() 
	{
		int locX = (int) this.loc.getX();
		int locY = (int) this.loc.getY();
		int width = this.text.length();
		String[] textArray = this.text.split("\n");
		int height = textArray.length;
		this.rect = new Rectangle(locX,locY, width,height);
		
		return this.rect;
	}
	
	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitText(this);
	}




}