package playGame;

import java.util.Random;
import java.util.Vector;

public class Warrior extends Player {
	public Warrior(String name, int level,  int maxHp, int power, int def, int exp) {
		super(name, level, maxHp, power, def, exp);
	}

	private Random ran = new Random();

	@Override
	public void skill(Vector<Monster> monList, Vector<Player> playerList) {
		int idx = ran.nextInt(monList.size());
		Monster target = monList.get(idx);
		if(target.getCurhp() > 0) {
			target.curhp -= power *2;
			System.out.printf("[%s]의 스킬 발동!\n", name);
			System.out.printf("[%s]이 [%s]에게 %d의 데미지를 두번 입힙니다.\n", name, target.name, power);
			if(target.curhp <= 0) {
				System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
				target.curhp = 0;
			}
		}
		
	}

}
