package ucn;

public class ArrayPlayer {	
	private Player[] p;
	private int quanplayers = 0;
	
	public ArrayPlayer(int max) {
		p = new Player[max];
	}
	
	public void addplayer(Player player) {
		p[quanplayers] = player;
		quanplayers++;
		
	}
	
	
	
	public boolean findplayer(String name) {
		for(int i=0; i<quanplayers; i++) {
			if(p[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public boolean addnewplayer(String name, String type) {
		if(findplayer(name)) {
			return false;
		}
		Player newplayer = new Player(name, type, 1, null);
		quanplayers++;
		p[quanplayers-1] = newplayer;
		return true;
	}

	public boolean playeremptyguild(ArrayGuild ag) {
		boolean emptyguild = false;
		for(int i=0; i<quanplayers; i++) {
			if(p[i].getGuild() == null) {
				ag.assignbuild(p[i]);
				emptyguild = true;
			}
		}
		return emptyguild;
	}
	
	
	
	public int getQuanplayers() {
		return quanplayers;
	}

	public Player[] getP() {
		return p;
	}
	
	public Player allplayers() {
		for(int i = 0; i<quanplayers; i++) {
			StdOut.println(p[i].getName());
		}
		System.out.println("\nEnter the player you want to enter the store with");
		String name = StdIn.readString();
		if(findplayer(name)) {
			for(int i=0; i<quanplayers; i++) {
				if(p[i].getName().equals(name)) {
					return p[i];
				}
			}
		}
		return null;
	}
	
}	
