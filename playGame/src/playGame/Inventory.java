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
	        else if (sel == SELL) 
	          sellMenu();
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
		
		while(true) {
			guild.printUnitStatus(sel);
			guild.printUnitItem(sel);
			printItemList();
			
			System.out.println("착용 할 아이템 번호를 입력하세요.[0.뒤로가기]");
			int itemNum = GameManager.scan.nextInt() - 1;
			
			if(itemNum < 0 || itemNum > itemList.size())
				continue;
			
			if(itemNum == 0)
				break;
			
			if(itemList.get(itemNum).getKind() == Item.WEAPON) {
				if(Player.getGuildUnit(sel).weapon != null)
					itemList.add(Player.getGuildUnit(sel).weapon);
				Player.getGuildUnit(sel).weapon = itemList.get(itemNum);
			}
			else if(itemList.get(itemNum).getKind() == Item.ARMOR) {
				if(Player.getGuildUnit(sel).armor != null)
					itemList.add(Player.getGuildUnit(sel).armor);
				Player.getGuildUnit(sel).armor = itemList.get(itemNum);
			}
			else if(itemList.get(itemNum).getKind() == Item.RING) {
				if(Player.getGuildUnit(sel).ring != null)
					itemList.add(Player.getGuildUnit(sel).ring);
				Player.getGuildUnit(sel).ring = itemList.get(itemNum);
			}
			
			itemList.remove(itemNum);
		}
	}
	
	private void printItemList() {
		System.out.println("========[아이템 리스트]========");
		for(int i = 0; i < itemList.size(); i++) {
			Item target = itemList.get(i);
			String info = String.format("[%d번][이름 : %s][능력 : %d][가격 : %d]\n", i+1, target.getName(), target.getPower(), target.getPrice());
			System.out.println(info);
		}
	}
	
	private void sellMenu() {
		while(true) {
			printItemList();
			System.out.printf("[골드 : %d]\n", Player.money);
			System.out.println("판매할 아이템 번호를 입력하세요(50%세금)[0.뒤로가기]");
			int sel = GameManager.scan.nextInt() - 1;
			
			if(sel < 0 || sel > itemList.size())
				continue;
			if(sel == 0)
				break;
			
			System.out.printf("[%s]를(을) 판매합니다\n", itemList.get(sel).getName());
			
			Player.money += itemList.get(sel).getPrice() / 2;
			itemList.remove(sel);
		}
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
}
