package playGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager;
	private Vector<Player> playerList;
	private Vector<Monster> monList;
	private Random ran = new Random();
	private int monDead = 0;
	private int playerDead = 0;
	
	private final int ATTACK = 1;
	private final int SKILL = 2;
	
	
	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				printCharacter();
				if(p_index < playerList.size()) {
					playerAttack(p_index);
					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}
			} else if(!turn) {
				if(m_index < monList.size()) {
					monsterAttack(m_index);
					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			checkLive();
			if(monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	@Override
	public void setStage() {
		unitManager.getInstance();
		unitManager.monster_list.clear();
		unitManager.monsterRandomSet(4);
		playerList = null;
		playerList = unitManager.player_list;
		monList = null;
		monList = unitManager.monster_list;
		monDead = monList.size();
		playerDead = playerList.size();
	}
	
	public void printCharacter() {
		System.out.println("=====[BATTLE]=====");
		System.out.println("=====[PLAYER]=====");
		for(int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("=====[MONSTER]=====");
		for(int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
	}
	
	public void playerAttack(int index) {
		Player player = playerList.get(index);
		if(player.getCurhp() <= 0)
			return;
		
		System.out.println("=====[메뉴 선택]=====");
		System.out.printf("[%s][1.어택][2.스킬]\n", player.name);
		int sel = GameManager.scan.nextInt();
		
		if(sel == ATTACK) {
			while(true) {
				int idx = ran.nextInt(monList.size());
				
				if(monList.get(idx).getCurhp() > 0) {
					player.attack(monList.get(idx));
					break;
				}
			}
		} else if(sel == SKILL) {
			player.skill(monList, playerList);
		}
	}
	
	public void monsterAttack(int index) {
		Monster monster = monList.get(index);
		if(monster.getCurhp() <= 0) 
			return;
		
		while(true) {
			int idx = ran.nextInt(playerList.size());
			int rNum = ran.nextInt(4) + 1;
			if(playerList.get(idx).getCurhp() > 0) {
				if(rNum == SKILL) {
					monster.skill(playerList);
					break;
				}
				else {
					monster.attack(playerList.get(idx));
					break;
				}
			}
		}
	}
	
	public void checkLive() {
		int num = 0;
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getCurhp() <= 0)
				num += 1;
		}
		
		playerDead = playerList.size() - num;
		num = 0;
		
		for(int i = 0; i < monList.size(); i++)
			if(monList.get(i).getCurhp() <= 0)
				num += 1;
				
		monDead = monList.size() - num;
	}
	
	
}
