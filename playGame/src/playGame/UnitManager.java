package playGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	public	Vector<Player> player_list = new Vector<>();
	public Vector<Monster> monster_list = new Vector<>();
	private String path = "playGame.";
	private String[] mons = {"MonsterWolf", "MonsterBat", "MonsterOrc"};
	private Random ran = new Random();
	
	public UnitManager() {
		player_list.add(new Warrior("전사", 5, 1000, 45, 45, 0));
		player_list.add(new Wizard("마법사", 8, 800, 60, 30, 0));
		player_list.add(new Healer("힐러", 3, 500, 70, 30, 0));
	}
	
	public void monsterRandomSet(int size) {
		for(int i = 0; i < size; i++) {
			int num = ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
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
