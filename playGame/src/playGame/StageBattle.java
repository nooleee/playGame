package playGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager = new UnitManager();
	private Vector<Player> playerList;
	private Vector<Unit> monList;
	private Random ran = new Random();
	private int monDead = 0;
	private int playerDead = 0;
	
	@Override
	public boolean update() {
//		boolean run = true;
//		int p_index = 0;
//		int m_index = 0;
//		boolean turn = true;
		
		return false;
	}
	@Override
	public void init() {
		unitManager.monster_list.clear();
		unitManager.monsterRandomSet(4);
		playerList = null;
		playerList = unitManager.player_list;
		monList = null;
		monList = unitManager.monster_list;
		monDead = monList.size();
		playerDead = playerList.size();
	}
	
	
	
}
