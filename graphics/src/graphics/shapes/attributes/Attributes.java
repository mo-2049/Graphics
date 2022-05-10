package graphics.shapes.attributes;


public abstract class Attributes {
	private String Id;
	private static int IncrementId;
	
	public Attributes(){
		this.Id = String.valueOf(IncrementId);
		this.IncrementId++;
	}
	
	public abstract String getId();
}