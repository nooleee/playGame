package playGame;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1.전투] [2.설정] [3.종료]");
		int sel = GameManager.scan.nextInt();
		
		if(sel < 1 || sel > 3)
			return true;
		
		
		if(sel == 1) 
			GameManager.nextStage = "BATTLE";
		else if(sel == 2)
			GameManager.nextStage = "SETTING";
		else if(sel == 3)
			GameManager.nextStage = "";
		
		return false;
	}
	
	@Override
	public void setStage() {
	}

}
