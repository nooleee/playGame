package playGame;

import java.util.Vector;

public abstract class Monster extends Unit {
	public Monster() {
		
	}
	
	public Monster(String name, int maxHp, int power) {
		this.name = name;
		this.curhp = maxHp;
		this.maxhp = maxHp;
		this.power = power;
	}
	
	public void setMonster(int maxHp, int power) {
		this.curhp = maxHp;
		this.maxhp = maxHp;
		this.power = power;
	}
	
	
	public int getCurhp() {
		return this.curhp;
	}
	
	
	
//	public void attack(Unit target) {
//		target.curhp -= power;
//		System.out.printf("[%s]이 [%s]에게 %d의 데미지를 입힙니다.\n", name, target.name, power);
//		if(target.curhp <= 0) {
//			System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
//			target.curhp = 0;
//		}
//	}
	
	public void printData() {
		System.out.printf("[%s][%d/%d][%d]\n", name, curhp, maxhp, power);
	}
	
	public abstract void skill(Vector<Player> playerList);
}
