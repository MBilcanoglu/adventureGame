package adventureGame;

public class ToolStore extends NormalLocation {

	public ToolStore(Player player) {
		super(player, "Ma�aza");
	}

	@Override
	public boolean onLocation() {
		System.out.println("-----	Ma�azaya Ho�geldiniz !	-----");
		boolean showMenu = true;
		while (showMenu) {
			System.out.println("1 - Silahlar");
			System.out.println("2 - Z�rhlar");
			System.out.println("3 - ��k�� Yap");
			System.out.print("Se�iminiz: ");
			int selectCase = scan.nextInt();
			while (selectCase < 1 || selectCase > 3) {
				System.out.print("Ge�ersiz de�er, tekrar giriniz: ");
				selectCase = scan.nextInt();
			}
			switch (selectCase) {
			case 1:
				printWeapon();
				buyWeapon();
				break;
			case 2:
				printArmor();
				buyArmor();
				break;
			case 3:
				System.out.println("Bir daha bekleriz :)");
				showMenu = false;
				break;
			}
		}
		return true;
	}

	public void printWeapon() {
		System.out.println("----- Silahlar -----");
		System.out.println("--------------------------");
		for (Weapon w : Weapon.weapons()) {
			System.out.println("ID: " + w.getId() + " Silah T�r�: " + w.getWeaponName() + " Hasar: " + w.getDamage()
					+ " Tutar: " + w.getPrice());
		}
		System.out.println("0 - ��k�� Yap");
		System.out.println("--------------------------");

	}

	public void buyWeapon() {

		System.out.print("Bir Silah Se�iniz: ");
		int selectWeaponId = scan.nextInt();

		while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
			System.out.print("Ge�ersiz de�er, tekrar giriniz: ");
			selectWeaponId = scan.nextInt();
		}

		if (selectWeaponId != 0) {
			Weapon selectedWeapon = Weapon.getweaponObjById(selectWeaponId);

			if (selectedWeapon != null) {
				if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yeterli bakiye bulunmamaktad�r !");
				} else {
					/*
					 * Sat�n alma ger�ekle�ti�i seneryo
					 */
					System.out.println(selectedWeapon.getWeaponName() + " Sat�n Al�nd� !");
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paran�z: " + this.getPlayer().getMoney());
					System.out.println(
							"�nceki Silah�n�z: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out
							.println("Yeni Silah�n�z: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
				}
			}
		}
	}

	public void printArmor() {
		System.out.println("----- Z�rhlar -----");
		System.out.println("--------------------------");
		for (Armor armor : Armor.armors()) {
			System.out.println("ID: " + armor.getId() + " Z�rh T�r�: " + armor.getArmorName() + " Z�rh: "
					+ armor.getBlock() + " Tutar: " + armor.getPrice());
		}
		System.out.println("0 - ��k�� Yap");
		System.out.println("--------------------------");
	}

	public void buyArmor() {
		System.out.print("Bir Z�rh Se�iniz: ");
		int selectArmorId = scan.nextInt();

		while (selectArmorId < 0 || selectArmorId > Weapon.weapons().length) {
			System.out.print("Ge�ersiz de�er, tekrar giriniz: ");
			selectArmorId = scan.nextInt();
		}

		if (selectArmorId != 0) {
			Armor selectedArmor = Armor.getArmorObjById(selectArmorId);

			if (selectedArmor != null) {
				if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yeterli bakiye bulunmamaktad�r !");
				} else {
					/*
					 * Sat�n alma ger�ekle�ti�i seneryo
					 */
					System.out.println(selectedArmor.getArmorName() + " Sat�n Al�nd� !");
					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paran�z: " + this.getPlayer().getMoney());
					System.out.println("�nceki Z�rh�n�z: " + this.getPlayer().getInventory().getArmor().getArmorName());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Yeni Silah�n�z: " + this.getPlayer().getInventory().getArmor().getArmorName());
				}
			}
		}
	}

}
