package playGame;

public class Player extends Unit {
	
	private String WARRIOR = "전사";
	private String WIZARD = "마법사";
	private String HEALER = "힐러";
	
	public Player(String name, int maxHp, int power) {
		super(name, maxHp, power);
	}

	@Override
	public void skill(Unit target) {
		if(this.name.equals(WARRIOR)) {
			superAttack(target);
		}
		else if(this.name.equals(WIZARD)) {
//			meteo();
		}
		else if(this.name.equals(HEALER)) {
//			heal();
		}
	}
	
	private void superAttack(Unit target) {
		target.curhp -= power *2;
		System.out.printf("[%s]의 스킬 발동!\n", name);
		System.out.printf("[%s]이 [%s]에게 %d의 데미지를 두번 입힙니다.\n", name, target.name, power);
		if(target.curhp <= 0) {
			System.out.printf("[%s]이 [%s]을 쓰러뜨렸습니다.\n", name, target.name);
			target.curhp = 0;
		}
	}
	
}
