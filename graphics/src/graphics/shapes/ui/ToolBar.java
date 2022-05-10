package graphics.shapes.ui;

import java.awt.*;

import java.util.ArrayList;

import java.awt.Rectangle;

public class ToolBar {

	public static boolean selected = false;
	public static Color selectedColor = Color.green;
	public static Color unselectedColor = Color.GRAY;
	private static int width = 20;
	private static int height = 20;
	private static int PosX = 460;
	private static int PosY = 25;
	public static ArrayList<Rectangle> toolBar2 = new ArrayList<Rectangle>();
	private static ArrayList<Boolean> toolBar = new ArrayList<Boolean>();

	/*
	 * 0 - mode par défaut : permet la sélection de forme 1 - mode test : ne peux
	 * rien faire à part changer de mode 2 - mode Dessin à la main : ouvre la
	 * fenêtre de dessin) 3 - mode brosse multiple 4 -mode sauvegarde : permet de
	 * sauvegarder
	 * 
	 */

	public ToolBar() {
		for (int i = PosY; i < 150; i = i + 25) {
			toolBar2.add(new Rectangle(PosX, i, width, height));
		}
		for (int i = 0; i < 5; i++) {
			toolBar.add(false);

		}
	}

	/*
	 * On dessine la toolbar est est composé de carrés rouge ou vert selon le mode
	 * sélectionné
	 */
	public void Toolbar(Graphics g) {
		for (int i = 0; i < 5; i = i + 1) {
			g.setColor(unselectedColor);
			g.drawRect(PosX, i * PosY + 25, width, width);
			if (toolBar.get(i) == false) {
				g.fillRect(PosX, i * PosY + 25, width, width);
			}

			if (toolBar.get(i) == true) {
				g.setColor(selectedColor);
				g.fillRect(PosX, i * PosY + 25, width, width);
			}
			// System.out.println();
		}
		g.setColor(unselectedColor);
		g.drawRect(450, 0, 40, 480);

	}

	/*
	 * on attribut a chaque élément de la liste 1 mode (de 0 à 5) chaque mode
	 * représente 1 extension
	 * 
	 */
	public int getMode() {
		for (int i = 0; i < 5; i++) {
			if (toolBar.get(i) == true) {
				return i;
			}
		}
		return 5;
	}

	public Rectangle getBox(int BoxIndex) {
		return toolBar2.get(BoxIndex);

	}

	public Boolean getToolBar(int ToolBarIndex) {
		return toolBar.get(ToolBarIndex);
	}

	public void changeSelection(int toolbarIndex) {
		for (int i = 0; i < 5; i++) {
			if (i != toolbarIndex) {
				toolBar.set(i, false);
			}
			if (i == toolbarIndex) {
				toolBar.set(toolbarIndex, true);
			}

		}

	}

	public void toggleSelection(int toolbarIndex) {
		if (getMode() == 4) {

			for (int i = 1; i < 5; i++) { 

				if (i != toolbarIndex + 1) {
					toolBar.set(i, false);
				}

			}
			toolBar.set(0, true);
		} else {

			for (int i = 0; i < 5; i++) { 

				if (i != toolbarIndex + 1) {
					toolBar.set(i, false);
				}
				if (i == toolbarIndex + 1) {
					toolBar.set(toolbarIndex + 1, true);
				}
			}
		}
	}
}
