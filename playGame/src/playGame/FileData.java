package playGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {
	private UnitManager unitManager = UnitManager.getInstance();
	private FileWriter fw = null;
	private String fileName = "TEXT RPG";
	private FileReader fr = null;
	private BufferedReader br = null;
	private File file;
	
	
	public void saveData() {
		String data = writeData();
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String writeData() {
		String gameData = "";
		
		return gameData;
	}
	
	public void loadData() {
		
	}
}
