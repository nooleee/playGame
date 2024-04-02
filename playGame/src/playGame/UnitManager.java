package playGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private	Vector<Player> player_list = new Vector<>();
	private Vector<Unit> monster_list = new Vector<>();
	private String path = "";
	private String[] mons = {"UnitWolf", "UnitBat", "UnitOrc"};
	private Random ran = new Random();
}
