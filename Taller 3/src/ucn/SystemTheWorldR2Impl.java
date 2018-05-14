package ucn;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class SystemTheWorldR2Impl implements SystemTheWorldR2{
	private ArrayPlayer ap;
	private ArrayGuild ag;
	private ArrayItem it;

	public SystemTheWorldR2Impl() {
		ap = new ArrayPlayer(1000);
		ag = new ArrayGuild(1000);
		it = new ArrayItem(1000);
	}
	
	@Override
	public boolean addnewplayer(String name, String type) {
		return ap.addnewplayer(name, type);
		
	}
	
	@Override
	public boolean recruitingmembers() {
		return ap.playeremptyguild(ag);
	}
	
	@Override
	public boolean buy(Player player) {
		for(int i=0; i<10; i++) {
			int num = (int) (Math.random()*it.getQuanitem());
			StdOut.println(it.getIt()[num].getName() + " this is a/an " + it.getIt()[num].getClass().getSimpleName());
		}
		System.out.println("\nChoose the name of one of these items");
		String name = StdIn.readString();
		Item itemchoose = it.getitem(name);
		String itemchooseclass = itemchoose.getClass().getSimpleName();
		if(itemchooseclass.equals("Weapon")) {
			Item itempossesed = player.verifyweapon(name);
			if(itempossesed != null) {
				Weapon weaponchoose = (Weapon) itemchoose;
				Weapon weaponpossesed = (Weapon) itempossesed;
				if(replaceweapon(weaponchoose, weaponpossesed, player)) {
					return true;
				}
				return false;
				
			}
			else {
				return it.additeminventory(name, player);
			}
		}
		else if(itemchooseclass.equals("Armor")) {
			Item itempossesed = player.verifyarmor(name);
			if(itempossesed != null) {
				Armor armorchoose = (Armor) itemchoose;
				Armor armorpossesed = (Armor) itempossesed;
				if(replacearmor(armorchoose, armorpossesed, player)) {
					return true;
				}
				return false;
				
			}
			else {
				return it.additeminventory(name, player);
			}
		}
		return it.additeminventory(name, player);
	}
	
	@Override
	public boolean sell(Player player) {
		boolean exit = false;
		if(player.printinventory(player)) {
			while(!exit) {
				StdOut.println("\nDo you want to sell a item?");
				String option = StdIn.readString();
				option = option.toLowerCase();
				switch(option) {
				case "yes":
					StdOut.println("\nEnter the name of the item you want to sell");
					String name = StdIn.readString();
					if(player.verifyitem(name)) {
						StdOut.println("\nYou Sold the item "+name+" :)");
						return true;
					}
					else {
						StdOut.println("\nItem not found, please try again");
						continue;
					}
				case "no":
					StdOut.println("\nYou choosen didn't sell any item");
					exit = true;
					break;
				default:
					StdOut.println("\nXXXXX Choose a valid option please XXXXX");
				}
			}
		}
		return false;
	}
	
	public boolean shop() {
		Player player = ap.allplayers();
		if(player == null) {
			
			return false;
		}
		submenushop(player);
		return true;
		
	}
	
	public void addplayer(Player player) {
		ap.addplayer(player);
	}
	
	public void addguild(Guild guild) {
		ag.addguild(guild);
	}
	
	public void additem(Item item) {
		it.additem(item);
	}
	
	public void submenushop(Player player) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			try{
				StdOut.println("\n1- Buy an Item");
				StdOut.println("2- Sell an Item");
				StdOut.println("\nPlease Choose one option (-1 to return to main menu)");
				int option = scanner.nextInt();
				switch(option) {
				case 1:
					if(buy(player)) {
						StdOut.println("\nThe item selected has been bought and added to "+player.getName()+"'s inventory");
					}
					else {
						StdOut.println("\nNo items has been added to the inventory");
					}
					continue;
				case 2:
					if(sell(player)) {
						StdOut.println("\nThe item selected has been sold");
					}
					continue;
				case -1:
					exit = true;
					break;
				default:
					StdOut.println("XXXXX ENTER A OPTION BETWEEN 1 TO 2 (OR -1 TO EXIT) PLEASE XXXXX");
			
				}
			}catch(InputMismatchException e) {
				StdOut.println("XXXXX ENTER A VALID OPTION PLEASE XXXXX");
				scanner.nextLine();
			}
		}
	}

	public boolean replaceweapon(Weapon choosen, Weapon possesed , Player player) {
		boolean exit = false;
		while(!exit) {
			StdOut.println("\nNew [ Name: "+choosen.getName()+", Type: "+choosen.getType()+", Attack:"+choosen.getAttack_value()+"]");
			StdOut.println("Old [ Name: "+possesed.getName()+", Type: "+possesed.getType()+ ", Attack:"+possesed.getAttack_value()+"]");
			System.out.println("\n" + player.getName() + " already has a weapon, Do you want to replace him?");
			String option = StdIn.readString();
			option = option.toLowerCase();
			if(option.equals("sí")) {
				option = "si";
			}
			switch(option){
				case "si":
					player.replaceweapon(choosen);
					return true;
				case "no":
					StdOut.println("\nThere were no changes");
					exit = true;
					break;
				default:
					StdOut.println("\nXXXXX Choose a valid option please XXXXX");
			}
		}
		return false;
		
	}
	
	public boolean replacearmor(Armor choosen, Armor possesed , Player player) {
		boolean exit = false;
		while(!exit) {
			StdOut.println("\nNew [ Name: "+choosen.getName()+", Type: "+choosen.getType()+", Defense:"+choosen.getValue()+"]");
			StdOut.println("Old [ Name: "+possesed.getName()+", Type: "+possesed.getType()+ ", Defense:"+possesed.getValue()+"]");
			System.out.println("\n" + player.getName() + " already has a armor, Do you want to replace him?");
			String option = StdIn.readString();
			option = option.toLowerCase();
			if(option.equals("sí")) {
				option = "si";
			}
			switch(option){
				case "si":
					player.replacearmor(choosen);
					return true;
				case "no":
					StdOut.println("\nThere were no changes");
					exit = true;
					break;
				default:
					StdOut.println("\nXXXXX Choose a valid option please XXXXX");
			}
		}
		return false;
		
	}

	
	
	
	
}
