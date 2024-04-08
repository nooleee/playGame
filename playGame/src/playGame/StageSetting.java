package playGame;

import java.util.Random;

public class StageSetting extends Stage {
	private Random ran = new Random();
	private UnitManager unitManager = null;
	private Shop shop;
	private FileData fileData;
	
	
	private final int GUILD = 1;
	private final int SHOP = 2;
	private final int INVEN = 3;
	private final int SAVE = 4;
	private final int LOAD = 5;

	@Override
	public boolean update() {
		while(true) {
			System.out.println("======= [메인 메뉴] =======");
			System.out.println("[1.길드관리]  [2.상점]  [3.인벤토리]");
			System.out.println("[4.저장]     [5.로드]  [0.뒤로가기]");
			int sel = GameManager.scan.nextInt();
			
			if(sel < 0 || sel > 5)
				continue;
			
			if(sel == GUILD)
				Player.guild.guildMenu();
			else if(sel == SHOP)
				shop.shopMenu();
			else if(sel == INVEN)
				Player.inven.inventoryMenu();
			else if(sel == SAVE) {
				fileData.saveData();
			}
			else if(sel == LOAD) {
				fileData.loadData();
			}
			else if(sel == 0) {
				GameManager.nextStage = "LOBBY";
				break;
			}
		}
		return false;
	}

	@Override
	public void setStage() {
		UnitManager.getInstance();
		shop = new Shop();
		fileData = new FileData();
		
	}

}
