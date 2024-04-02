package playGame;

import java.util.Vector;

public class UnitWolf extends Unit {
	
	public UnitWolf() {
		name = "늑대";
	}

	@Override
	public void skill(Vector<Unit> monList, Vector<Player> playerList) {
		System.out.println("적 전체에게 공격력의 절반 데미지");
		
	}

}
