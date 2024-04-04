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
}
