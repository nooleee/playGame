package playGame;

public class UnitBat extends Unit {
	
	public UnitBat() {
		name = "박쥐";
	}

	@Override
	public void skill(Unit target) {
		System.out.println("적 한명에게 침묵 시전");
		
	}

}
