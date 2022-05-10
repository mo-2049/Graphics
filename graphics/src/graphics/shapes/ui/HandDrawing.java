package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class HandDrawing extends JComponent {
	private static final long serialVersionUID = 1L;

	// Image we're gonna draw on
	private Image image;
	private Graphics2D g2d;
	// Mouse pointer coordinates
	private int prevX, prevY, currentX, currentY;

	public HandDrawing() {
		// N'utilise pas de tampon pour dessiner (dessin direct)
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// Save coordinates of the mouse pointer when mouse is pressed
				prevX = e.getX();
				prevY = e.getY();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				// Coordinates of the mouse pointer when mouse is dragged
				currentX = e.getX();
				currentY = e.getY();

				if (g2d != null) {
					g2d.drawLine(prevX, prevY, currentX, currentY);
					repaint();
					// Current coordinates of the mouse pointer become previous ones
					prevX = currentX;
					prevY = currentY;
				}
			}
		});
	}

	protected void paintComponent(Graphics g) {
		// Create image if it doesn't exit
		if (image == null) {
			image = createImage(getSize().width, getSize().height);
			g2d = (Graphics2D) image.getGraphics();
			// To get rid of irregularities
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		g.drawImage(image, 0, 0, null);
	}

	public void clear() {
		// Puts the image back in white
		g2d.setPaint(Color.white);
		g2d.fillRect(0, 0, getSize().width, getSize().height);
		//
		g2d.setPaint(Color.black);
		repaint();
	}

	public void chooseColor(Color color) {
		// To choose the color of the pen
		g2d.setPaint(Color.getColor(null, color));
	}

}