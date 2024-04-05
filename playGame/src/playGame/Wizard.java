package playGame;

import java.util.Vector;

public class Wizard extends Player {

	public Wizard(String name, int level,  int maxHp, int power, int def, int code) {
		super(name, level, maxHp, power, def, code);
	}

	@Override
	public void skill(Vector<Monster> monList, Vector<Player> playerList) {
		int cnt = 0;
		while(true) {
			Monster target = monList.get(cnt ++);
			if(target.getCurhp() > 0) {
				target.curhp -= (power / 5 * 3);
				if(target.curhp <= 0) {
					System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
					target.curhp = 0;
				}
			}
			
			if(cnt == monList.size())
				break;
			
		}
		System.out.printf("[%s]의 스킬 발동!\n", name);
		System.out.printf("[%s]이 적 전체에게 POWER의 60프로의 힘으로 메테오를 날립니다.\n", name);
		
	}

}
