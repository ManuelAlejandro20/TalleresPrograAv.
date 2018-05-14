package ucn;

public class ArrayItem {
	private Item[] it;
	private int quanitem = 0;
	
	public ArrayItem(int max) {
		it = new Item[max];
	}
	
	public void additem(Item item) {
		it[quanitem] = item;
		quanitem++;
	}
	
	public boolean additeminventory(String name, Player player) {
		for(int i=0; i<quanitem; i++) {
			if(it[i].getName().equals(name)) {
				player.getInventory().additem(it[i]);
				return true;
			}
		}
		return false;
	}
	
	public Item getitem(String name) {
		for(int i=0; i<quanitem; i++) {
			if(it[i].getName().equals(name)) {
				return it[i];
			}
		}
		return null;
	}

	public Item[] getIt() {
		return it;
	}

	public int getQuanitem() {
		return quanitem;
	}
	
	public void setitem(int pos, Item item) {
		it[pos] = item;
	}

	public void setQuanitem(int quanitem) {
		this.quanitem = quanitem;
	}
	
	
}
