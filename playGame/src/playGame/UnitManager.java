package playGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private	Vector<Player> player_list = new Vector<>();
	private Vector<Unit> monster_list = new Vector<>();
	private String path = "";
	private String[] mons = {"UnitWolf", "UnitBat", "UnitOrc"};
	private Random ran = new Random();
	
	public UnitManager() {
		player_list.add(new Player("전사", 1000, 45));
		player_list.add(new Player("마법사", 800, 60));
		player_list.add(new Player("힐러", 500, 70));
	}
}
