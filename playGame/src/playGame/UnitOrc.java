package playGame;

import java.util.Vector;

public class UnitOrc extends Unit {
	
	public UnitOrc() {
		name = "오크";
	}

	@Override
	public void skill(Vector<Unit> monList, Vector<Player> playerList) {
		System.out.println("한명에게 2배의 데미지 + 기절");
		
	}

}
