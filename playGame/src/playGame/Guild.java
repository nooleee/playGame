package playGame;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private final int SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	private Random ran = new Random();
	private Unit[] partyList;
	
	private void setGuild() {
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
}
