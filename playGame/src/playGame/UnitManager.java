package playGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	public	Vector<Player> player_list = new Vector<>();
	public Vector<Unit> monster_list = new Vector<>();
	private String path = "playGame.";
	private String[] mons = {"UnitWolf", "UnitBat", "UnitOrc"};
	private Random ran = new Random();
	
	public UnitManager() {
		player_list.add(new Player("전사", 1000, 45));
		player_list.add(new Player("마법사", 800, 60));
		player_list.add(new Player("힐러", 500, 70));
	}
	
	public void monsterRandomSet(int size) {
		for(int i = 0; i < size; i++) {
			int num = ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int power = ran.nextInt(10) + 10;
				temp.setMonster(hp, power);
				monster_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
