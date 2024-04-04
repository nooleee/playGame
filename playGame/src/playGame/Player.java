package playGame;

import java.util.Vector;

public abstract class Player extends Unit {
	
	public Player(String name, int maxHp, int power) {
		super(name, maxHp, power);
	}
	
	public abstract void skill(Vector<Monster> monList, Vector<Player> playerList);

	
	
	
}
