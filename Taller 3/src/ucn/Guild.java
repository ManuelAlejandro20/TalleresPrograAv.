package ucn;

public class Guild {
	private String name;
	private int level;
	
	public Guild(String name_readed, int level_readed) {
		this.name = name_readed;
		this.level = level_readed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
