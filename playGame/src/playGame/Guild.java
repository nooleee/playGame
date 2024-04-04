package playGame;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private final int SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	private Random ran = new Random();
	private Unit[] partyList;
	
	public void setGuild() {
		guildList.add(new Warrior("전사", 5, 1000, 45, 45, 0));
		guildList.add(new Wizard("마법사", 8, 800, 60, 30, 0));
		guildList.add(new Healer("힐러", 3, 500, 70, 30, 0));
		
		for(int i = 0; i < SIZE; i++) {
			guildList.get(i).party = true;
		}
		
		partyList = new Unit[SIZE];
		
		int cnt = 0;
		for(int i = 0 ; i < guildList.size(); i++) {
			Player target = guildList.get(i);
			if(target.party) 
				partyList[cnt ++] = target;
		}
	}
	
	public Player getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public void printAllUnitStatus() {
		System.out.println("===============");
		System.out.printf("[골드 : %d]\n", Player.money);
		System.out.println("===============");
		for(int i = 0; i < guildList.size(); i++) {
			Unit target = guildList.get(i);
			System.out.printf("[%d번]", i+1);
			target.printStatus();
		}
	}
	
	public void printUnitStatus(int sel) {
		guildList.get(sel).printStatus();
	}
	
	
}
