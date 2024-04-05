package playGame;

import java.util.ArrayList;
import java.util.Vector;

public abstract class Player extends Unit {
	
	public static int money;
	
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();
	
	private void setPlayer() {
		money = 10000;
		guild.setGuild();
	}
	
	public Player(String name, int level,  int maxHp, int power, int def, int exp) {
		super(name, level, maxHp, power, def, exp);
	}
	
	public Player(String name, int level,  int maxHp, int power, int def, int exp, boolean party) {
		super(name, level, maxHp, power, def, exp, party);
	}
	
	public abstract void skill(Vector<Monster> monList, Vector<Player> playerList);

	  public void guildMenu() {
	    guild.guildMenu();
	  }

	  public void inventoryMenu() {
	    inven.inventoryMenu();
	  }

	  static public Vector<Player> getGuildList() {
	    return guild.getGuildList();
	  }

	  static public ArrayList<Item> getItemList() {
	    return inven.getItemList();
	  }

	  static public Player getGuildUnit(int num) {
	    return guild.getGuildUnit(num);
	  }

	  static public int getGuildSize() {
	    return guild.getGuildList().size();
	  }

	  static public int getItemSize() {
	    return inven.getItemList().size();
	  }
	
	
}
