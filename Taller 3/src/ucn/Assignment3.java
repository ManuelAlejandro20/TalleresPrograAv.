package ucn;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Assignment3 {
	public static void main(String args[]) throws IOException{
		SystemTheWorldR2Impl system = new SystemTheWorldR2Impl();
		readplayerdata(system);
		readguilddata(system);
		readitems(system);
		menu(system);
	}
	
	public static void readplayerdata(SystemTheWorldR2Impl system) throws IOException{
		ArchivoEntrada player_file = new ArchivoEntrada("C:\\Users\\aleja\\eclipse-workspace\\Taller 3\\txt files\\Players.txt");
		while(!player_file.isEndFile()) {
			Registro reg = player_file.getRegistro();
			String name = reg.getString();
			String type = reg.getString();
			int level = reg.getInt();
			String guild = reg.getString();
			Player player = new Player(name, type, level, guild);
			system.addplayer(player);
		}
	}

	public static void readguilddata(SystemTheWorldR2Impl system) throws IOException{
		ArchivoEntrada guild_file = new ArchivoEntrada("C:\\Users\\aleja\\eclipse-workspace\\Taller 3\\txt files\\Guilds.txt");
		while(!guild_file.isEndFile()) {
			Registro reg = guild_file.getRegistro();
			String name = reg.getString();
			int minlevel = reg.getInt();
			Guild guild = new Guild(name, minlevel);
			system.addguild(guild);
		}
	}

	public static void readitems(SystemTheWorldR2Impl system) throws IOException{
		ArchivoEntrada item_file = new ArchivoEntrada("C:\\Users\\aleja\\eclipse-workspace\\Taller 3\\txt files\\Items.txt");
		while(!item_file.isEndFile()) {
			Registro reg = item_file.getRegistro();
			String name = reg.getString();
			String rarity = reg.getString();
			String type = reg.getString();
			if(type.equals("Consumable")) {
				Registro reg2 = item_file.getRegistro();
				int hprecovered = reg2.getInt();
				int mprecovered = reg2.getInt();
				int charges = reg2.getInt();
				Item consu = new ItemConsumable(name, rarity, hprecovered, mprecovered, charges);
				system.additem(consu);
			}
			else if(type.equals("Armor")) {
				Registro reg2 = item_file.getRegistro();
				String type_armor = reg2.getString();
				int defense = reg2.getInt();
				Item armor = new Armor(name, rarity , type_armor, defense);
				system.additem(armor);
			}
			else if(type.equals("Weapon")) {
				Registro reg2 = item_file.getRegistro();
				String type_weapon = reg2.getString();
				int attack = reg2.getInt();
				String damagemult = reg2.getString();
				String ability = reg2.getString();
				if(damagemult == null) {
					int damage = 0;
					Item weapon = new Weapon(name, rarity, type_weapon, attack, damage, ability);
					system.additem(weapon);
				}
				else {
					int damage = Integer.parseInt(damagemult);
					Item weapon = new Weapon(name, rarity, type_weapon, attack, damage, ability);
					system.additem(weapon);
				}
			}
		}
	}
	
	public static void menu(SystemTheWorldR2Impl system) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			try{
				StdOut.println("\n1- Add a new player");
				StdOut.println("2- Recrute members to guilds");
				StdOut.println("3- Shop (sell or buy an item)");
				StdOut.println("4- Simulate a combat!!!");
				StdOut.println("\nPlease Choose one option (-1 to exit)");
				int option = scanner.nextInt();
				switch(option) {
				case 1:
					addnewplayer(system);
					continue;
				case 2:
					recruitingmembers(system);
					continue;
				case 3:
					shop(system);
					continue;
				case 4:
				
				case -1:
					exit = true;
					break;
				default:
					StdOut.println("XXXXX ENTER A OPTION BETWEEN 1 TO 4 (OR -1 TO EXIT) PLEASE XXXXX");
			
				}
			}catch(InputMismatchException e) {
				StdOut.println("XXXXX ENTER A VALID OPTION PLEASE XXXXX");
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	public static void addnewplayer(SystemTheWorldR2Impl system) {
		boolean exit = false;
		while(!exit) {
			System.out.println("\n▲▲▲ Enter the name of the player you want to add please ▲▲▲");
			String name = StdIn.readString();
			System.out.println("\n▲▲▲ Enter the type of the player please ▲▲▲");
			String type = StdIn.readString();
			if(system.addnewplayer(name, type)) {
				StdOut.println("\n▲▲▲ " + name + " has been entered correctly! :) ▲▲▲");
				exit = true;
				break;
				}
			else {
				StdOut.println("\n▲▲▲ " + name + " already exists, enter another player please ▲▲▲");
				}
			}
		}

	public static void recruitingmembers(SystemTheWorldR2Impl system) {
		if(system.recruitingmembers()) {
			StdOut.println("\n@@@ All these players now have a guild @@@");
		}
		else {
			StdOut.println("\n@@@ There are no players without a guild! @@@ ");
		}
	}

	public static void shop(SystemTheWorldR2Impl system) {
		if(!system.shop()) {
			StdOut.println("\nThe name of the player doesn't exist, please try again");
		}
		else {
			StdOut.println("\nThe transactions were made successfully");
		}
	}

}
