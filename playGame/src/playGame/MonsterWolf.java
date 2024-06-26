package playGame;

import java.util.Vector;

public class MonsterWolf extends Monster {
	
	public MonsterWolf() {
		name = "늑대";
	}

	@Override
	public void skill(Vector<Player> playerList) {
		int cnt = 0;
		while(true) {
			Unit target = playerList.get(cnt ++);
			if(target.getCurhp() > 0) {
				target.curhp -= (power / 2);
				if(target.curhp <= 0) {
					System.out.printf("[%s]가 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
					target.curhp = 0;
				}
			}
			
			if(cnt == playerList.size())
				break;
			
		}
		System.out.printf("[%s]의 스킬 발동!\n", name);
		System.out.printf("[%s]가 적 전체에게 %d의 절반의 힘으로 할퀴기 공격을 합니다.\n", name, power);
	}

}
