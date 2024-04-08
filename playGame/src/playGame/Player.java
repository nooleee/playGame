package playGame;

import java.util.ArrayList;
import java.util.Vector;

public abstract class Player extends Unit {
	
	public static int money = 10000;
	
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();
	
	public Player() {};
	
	public Player(String name, int level,  int maxHp, int power, int def, int code) {
		super(name, level, maxHp, power, def, code);
	}
	
	public Player(String name, int level,  int maxHp, int power, int def, boolean party, int code) {
		super(name, level, maxHp, power, def, party, code);
	}
	
	public abstract void skill(Vector<Monster> monList, Vector<Player> playerList);

	public void guildMenu() {
		guild.guildMenu();
	}
	
	public void inventoryMenu() {
		inven.inventoryMenu();
	}
	
	public static Vector<Player> getGuildList() {
		return guild.getGuildList();
	}
	
	public static ArrayList<Item> getItemList() {
		return inven.getItemList();
	}
	
	public static Player getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}
	
	public static int getGuildSize() {
		return guild.getGuildList().size();
	}
	
	public static int getItemSize() {
		return inven.getItemList().size();
	}
	
	
}
