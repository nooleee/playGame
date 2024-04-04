package playGame;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<>();
	
	private final int WEAR = 1;
	private final int SELL = 2;
	
	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤토리 메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = GameManager.scan.nextInt();
			
			if(sel < 0 || sel > 2)
				return;
			
			if (sel == 0)
				break;
			if (sel == WEAR) {}
//	          equipMenu();
			else if (sel == SELL) {}
//	          sellMenu();
		}
	}
}
