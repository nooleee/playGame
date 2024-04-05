package playGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class FileData {
	private UnitManager unitManager = UnitManager.getInstance();
	private Vector<Player> info = Player.getGuildList();
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
			System.out.println("파일 저장 완료");
		} catch (IOException e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
		
	}
	
	private String writeData() {
		String gameData = "";
		gameData += Player.money;
		gameData += "\n";
		gameData += info.size();
		gameData += "\n";
		
		gameData += writeEquipment(info);
		
		gameData += Player.getItemSize();
		gameData += "\n";
		
		gameData += writeItemData();
		
		
		
		return gameData;
	}
	
	private String writeEquipment(Vector<Player> info) {
		String result = "";
		for(int i = 0; i < info.size(); i++) {
			Player temp = info.get(i);
			String data = String.format("%s/%d/%d/%d/%d/%s\n", temp.name, temp.level, temp.maxhp, temp.power, temp.def, temp.party);
			result += data;
			if(temp.weapon == null)
				result += temp.weapon;
			else {
				Item item = temp.weapon;
				String weaponData = String.format("%d,%s,%d,%d/", item.getKind(), item.getName(), item.getPower(), item.getPrice());
				result += weaponData;
			}
			
			if(temp.armor == null)
				result += temp.armor;
			else {
				Item item = temp.armor;
				String armorData = String.format("%d,%s,%d,%d/", item.getKind(), item.getName(), item.getPower(), item.getPrice());
				result += armorData;
			}
			
			if(temp.ring == null)
				result += temp.ring;
			else {
				Item item = temp.ring;
				String ringData = String.format("%d,%s,%d,%d", item.getKind(), item.getName(), item.getPower(), item.getPrice());
				result += ringData;
			}
			
			result += "\n";
		}
		
		return result;
	}
	
	private String writeItemData() {
		String data = "";
		for(int i = 0; i < Player.getItemSize(); i++) {
			Item item = Player.getItemList().get(i);
			data = String.format("%d/%s/%d/%d\n", item.getKind(), item.getName(), item.getPower(), item.getPrice());
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	public void loadData() {
		
	}
}
