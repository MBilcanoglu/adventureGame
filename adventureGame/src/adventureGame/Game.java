package adventureGame;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("Macera oyununa hoþgeldiniz!");
		System.out.print("Lütfen bir isim giriniz: ");
		String playerName = scan.nextLine();
		Player player = new Player(playerName);
		System.out.print("Sayýn " + player.getName() + " Hoþgeldiniz.");
		System.out.println("Burada yaþananlarýn hepsi gerçek!!!");
		System.out.println("Lütfen bir karakter seçiniz:");
		player.selectChar();

		Location location = null;
		while (true) {
			player.printInfo();
			System.out.println();
			System.out.println("#######Bölgeler#######");
			System.out.println();
			System.out.println("1- Güvenli Ev --> Burasý sizin için güvenli bir ev, düþman yok !");
			System.out.println("2- Eþya Dükkaný --> Silah veya Zýrh satýn alabilirsiniz !");
			System.out.println("3- Maðara --> Ödül: <Yemek>, dikkatli ol Zombi çýkabilir !");
			System.out.println("4- Orman --> Ödül: <Odun>, dikkatli ol Vampir çýkabilir !");
			System.out.println("5- Nehir --> Ödül: <Su>, dikkatli ol Ayý çýkabilir !");
			System.out.println("0- Çýkýþ Yap!");
			if (player.getInventory().getPrize().length != 2) {
				System.out.println(
						"TEBRÝKLER Maðara, Orman, Nehir BÖLGELERÝNÝ TAMALADINIZ VE BU BÖLGELERÝ ARTIK SEÇEMEZSÝNÝZ !!!");
			}
			System.out.print("Lütfen gitmek istediðiniz bölgeyi seçiniz: ");
			int selectLoc = scan.nextInt();
			switch (selectLoc) {
			case 0:
				location = null;
				break;
			case 1:
				System.out.println("*************** TEBRÝKLER OYUNU KAZANDINIZ ***************");
				location = new SafeHouse(player);
				break;
			case 2:
				location = new ToolStore(player);
				break;
			case 3:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Yemek")) {
					System.out.println("Bu bölgeyi tamamladýnýz lütfen yeni bölge seçiniz");
					break;
				}
				location = new Cave(player);
				break;
			case 4:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Odun")) {
					System.out.println("Bu bölgeyi tamamladýnýz lütfen yeni bölge seçiniz");
					break;
				}
				location = new Forest(player);
				break;
			case 5:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Su")) {
					System.out.println("Bu bölgeyi tamamladýnýz lütfen yeni bölge seçiniz");
					break;
				}
				location = new River(player);
				break;
			case 6:
				location = new Quarry(player);
				break;
			default:
				System.out.println("Lütfen geçerli bir bölge seçiniz!!!");
				break;
			}

			if (location == null) {
				System.out.println("Bu karanlýk ve sisli adadan çabuk vazgeçtiniz :D");
				break;
			}

			if (!location.onLocation()) {
				System.out.println("GAME OVER");
				break;
			}
		}

	}
}
