package playGame;

import java.util.Vector;

public class Healer extends Player {

	public Healer(String name, int level,  int maxHp, int power, int def) {
		super(name, level, maxHp, power, def);
	}

	@Override
	public void skill(Vector<Monster> monList, Vector<Player> playerList) {
		for(int i = 0; i < playerList.size(); i++) {
			Player target = playerList.get(i);
			target.curhp += this.power;
			if(target.curhp > target.maxhp)
				target.curhp = target.maxhp;
		}
		System.out.printf("[%s]가 아군 전체에게 %d만큼 체력 회복\n", this.name, this.power);
		
	}

}
