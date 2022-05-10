package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HandDrawingDisplay extends Editor {

	JButton clearBtn = new JButton("Clear");
	JButton colorBtn = new JButton("Color");
	HandDrawing hdrawing;
	ActionListener actionListener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clearBtn) {
				hdrawing.clear();
			} else if (e.getSource() == colorBtn) {
				Color color = JColorChooser.showDialog(hdrawing, "Choose a color ", Color.white);
				hdrawing.chooseColor(color);

			}
		}
	};

	public void display() {
		JFrame frame = new JFrame("Hand Drawing");
		Container content = frame.getContentPane();
		// set layout on content pane
		content.setLayout(new BorderLayout());
		// create draw area
		hdrawing = new HandDrawing();
		// Add our image
		content.add(hdrawing, BorderLayout.CENTER);

		clearBtn.addActionListener(actionListener);
		colorBtn.addActionListener(actionListener);

		// create controls to apply colors and call clear feature
		JPanel panel = new JPanel();
		panel.add(clearBtn);
		panel.add(colorBtn);

		content.add(panel, BorderLayout.SOUTH);

		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}