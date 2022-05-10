package graphics.shapes.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class MultipleStrokes extends JComponent {
	private static final long serialVersionUID = 1L;
	private static int prevX;
	private static int prevY;
	private static int currentX;
	private static int currentY;

	public void DrawMultipleLines(Graphics g) {
		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(5));
		g.drawLine(prevX, prevY, currentX, currentY);
		g.drawLine(500 - Math.abs(prevX), prevY, 500 - Math.abs(currentX), currentY);
		g.drawLine(prevX, 500 - Math.abs(prevY), currentX, 500 - Math.abs(currentY));
		g.drawLine(500 - Math.abs(prevX), 500 - Math.abs(prevY), 500 - Math.abs(currentX), 500 - Math.abs(currentY));

	}

	public void changePosition(int prevX, int prevY, int currentX, int currentY) {
		MultipleStrokes.prevX = prevX;
		MultipleStrokes.prevY = prevY;
		MultipleStrokes.currentX = currentX;
		MultipleStrokes.currentY = currentY;
	}
}