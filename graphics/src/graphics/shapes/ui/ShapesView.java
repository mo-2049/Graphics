package graphics.shapes.ui;

import graphics.ui.View;
import graphics.shapes.Shape;
import java.awt.*;

import graphics.ui.Controller;

public class ShapesView extends View {
	private ShapeDraftman draftman;
	public ToolBar toolBar = new ToolBar();
	public MultipleStrokes ms = new MultipleStrokes();

	public ShapesView(Object model) {
		super(model);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	public void paintComponent(Graphics g) {
		this.draftman = new ShapeDraftman(g);
		g.setColor(getBackground());
		g.fillRect(0, 0, 500, 500);
		Shape shape = (Shape) this.getModel();
		shape.accept(draftman);
		toolBar.Toolbar(g);
		ms.DrawMultipleLines(g);

	}

	@Override
	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}
}
