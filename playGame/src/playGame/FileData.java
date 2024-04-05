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
	private File file = new File(fileName);
	
	
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
		System.out.println(Player.getItemSize());
		gameData += "\n";
		
		gameData += writeItemData();
		
		
		
		return gameData;
	}
	
	private String writeEquipment(Vector<Player> info) {
		String result = "";
		for(int i = 0; i < info.size(); i++) {
			Player temp = info.get(i);
			String data = String.format("%s/%d/%d/%d/%d/%s/%d\n", temp.name, temp.level, temp.maxhp, temp.power, temp.def, temp.party, temp.code);
			result += data;
			if(temp.weapon == null)
				result += temp.weapon + "/";
			else {
				Item item = temp.weapon;
				String weaponData = String.format("%d,%s,%d,%d/", item.getKind(), item.getName(), item.getPower(), item.getPrice());
				result += weaponData;
			}
			
			if(temp.armor == null)
				result += temp.armor + "/";
			else {
				Item item = temp.armor;
				String armorData = String.format("%d,%s,%d,%d/", item.getKind(), item.getName(), item.getPower(), item.getPrice());
				result += armorData;
			}
			
			if(temp.ring == null)
				result += temp.ring + "/";
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
		
		if(Player.getItemSize() == 0)
			return data;
		
		for(int i = 0; i < Player.getItemSize(); i++) {
			Item item = Player.getItemList().get(i);
			String itemData = String.format("%d/%s/%d/%d\n", item.getKind(), item.getName(), item.getPower(), item.getPrice());
			data += itemData;
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	public void loadData() {
		if(file.exists()) {
			try {
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				
				String money = br.readLine();
				Player.money = Integer.parseInt(money);
				
				String guildSize = br.readLine();
				int size = Integer.parseInt(guildSize);
				Player.guild.getGuildList().clear();
				
				loadDataGuild(size, br);
				
				
				
				fr.close();
				br.close();
				System.out.println("파일 로드 성공");
			} catch (Exception e) {
				System.out.println("파일 로드 실패");
				e.printStackTrace();
			}
		}
	}
	
	private void loadDataGuild(int size, BufferedReader br) throws IOException {
		for(int i = 0; i < size; i++) {
			String unitData = br.readLine();
			String[] unitInfo = unitData.split("/");
			loadDataGuildUnit(unitInfo);
			
			Player target = Player.getGuildList().get(i);
			String itemData = br.readLine();
			String[] itemInfo = itemData.split("/");
			loadDataGuildItem(itemInfo, target);
		}
		
		String invenSize = br.readLine();
		System.out.println("invenSize : " + invenSize);
		int inSize = Integer.parseInt(invenSize);
		
		if(inSize == 0)
			return;
		
		Player.inven.getItemList().clear();
		for(int i = 0; i < inSize; i++) {
			String invenData = br.readLine();
			loadDataInventory(inSize, invenData);
		}
	}
	
	private void loadDataGuildUnit(String[] info) {
		String name = info[0];
		int level = Integer.parseInt(info[1]);
		int maxhp = Integer.parseInt(info[2]);
		int power = Integer.parseInt(info[3]);
		int def = Integer.parseInt(info[4]);
		boolean party = Boolean.parseBoolean(info[5]);
		int code = Integer.parseInt(info[6]);
		

		
		if(code == 1)
			Player.getGuildList().add(new Warrior(name, level, maxhp, power, def, party, code));
		else if(code == 2)
			Player.getGuildList().add(new Wizard(name, level, maxhp, power, def, party, code));
		else if(code == 3)
			Player.getGuildList().add(new Healer(name, level, maxhp, power, def, party, code));
		
	}
	
	private void loadDataGuildItem(String[] info, Player target) {
		if(info[0].equals("null"))
			target.weapon = null;
		else {
			String[] weapon = info[0].split(",");
			int kind = Integer.parseInt(weapon[0]);
			String name = weapon[1];
			int power = Integer.parseInt(weapon[2]);
			int price = Integer.parseInt(weapon[3]);
			Item item = new Item();
			item.setItem(kind, name, power, price);
			target.weapon = item;
		}
		
		if(info[1].equals("null"))
			target.armor = null;
		else {
			String[] armor = info[1].split(",");
			int kind = Integer.parseInt(armor[0]);
			String name = armor[1];
			int power = Integer.parseInt(armor[2]);
			int price = Integer.parseInt(armor[3]);
			Item item = new Item();
			item.setItem(kind, name, power, price);
			target.armor = item;
		}
		
		if(info[2].equals("null"))
			target.ring = null;
		else {
			String[] ring = info[2].split(",");
			int kind = Integer.parseInt(ring[0]);
			String name = ring[1];
			int power = Integer.parseInt(ring[2]);
			int price = Integer.parseInt(ring[3]);
			Item item = new Item();
			item.setItem(kind, name, power, price);
			target.ring = item;
		}
	}
	
	private void loadDataInventory(int size, String data) {
		String[] info = data.split("/");
		int kind = Integer.parseInt(info[0]);
		String name = info[1];
		int power = Integer.parseInt(info[2]);
		int price = Integer.parseInt(info[3]);
		
		Item item = new Item();
		item.setItem(kind, name, power, price);
		Player.inven.getItemList().add(item);
	}
}
