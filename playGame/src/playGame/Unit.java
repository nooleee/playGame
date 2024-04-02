package playGame;

public abstract class Unit {
	private int hp;
	private int maxHp;
	private int power;
	private String name;
	private String state = "노말";
	
	public Unit() {
		
	}
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.power = power;
	}
	
	public void setMonster(int maxHp, int power) {
		this.maxHp = maxHp;
		this.power = power;
	}
	
	
	public void attack(Unit target) {
		target.hp -= power;
		System.out.printf("[%s]이 [%s]에게 %d의 데미지를 입힙니다.\n", name, target.name, power);
		if(target.hp <= 0) {
			System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.", name, target.name);
			target.hp = 0;
		}
	}
	
	public abstract void skill(Unit target);
	
}
