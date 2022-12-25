package adventureGame;

import java.util.Random;

public class Sneake extends Obstacle {
	private static Random randomDamage = new Random();
	private static String[] ihtimallar = { "Silah", "Tüfek", "Kýlýç", "Tabanca", "Zýrh", "Aðýr Zýrh", "Orta Zýrh",
			"Hafif Zýrh", "Para", "10 Para", "5 Para", "1 Para", "Boþ" };
	private static int[] ihtimalYuzdeleri = { 15, 20, 30, 50, 15, 20, 30, 50, 25, 20, 30, 50, 45 };
	private String price;

	public Sneake() {
		super(4, randomDamage.nextInt(2, 6), 12, "Yýlan", 0);
	}

	private static String randomPrice() {
		int toplam = 0;
		for (int yuzde : ihtimalYuzdeleri) {
			toplam += yuzde;
		}

		int rastgeleSayi = (int) (Math.random() * toplam);
		int acilis = 0;
		for (int i = 0; i < ihtimallar.length; i++) {
			acilis += ihtimalYuzdeleri[i];
			if (rastgeleSayi < acilis) {
				return ihtimallar[i];
			}
		}
		return "Boþ";
	}

	public String getPrice() {
		this.setPrice(randomPrice());
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
