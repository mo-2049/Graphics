package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {

	public static String Id = "selection";
	private Boolean selected = false;

	@Override
	public String getId() {
		return Id;
	}

	public boolean isSelected() {
		return selected;

	}

	public void select() {
		this.selected = true;
	}

	public void unselected() {
		this.selected = false;
	}

	public void toggleSelection() {
		this.selected = !this.selected;
	}
}
