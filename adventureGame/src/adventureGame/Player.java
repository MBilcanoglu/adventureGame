package adventureGame;

import java.util.Scanner;

public class Player {
	private int damage;
	private int health;
	private int originHealth;
	private int money;
	private String name;
	private String charName;
	private Inventory inventory;

	private Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	public void selectChar() {
		GameChar[] listCharacter = { new Samurai(), new Archer(), new Knight() };
		System.out.println("Karakterler:");
		System.out.println("--------------------------------------------------------------------");
		for (GameChar gameChar : listCharacter) {
			System.out.println("ID: " + gameChar.getId() + "\t Karakter: " + gameChar.getName() + "\t Hasar:"
					+ gameChar.getDamage() + "\t Saðlýk:" + gameChar.getHealth() + "\t Bakiye:" + gameChar.getMoney());
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.print("Lütfen bir karakter giriniz: ");
		int selectCharacter = scan.nextInt();

		switch (selectCharacter) {
		case 1:
			initPlayer(new Samurai());
			break;
		case 2:
			initPlayer(new Archer());
			break;
		case 3:
			initPlayer(new Knight());
			break;
		default:
			initPlayer(new Samurai());
			break;
		}

	}

	public void initPlayer(GameChar gameChar) {
		this.setCharName(gameChar.getName());
		this.setDamage(gameChar.getDamage());
		this.setHealth(gameChar.getHealth());
		this.setOriginHealth(gameChar.getHealth());
		this.setMoney(gameChar.getMoney());
	}

	public void printInfo() {
		System.out.println();
		System.out.println("Silahýnýz: " + this.getInventory().getWeapon().getWeaponName() + ", Zýrhýnýz: "
				+ this.getInventory().getArmor().getArmorName() + ", Bloklama: "
				+ this.getInventory().getArmor().getBlock() + ", Hasar: " + this.getTotalDamage() + ", Saðlýk: "
				+ this.getHealth() + ", Bakiye:" + this.getMoney());
	}

	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getOriginHealth() {
		return originHealth;
	}

	public void setOriginHealth(int originHealth) {
		this.originHealth = originHealth;
	}
}
