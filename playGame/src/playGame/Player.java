package playGame;

import java.util.Random;
import java.util.Vector;

public class Player extends Unit {
	private Random ran = new Random();
	private String WARRIOR = "전사";
	private String WIZARD = "마법사";
	private String HEALER = "힐러";
	
	public Player(String name, int maxHp, int power) {
		super(name, maxHp, power);
	}

	@Override
	public void skill(Vector<Unit> monList, Vector<Player> playerList) {
		if(this.name.equals(WARRIOR)) {
			superAttack(monList);
		}
		else if(this.name.equals(WIZARD)) {
			meteo(monList);
		}
		else if(this.name.equals(HEALER)) {
			heal(playerList);
		}
	}
	
	private void superAttack(Vector<Unit> list) {
		int idx = ran.nextInt(list.size());
		Unit target = list.get(idx);
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
	
	private void meteo(Vector<Unit> list) {
		int cnt = 0;
		while(true) {
			Unit target = list.get(cnt ++);
			if(target.getCurhp() > 0) {
				target.curhp -= (power / 5 * 3);
				if(target.curhp <= 0) {
					System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
					target.curhp = 0;
				}
			}
			
			if(cnt == list.size())
				break;
			
		}
		System.out.printf("[%s]의 스킬 발동!\n", name);
		System.out.printf("[%s]이 적 전체에게 POWER의 60프로의 힘으로 메테오를 날립니다.\n", name);
	}
	
	private void heal(Vector<Player> list) {
		for(int i = 0; i < list.size(); i++) {
			Player target = list.get(i);
			target.curhp += this.power;
			if(target.curhp > target.maxhp)
				target.curhp = target.maxhp;
		}
		System.out.printf("[%s]가 아군 전체에게 %d만큼 체력 회복\n", this.name, this.power);
	}
	
	
	
}
