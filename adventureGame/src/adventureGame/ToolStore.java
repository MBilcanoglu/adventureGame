package adventureGame;

public class ToolStore extends NormalLocation {

	public ToolStore(Player player) {
		super(player, "Maðaza");
	}

	@Override
	public boolean onLocation() {
		System.out.println("-----	Maðazaya Hoþgeldiniz !	-----");
		boolean showMenu = true;
		while (showMenu) {
			System.out.println("1 - Silahlar");
			System.out.println("2 - Zýrhlar");
			System.out.println("3 - Çýkýþ Yap");
			System.out.print("Seçiminiz: ");
			int selectCase = scan.nextInt();
			while (selectCase < 1 || selectCase > 3) {
				System.out.print("Geçersiz deðer, tekrar giriniz: ");
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
			System.out.println("ID: " + w.getId() + " Silah Türü: " + w.getWeaponName() + " Hasar: " + w.getDamage()
					+ " Tutar: " + w.getPrice());
		}
		System.out.println("0 - Çýkýþ Yap");
		System.out.println("--------------------------");

	}

	public void buyWeapon() {

		System.out.print("Bir Silah Seçiniz: ");
		int selectWeaponId = scan.nextInt();

		while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
			System.out.print("Geçersiz deðer, tekrar giriniz: ");
			selectWeaponId = scan.nextInt();
		}

		if (selectWeaponId != 0) {
			Weapon selectedWeapon = Weapon.getweaponObjById(selectWeaponId);

			if (selectedWeapon != null) {
				if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yeterli bakiye bulunmamaktadýr !");
				} else {
					/*
					 * Satýn alma gerçekleþtiði seneryo
					 */
					System.out.println(selectedWeapon.getWeaponName() + " Satýn Alýndý !");
					int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paranýz: " + this.getPlayer().getMoney());
					System.out.println(
							"Önceki Silahýnýz: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out
							.println("Yeni Silahýnýz: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
				}
			}
		}
	}

	public void printArmor() {
		System.out.println("----- Zýrhlar -----");
		System.out.println("--------------------------");
		for (Armor armor : Armor.armors()) {
			System.out.println("ID: " + armor.getId() + " Zýrh Türü: " + armor.getArmorName() + " Zýrh: "
					+ armor.getBlock() + " Tutar: " + armor.getPrice());
		}
		System.out.println("0 - Çýkýþ Yap");
		System.out.println("--------------------------");
	}

	public void buyArmor() {
		System.out.print("Bir Zýrh Seçiniz: ");
		int selectArmorId = scan.nextInt();

		while (selectArmorId < 0 || selectArmorId > Weapon.weapons().length) {
			System.out.print("Geçersiz deðer, tekrar giriniz: ");
			selectArmorId = scan.nextInt();
		}

		if (selectArmorId != 0) {
			Armor selectedArmor = Armor.getArmorObjById(selectArmorId);

			if (selectedArmor != null) {
				if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Yeterli bakiye bulunmamaktadýr !");
				} else {
					/*
					 * Satýn alma gerçekleþtiði seneryo
					 */
					System.out.println(selectedArmor.getArmorName() + " Satýn Alýndý !");
					int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan paranýz: " + this.getPlayer().getMoney());
					System.out.println("Önceki Zýrhýnýz: " + this.getPlayer().getInventory().getArmor().getArmorName());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.println("Yeni Silahýnýz: " + this.getPlayer().getInventory().getArmor().getArmorName());
				}
			}
		}
	}

}
