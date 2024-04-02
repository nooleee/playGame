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
	
	

	
}
