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
			
			if (sel == WEAR)
	          equipMenu();
	        else if (sel == SELL) {}
//	          sellMenu();
			else if (sel == 0)
				break;
		}
	}
	
	private void equipMenu() {
		Guild guild = Player.guild;
		guild.printAllUnitStatus();
		System.out.println("아이템을 착용 할 길드원을 선택하세요.");
		int sel = GameManager.scan.nextInt() - 1;
		
		
		if(sel < 0 || sel > Player.getGuildSize())
			return;
		
		guild.printUnitStatus(sel);
		guild.printUnitItem(sel);
		printItemList();
		
	}
	
	private void printItemList() {
		System.out.println("========[아이템 리스트]========");
		for(int i = 0; i < itemList.size(); i++) {
			Item target = itemList.get(i);
			String info = String.format("[%d번][이름 : %s][능력 : %d][가격 : %d]\n", i+1, target.getName(), target.getPower(), target.getPrice());
			System.out.println(info);
		}
	}
}
