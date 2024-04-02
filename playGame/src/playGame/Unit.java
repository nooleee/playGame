package playGame;

public abstract class Unit {
	private int curhp;
	private int maxhp;
	private int power;
	protected String name;
	private String state = "노말";
	
	public Unit() {
		
	}
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.curhp = maxHp;
		this.maxhp = maxHp;
		this.power = power;
	}
	
	public void setMonster(int maxHp, int power) {
		this.maxhp = maxHp;
		this.power = power;
	}
	
	public void setPlayer(String name, int maxhp, int power) {
		this.name = name;
		this.curhp = maxhp;
		this.maxhp = maxhp;
		this.power = power;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	public void attack(Unit target) {
		target.curhp -= power;
		System.out.printf("[%s]이 [%s]에게 %d의 데미지를 입힙니다.\n", name, target.name, power);
		if(target.curhp <= 0) {
			System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.", name, target.name);
			target.curhp = 0;
		}
	}
	
	public void printData() {
		System.out.printf("[%s][%d/%d][%d]", name, curhp, maxhp, power);
	}
	
	public abstract void skill(Unit target);
	
}
