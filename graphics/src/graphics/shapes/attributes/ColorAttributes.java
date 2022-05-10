package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {

	public static String Id = "color";
	
	@Override
	public String getId() {
		return Id;
	}
	
	public Boolean filled;
	public Boolean stroked;
	public Color fillColor;
	public Color strokedColor;
	
	public ColorAttributes(Boolean filled ,Boolean strocked, Color filledColor, Color strockedColor) {
		this.filled = filled;
		this.stroked = strocked;
		this.fillColor = filledColor;
		this.strokedColor = strockedColor;
	}
}
