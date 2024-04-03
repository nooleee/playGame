package playGame;

import java.util.Random;
import java.util.Vector;

public class MonsterOrc extends Monster {
	private Random ran = new Random();
	
	public MonsterOrc() {
		name = "오크";
	}

	@Override
	public void skill(Vector<Player> playerList) {
		int idx = ran.nextInt(playerList.size());
		Unit target = playerList.get(idx);
		if(target.getCurhp() > 0) {
			target.curhp -= power * 2;
			System.out.printf("[%s]의 스킬 발동!\n", name);
			System.out.printf("[%s]가 [%s]에게 %d의 두배만큼 피해를 입힙니다.\n", name, target.name, power);
			if(target.curhp <= 0) {
				System.out.printf("[%s]가 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
				target.curhp = 0;
			}
		}
	}

}
