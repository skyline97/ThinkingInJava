package enum_;

public enum OzWitch {

	WEST("w"),
	NORTH("n"),
	EAST("e"),
	SOUTH("s");
	
	private String description;
	
	private OzWitch(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static void main(String[] args) {
		for(OzWitch witch : OzWitch.values()) {
			System.out.println(witch + ": " + witch.getDescription());
		}
	}
}
