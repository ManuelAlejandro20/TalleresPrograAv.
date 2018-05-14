package ucn;

public class Player {
	private String name;
	private String type;
	private int level;
	private String guild;
	private ArrayItem inventory;
	
	public Player(String name, String type, int level, String guild) {
		this.name = name;
		this.type = type;
		this.level = level;
		this.guild = guild;
		inventory = new ArrayItem(1000);
	}
	
	public Item verifyweapon(String name) {
		for(int i=0; i<inventory.getQuanitem();i++) {
			String itemclass = inventory.getIt()[i].getClass().getSimpleName();
			if(itemclass.equals("Weapon")) {
				return inventory.getIt()[i];
			}
		}
		return null;
	}
	
	public Item verifyarmor(String name) {
		for(int i=0; i<inventory.getQuanitem();i++) {
			String itemclass = inventory.getIt()[i].getClass().getSimpleName();
			if(itemclass.equals("Armor")) {
				return inventory.getIt()[i];
			}
		}
		return null;
	}
	
	public boolean verifyitem(String name) {
		for(int i=0; i<inventory.getQuanitem();i++) {
			String itemname = inventory.getIt()[i].getName();
			if(itemname.equals(name)) {
				for(int j=i; j<inventory.getQuanitem()-1; j++) {
					inventory.getIt()[j] = inventory.getIt()[j+1];
				}
				inventory.getIt()[inventory.getQuanitem()-1] = null;
				inventory.setQuanitem(inventory.getQuanitem()-1);
				return true;
			}
		}
		return false;
	}
	
	public void replaceweapon(Weapon weapon) {
		for(int i=0; i<inventory.getQuanitem();i++) {
			if(inventory.getIt()[i].getClass().getSimpleName().equals("Weapon")) {
				inventory.setitem(i, weapon);
				StdOut.println("\nThe weapon has been replaced :)");
			}
		}
	}
	
	public void replacearmor(Armor armor) {
		for(int i=0; i<inventory.getQuanitem();i++) {
			if(inventory.getIt()[i].getClass().getSimpleName().equals("Armor")) {
				inventory.setitem(i, armor);
				StdOut.println("\nThe Armor has been replaced :)");
			}
		}
	}
	
	public boolean printinventory(Player player) {
		if(inventory.getIt()[0] == null) {
			StdOut.println("\nXXXX "+ player.getName()+" doesn't have any item!! XXXX");
			return false;
		}
		StdOut.println("\n"+player.getName()+ " has these items\n");
		for(int i=0; i<inventory.getQuanitem(); i++) {
			StdOut.println("- " + inventory.getIt()[i].getName());
		}
		return true;
	}
	
	public void sellitem(String name) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getGuild() {
		return guild;
	}

	public void setGuild(String guild) {
		this.guild = guild;
	}

	public ArrayItem getInventory() {
		return inventory;
	}
	

}
