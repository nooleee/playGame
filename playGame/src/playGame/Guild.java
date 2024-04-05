package playGame;

import java.util.Random;
import java.util.Vector;

public class Guild {
	private final int SIZE = 3;
	private Vector<Player> guildList = new Vector<>();
	private Random ran = new Random();
	private Unit[] partyList;
	
	private final int SHOW_GUILD = 1;
	private final int ADD = 2;
	private final int DELETE = 3;
	private final int CHANGE = 4;
	private final int BACK = 0;
	
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
	
	public void printUnitItem(int sel) {
		guildList.get(sel).printEquitedItem();
	}

	
	public void guildMenu() {
		while(true) {
			System.out.println("==========[길드 관리]==========");
			System.out.println("[1.길드 목록]   [2.길드원 추가]  [3.길드원 삭제]");
			System.out.println("[4.파티원 교체]  [0.종료]");
			int sel = GameManager.scan.nextInt();
			
			if(sel < 0 || sel > 4)
				return;
			
			if(sel == SHOW_GUILD)
				printAllUnitStatus();
			else if(sel == ADD)
				buyUnit();
			else if(sel == DELETE)
				removeUnit();
			else if(sel == CHANGE)
				partyChange();
			else if(sel == BACK)
				break;
		}
	}
	
	private void buyUnit() {
		if(Player.money < 5000) 
			return;
			
		String[] random1 = {"김", "이", "최", "박", "유", "한"};
		String[] random2 = {"명", "민", "지", "열", "진", "설"};
		String[] random3 = {"수", "하", "이", "담", "기", "음"};
		
		String name = random1[ran.nextInt(random1.length)];
		name += random2[ran.nextInt(random2.length)];
		name += random3[ran.nextInt(random3.length)];
		
		int rNum = ran.nextInt(8) + 2;
		int hp = rNum * 11;
		int attack = rNum * 7 + 5;
		int def = rNum * 10 / 2;
		
		System.out.println("===============================");
		System.out.printf("[이름 : %s]",name);
		System.out.print(" [레벨 : 1]");
		System.out.printf(" [체력 : %d / %d]\n", hp, hp);
		System.out.printf("[공격력 : %d]",attack);
		System.out.printf(" [방어력 : %d\n",def);
		System.out.println("길드원을 추가합니다.");
		System.out.println("===============================");
		
		
		Warrior temp1 = new Warrior(name, 1, hp, attack, def, 0);
		Wizard temp2 = new Wizard(name, 1, hp, attack, def, 0);
		Healer temp3 = new Healer(name, 1, hp, attack, def, 0);
		
		Player[] type = {temp1, temp2, temp3};
		
		rNum = ran.nextInt(SIZE);
		
		guildList.add(type[rNum]);
		Player.money -= 5000;
	}
	
	public void removeUnit() {
		printAllUnitStatus();
		System.out.println("삭제할 번호를 입력하세요.");
		int sel = GameManager.scan.nextInt() - 1;
		
		if(sel < 0 || sel > guildList.size())
			return;
		
		if(guildList.get(sel).party)
			System.out.println("파티중인 멤버는 삭제할 수 없습니다.");
		else {
			System.out.println("===============================");
			System.out.printf("[이름 : %s]\n", guildList.get(sel).name);
			System.out.println("길드원을 삭제합니다.");
			System.out.println("===============================");
			guildList.remove(sel);
		}
	}
	
	public void printParty() {
		System.out.println("=============[파티원]============");
		for(int i = 0; i < partyList.length; i++) {
			Unit target = partyList[i];
			System.out.printf("[%d]\n", i+1);
			target.printStatus();
		}
		System.out.println("===============================");
	}
	
	public void partyChange() {
		printParty();
		System.out.println("교체할 파티원의 번호를 선택하세요.");
		int sel = GameManager.scan.nextInt() - 1;
		
		if(sel < 0 || sel > partyList.length)
			return;
		
		printAllUnitStatus();
		System.out.println("참가할 유닛의 번호를 선택하세요");
		int cNum = GameManager.scan.nextInt() - 1;
		
		if(guildList.get(cNum).party) {
			System.out.println("이미 참가중인 파티원입니다.");
			return;
		}
		
		partyList[sel].party = false;
		guildList.get(cNum).party = true;
		
		int cnt = 0;
		for(int i = 0 ; i < guildList.size(); i++) {
			Player target = guildList.get(i);
			if(target.party) 
				partyList[cnt ++] = target;
		}
	}
	
	public Vector<Player> getGuildList() {
		return guildList;
	}
	
}
