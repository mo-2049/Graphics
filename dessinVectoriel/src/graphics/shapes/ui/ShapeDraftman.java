package graphics.shapes.ui;

import graphics.shapes.*;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.*;

public class ShapeDraftman implements ShapeVisitor {
	private final ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes(true, false, Color.BLACK, Color.BLACK);
	private final FontAttributes DEFAULT_FONT_ATTRIBUTES = new FontAttributes();
	private final int SELECTIONRECTSIZE = 5;
	private Graphics g;

	public ShapeDraftman(Graphics g) {
		this.g = g;
	}

	@Override
	public void visitRectangle(SRectangle Rect) {
		Rectangle rect = Rect.getRect();
		ColorAttributes color = (ColorAttributes) Rect.getAttributes().get(ColorAttributes.Id);
		if (color == null)
			color = DEFAULT_COLOR_ATTRIBUTES;
		if (color.filled) {
			g.setColor(color.fillColor);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		if (color.stroked) {
			g.setColor(color.strokedColor);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
		SelectionAttributes selectionAttributes = (SelectionAttributes) Rect.getAttributes()
				.get(SelectionAttributes.Id);
		if (selectionAttributes != null && selectionAttributes.isSelected())
			drawSelectionCollection(Rect.getBounds());
	}

	@Override
	public void visitCircle(SCircle Circle) {
		Rectangle Crect = Circle.getBounds();
		int radius = Circle.getRadius();
		Point loc = Circle.getLoc();
		ColorAttributes color = (ColorAttributes) Circle.getAttributes().get(ColorAttributes.Id);

		if (color == null) {
			color = (ColorAttributes) DEFAULT_COLOR_ATTRIBUTES;
		}

		if (color.filled) {
			this.g.setColor(color.fillColor);
			g.fillOval(loc.x - radius, loc.y - radius, 2 * radius, 2 * radius);
		}

		if (color.stroked) {
			g.setColor(color.strokedColor);
			g.drawOval(loc.x - radius, loc.y - radius, 2 * radius, 2 * radius);

		}
		SelectionAttributes selectionAttributes = (SelectionAttributes) Circle.getAttributes()
				.get(SelectionAttributes.Id);
		if (selectionAttributes != null && selectionAttributes.isSelected())
			drawSelectionCollection(Circle.getBounds());
	}

	@Override
	public void visitText(SText sText) {
		Point loc = sText.getLoc();
		Rectangle rect = sText.getBounds();
		FontAttributes fontAttributes = (FontAttributes) sText.getAttributes().get(FontAttributes.Id);
		if (fontAttributes == null)
			fontAttributes = DEFAULT_FONT_ATTRIBUTES;
		ColorAttributes color = (ColorAttributes) sText.getAttributes().get(ColorAttributes.Id);
		if (color == null)
			color = DEFAULT_COLOR_ATTRIBUTES;
		if (color.filled) {
			g.setColor(color.fillColor);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		if (color.stroked) {
			g.setColor(color.strokedColor);
			g.drawRect(rect.x, rect.y, rect.width, rect.height);
		}
		g.setFont(fontAttributes.getFont());
		g.setColor(fontAttributes.getFontColor());
		g.drawString(sText.getText(), loc.x, loc.y + rect.height);
		SelectionAttributes selectionAttributes = (SelectionAttributes) sText.getAttributes()
				.get(SelectionAttributes.Id);
		if (selectionAttributes != null && selectionAttributes.isSelected())
			drawSelectionCollection(sText.getBounds());
	}

	private void drawSelectionCollection(Rectangle bounds) {
		g.setColor(Color.BLACK);
		g.drawRect(bounds.x - SELECTIONRECTSIZE, bounds.y - SELECTIONRECTSIZE, SELECTIONRECTSIZE, SELECTIONRECTSIZE);
		g.setColor(Color.BLACK);
		g.drawRect(bounds.x + bounds.width, bounds.y + bounds.height, SELECTIONRECTSIZE, SELECTIONRECTSIZE);
	}

	@Override
	public void visitCollection(SCollection sCollection) {
		sCollection.iterator().forEachRemaining((shape) -> shape.accept(this));
		SelectionAttributes selectionAttributes = (SelectionAttributes) sCollection.getAttributes()
				.get(SelectionAttributes.Id);
		if (selectionAttributes != null && selectionAttributes.isSelected())
			drawSelectionCollection(sCollection.getBounds());
	}
}