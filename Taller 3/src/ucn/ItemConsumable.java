package ucn;

public class ItemConsumable extends Item{
	private int hp_recover;
	private int mp;
	private int charges;
	
	public ItemConsumable(String name_readed, String rarity_readed, int hp_recover, int mp, int charges) {
		super(name_readed, rarity_readed);
		this.hp_recover = hp_recover;
		this.mp = mp;
		this.charges = charges;
	}

	public int getHp_recover() {
		return hp_recover;
	}

	public int getMp() {
		return mp;
	}

	public int getCharges() {
		return charges;
	}
	
	
	
	
	
}
