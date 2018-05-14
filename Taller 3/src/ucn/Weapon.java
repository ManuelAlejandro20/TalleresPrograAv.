package ucn;

public class Weapon extends Item {
	private String type;
	private int attack_value;
	private int mult_damage;
	private String ability;
	
	public Weapon(String name_readed, String rarity_readed, String type, int attack_value, int mult_damage, String ability) {
		super(name_readed, rarity_readed);
		this.type = type;
		this.attack_value = attack_value;
		this.mult_damage = mult_damage;
		this.ability = ability;
	}

	public String getType() {
		return type;
	}

	public int getAttack_value() {
		return attack_value;
	}

	public int getMult_damage() {
		return mult_damage;
	}

	public String getAbility() {
		return ability;
	}
	
	

	
	
}
