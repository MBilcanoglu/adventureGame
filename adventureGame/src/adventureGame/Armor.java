package adventureGame;

public class Armor {

	private int id;
	private String armorName;
	private int block;
	private int price;

	public Armor(int id, String armorName, int block, int price) {
		super();
		this.id = id;
		this.armorName = armorName;
		this.block = block;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArmorName() {
		return armorName;
	}

	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static Armor[] armors() {
		Armor[] armors = new Armor[3];
		armors[0] = new Armor(1, "Hafif", 1, 15);
		armors[1] = new Armor(2, "Orta", 3, 25);
		armors[2] = new Armor(3, "Aðýr", 5, 40);
		return armors;
	}

	public static Armor getArmorObjById(int id) {
		for (Armor armor : Armor.armors()) {
			if (armor.getId() == id) {
				return armor;
			}
		}
		return null;
	}

}
