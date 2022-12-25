package adventureGame;

public class Weapon {
	private String weaponName;
	private int id;
	private int damage;
	private int price;

	public Weapon(String weaponName, int id, int damage, int price) {
		super();
		this.weaponName = weaponName;
		this.id = id;
		this.damage = damage;
		this.price = price;
	}

	public static Weapon[] weapons() {
		Weapon[] weapons = new Weapon[3];
		weapons[0] = new Weapon("Tabanca", 1, 2, 15);
		weapons[1] = new Weapon("Kýlýç", 2, 3, 35);
		weapons[2] = new Weapon("Tüfek", 3, 7, 45);
		return weapons;
	}

	public static Weapon getweaponObjById(int id) {
		for (Weapon w : Weapon.weapons()) {
			if (w.getId() == id) {
				return w;
			}
		}
		return null;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
