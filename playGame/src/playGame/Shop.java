package playGame;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> itemList = new ArrayList<>();
	
	public Shop() {
		Item temp = new Item();
		temp.setItem(Item.WEAPON, "나무검", 3, 1000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.WEAPON, "철검", 5, 2000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.WEAPON, "레이피어", 7, 2500);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.ARMOR, "티셔츠", 1, 300);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.ARMOR, "가죽갑옷", 4, 800);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.ARMOR, "강철갑옷", 7, 1500);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.RING, "은반지", 7, 3000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.RING, "금반지", 17, 6000);
		itemList.add(temp);
		
		temp = new Item();
		temp.setItem(Item.RING, "다이아반지", 35, 20000);
		itemList.add(temp);
	}
	
	public void shopMenu() {
		while(true) {
			System.out.println("==========[상점]==========");
			System.out.println("[1.무기] [2.방어구] [3.반지] [0.뒤로가기]");
			int sel = GameManager.scan.nextInt();
			
			if(sel < 0 || sel > 3)
				continue;
			
			if(sel == 0)
				break;
			
			while(true) {
				if(sel == Item.WEAPON) 
					System.out.println("==========[무기]==========");
				else if(sel == Item.ARMOR) 
					System.out.println("==========[방어구]==========");
				else if(sel == Item.RING) 
					System.out.println("==========[반지]==========");
				
				printItem(sel);
				
				System.out.println("============================");
				System.out.printf("[골드 : %d]\n", Player.money);
				System.out.println("구입할 아이템을 선택하세요.[0.뒤로가기]");
				
				int choice = GameManager.scan.nextInt();
				
				if(choice == 0)
					break;
				
				int cnt = 0;
				for(int i = 0; i < itemList.size(); i++) {
					Item item = itemList.get(i);
					if(item.getKind() == sel) {
						cnt++;
						if(cnt == choice) {
							Player.inven.addItem(item);
							Player.money -= item.getPrice();
							System.out.println("[아이템 구입 완료]");
							break;
						}
					}
				}
			}
		}
	}
	
	private void printItem(int sel) {
		int cnt = 0;
		for(int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);
			if(item.getKind() == sel) {
				System.out.printf("[%d번]\n", cnt+1);
				System.out.printf("[이름 : %s] [능력 : %d] [가격 : %d]\n", item.getName(), item.getPower(), item.getPrice());
				cnt++;
			}
			else
				continue;
		}
	}
	
}
