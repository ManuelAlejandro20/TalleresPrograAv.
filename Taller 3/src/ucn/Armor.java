package ucn;

public class Armor extends Item {
	
	private String type;
	private int value;
	
	public Armor(String name_readed, String rarity_readed, String type, int value) {
		super(name_readed, rarity_readed);
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public int getValue() {
		return value;
	}
	
	
	
}
