package adventureGame;

import java.util.Random;

public abstract class BattleLoc extends Location {
	private Obstacle obstacle;
	private Sneake sneake;
	private String award;
	private int maxObstacle;

	BattleLoc(Player player, String locationName, Obstacle obstacle, String award, int maxObstacle) {
		super(player, locationName);
		this.obstacle = obstacle;
		this.award = award;
		this.maxObstacle = maxObstacle;
	}

	@Override
	public boolean onLocation() {
		int obstacleNumber = randomObstacleNumber();
		System.out.println("�uan Buradas�n�z: " + this.getLocationName());
		System.out.println(
				"Dikkatl� ol! Burada " + obstacleNumber + " tane " + this.obstacle.getObstacleName() + " ya��yor!");
		System.out.print("<S>ava� veya <K>a� : ");
		String selectCase = scan.nextLine();
		selectCase = selectCase.toUpperCase();
		if (selectCase.equals("S") && combat(obstacleNumber)) {
			System.out.println(this.getPlayer().getCharName() + " T�m d��manlar� yendiniz !");
			this.getPlayer().getInventory().setPrize(this.getAward());
			return true;
		}

		if (this.getPlayer().getHealth() <= 0) {
			System.out.println("�ld�n�z!!!");
			return false;
		}
		return true;
	}

	public boolean combat(int obstacleNumber) {
		boolean isFirst = true;
		for (int i = 1; i <= obstacleNumber; i++) {
			this.getObstacle().setHealth(this.getObstacle().getOriginHealth());
			playerStats();
			obstacleStats(i);
			while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
				System.out.print("<V>ur veya <K>a�: ");
				String selectCombat = scan.nextLine().toUpperCase();
				if (selectCombat.equals("V")) {
					if (isFirst) {
						firstMove();
						afterHit();
					}
					movePlayer();
					afterHit();
					moveObstacle();
				} else {
					return false;
				}
			}
			if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
				boolean money = true;
				System.out.println("Canavar� Yenidiniz");
				if (this.getObstacle().getObstacleName().equals("Y�lan")) {
					String price = this.getSneake().getPrice();
					System.out.println(price + " �d�l Kazand�n�z");
					if (price.contains("Para")) {
						if (price.contains("10")) {
							this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
						} else if (price.contains("5")) {
							this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
						} else if (price.contains("1")) {
							this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
						} else {
							this.getPlayer().setMoney(this.getPlayer().getMoney() + 15);
						}
						System.out.println("G�ncel Bakiyeniz: " + this.getPlayer().getMoney());
					} else {
						if (price.equals("Silah") || price.equals("Tabanca")) {
							this.getPlayer().getInventory().setWeapon(Weapon.getweaponObjById(1));
						} else if (price.equals("K�l��")) {
							this.getPlayer().getInventory().setWeapon(Weapon.getweaponObjById(2));
						} else if (price.equals("T�fek")) {
							this.getPlayer().getInventory().setWeapon(Weapon.getweaponObjById(3));
						} else if (price.equals("Z�rh") || price.equals("Hafif Z�rh")) {
							this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
						} else if (price.equals("Hafif Z�rh")) {
							this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
						} else if (price.equals("A��r Z�rh")) {
							this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
						} else {
							System.out.println("Herhangi bir �d�l kazanamad�n�z.");
						}

					}
				} else {
					System.out.println(this.getObstacle().getAward() + " �d�l Kazand�n�z");
					this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
					System.out.println("G�ncel Bakiyeniz: " + this.getPlayer().getMoney());
				}

			} else {
				return false;
			}
		}
		return true;
	}

	private void movePlayer() {
		System.out.println("Siz vurdunuz");
		int obstacleHealth = this.obstacle.getHealth() - this.getPlayer().getDamage();
		if (obstacleHealth < 0) {
			obstacleHealth = 0;
		}
		this.getObstacle().setHealth(obstacleHealth);
	}

	private void moveObstacle() {
		if (this.getObstacle().getHealth() > 0) {
			System.out.println();
			System.out.println("Canavar size vurdu");
			int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
			if (obstacleDamage < 0) {
				obstacleDamage = 0;
			}
			this.getPlayer().setDamage(this.getPlayer().getHealth() - obstacleDamage);
		}
	}

	private boolean firstMove() {
		Random randomMove = new Random();
		return randomMove.nextInt(100) <= 50 ? false : true;
	}

	public void afterHit() {
		System.out.println("Can�n�z: " + this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getObstacleName() + " Can�: " + this.getObstacle().getHealth());
		System.out.println();
	}

	public void playerStats() {
		System.out.println("Oyuncu De�erleri");
		System.out.println("------------------------------------------");
		System.out.println("Sa�l�k: " + this.getPlayer().getHealth());
		System.out.println("Hasar: " + this.getPlayer().getDamage());
		System.out.println("Para: " + this.getPlayer().getMoney());
		System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
		System.out.println("Z�rh: " + this.getPlayer().getInventory().getArmor().getArmorName());
		System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
		System.out.println("------------------------------------------");
	}

	public void obstacleStats(int obstacleNumber) {
		System.out.println(obstacleNumber + ". " + this.getObstacle().getObstacleName() + " De�erleri");
		System.out.println("------------------------------------------");
		System.out.println("Sa�l�k: " + this.getObstacle().getHealth());
		System.out.println("Hasar: " + this.getObstacle().getDamage());
		System.out.println("�d�l: " + this.getObstacle().getAward());
		System.out.println("------------------------------------------");
	}

	public int randomObstacleNumber() {
		Random random = new Random();
		return (random.nextInt(this.getMaxObstacle()) + 1);
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}

	public Sneake getSneake() {
		return sneake;
	}

}
