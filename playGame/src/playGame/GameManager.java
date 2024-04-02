package playGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	private Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	private String curStage = "";
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	public GameManager() {
//		stageList.put("TITLE", new StageTitle());
//		stageList.put("BATTLE", new StageBattle());
//		stageList.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	
}
