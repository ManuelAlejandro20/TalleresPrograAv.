package ucn;

public class Item {
	private String name;
	private String rarity;
	
	public Item(String name_readed, String rarity_readed) {
		this.rarity = rarity_readed;
		this.name = name_readed;
	}

	public String getName() {
		return name;
	}

	public String getRarity() {
		return rarity;
	}
	
	
	
}
