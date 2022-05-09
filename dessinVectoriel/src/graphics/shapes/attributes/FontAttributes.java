package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class FontAttributes extends Attributes {

	public static String Id = "font";
	private Font font;
	private Color fontColor;

	public FontAttributes() {
		setFont(new Font("Arial", Font.PLAIN, 20));
		this.fontColor = Color.BLACK;
	}

	public void setFont(Font font) {
		this.font = font;

	}

	public Font getFont() {
		return this.font;
	}

	public Color getFontColor() {
		return this.fontColor;
	}

	@Override
	public String getId() {
		return Id;
	}

	public Font font(Font typeOfFont) {
		this.font = typeOfFont;
		return this.font;
	}

	public Color fontColor(Color typeOfColor) {
		this.fontColor = typeOfColor;
		return this.fontColor;
	}

	public Rectangle getBounds(String getId) {
		return getBounds(getId);
	}
}
