package ucn;

public class ArrayGuild {
	private Guild[] g;
	private int quanguild = 0;
	
	public ArrayGuild(int max) {
		g = new Guild[max];
	}
	
	public void addguild(Guild guild) {
		g[quanguild] = guild;
		quanguild++;
	}
	
	public void assignbuild(Player player) {
		for(int j=0; j<quanguild; j++) {
			if(player.getLevel()>=90) {
				player.setGuild("Twilight_Brigade");
			}
			else if(player.getLevel() >=  g[j].getLevel() && player.getLevel() < g[j+1].getLevel()) {
				player.setGuild(g[j].getName());
			}
		}
		StdOut.println("@@@ "+ player.getName() + " has been assign to " + player.getGuild() + " @@@");
	}

	public Guild[] getArray() {
		return g;
	}

	public void setArray(Guild[] array) {
		this.g = array;
	}

	public int getquanguild() {
		return quanguild;
	}

	public void setquanguild(int quanguild) {
		this.quanguild = quanguild; 
	}
	
	
}
