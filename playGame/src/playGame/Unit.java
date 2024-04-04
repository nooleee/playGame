package playGame;

public abstract class Unit {
	protected int curhp;
	protected int maxhp;
	protected int power;
	protected String name;
	protected int level;
	protected int def;
	protected int exp;
	protected boolean party;
	protected Item weapon;
	protected Item armor;
	protected Item ring;
	private String state = "노말";
	
	public Unit() {
		
	}
	
	public Unit(String name, int level,  int maxHp, int power, int def, int exp) {
		this.name = name;
		this.curhp = maxHp;
		this.maxhp = maxHp;
		this.power = power;
		this.level = level;
		this.def = def;
		this.exp = exp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public Unit(String name, int level,  int maxHp, int power, int def, int exp, boolean party) {
		super();
		this.name = name;
		this.curhp = maxHp;
		this.maxhp = maxHp;
		this.power = power;
		this.level = level;
		this.def = def;
		this.exp = exp;
		this.party = party;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public void setItem(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}
	
	public void setMonster(int maxHp, int power) {
		this.curhp = maxHp;
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
	
	public int getCurhp() {
		return this.curhp;
	}
	
	public void printStatus() {
		System.out.printf("[이름 : %s]", name);
		System.out.printf("[레벨 : %s]", level);
		
		if(ring != null)
			System.out.printf("[체력 : %d + %d / %d + %d]\n", curhp, ring.power, maxhp, ring.power);
		else 
			System.out.printf("[체력 : %d / %d]\n", curhp, maxhp);
		
		if(weapon != null)
			System.out.printf("[공격력 : %d + %d]", power, weapon.power);
		else
			System.out.printf("[공격력 : %d]", power);
		
		if(armor != null)
			System.out.printf("[방어력 : %d + %d]", def, armor.power);
		else
			System.out.printf("[방어력 : %d]", def);
		
		System.out.printf("[파티중 : %s]", party);
	}
	
	public void printEquitedItem() {
		if(weapon == null)
			System.out.println("[무기 : 없음]");
		else
			System.out.printf("[무기 : %s]\n", weapon.name);
		
		if(armor == null)
			System.out.println("[방어구 : 없음]");
		else
			System.out.printf("[방어구 : %s]\n", armor.name);
		
		if(ring == null)
			System.out.println("[반지 : 없음]");
		else
			System.out.printf("[반지 : %s]\n", ring.name);
	}
	
	public void attack(Monster monster) {
		monster.curhp -= power;
		System.out.printf("[%s]이 [%s]에게 %d의 데미지를 입힙니다.\n", name, monster.name, power);
		if(monster.curhp <= 0) {
			System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, monster.name);
			monster.curhp = 0;
		}
	}
	
	public void printData() {
		System.out.printf("[%s][%d/%d][%d]\n", name, curhp, maxhp, power);
	}
	

	
}
