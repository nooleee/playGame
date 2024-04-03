package playGame;

import java.util.Random;
import java.util.Vector;

public class UnitBat extends Unit {
	private Random ran = new Random();
	
	public UnitBat() {
		name = "박쥐";
	}

	@Override
	public void skill(Vector<Unit> monList, Vector<Player> playerList) {
		int idx = ran.nextInt(playerList.size());
		Unit target = playerList.get(idx);
		if(target.getCurhp() > 0) {
			target.curhp -= power;
			this.curhp += power / 2;
			System.out.printf("[%s]의 스킬 발동!\n", name);
			System.out.printf("[%s]가 [%s]에게 %d만큼의 피해를 입히고 피해량의 절반을 회복합니다.\n", name, target.name, power);
			if(target.curhp <= 0) {
				System.out.printf("[%s]가 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
				target.curhp = 0;
			}
		}
	}

}
