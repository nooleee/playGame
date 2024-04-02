package playGame;

import java.util.Vector;

public class UnitBat extends Unit {
	
	public UnitBat() {
		name = "박쥐";
	}

	@Override
	public void skill(Vector<Unit> monList, Vector<Player> playerList) {
		System.out.println("적 한명에게 침묵 시전");
		
	}

}
