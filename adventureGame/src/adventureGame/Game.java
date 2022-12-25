package adventureGame;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("Macera oyununa ho�geldiniz!");
		System.out.print("L�tfen bir isim giriniz: ");
		String playerName = scan.nextLine();
		Player player = new Player(playerName);
		System.out.print("Say�n " + player.getName() + " Ho�geldiniz.");
		System.out.println("Burada ya�ananlar�n hepsi ger�ek!!!");
		System.out.println("L�tfen bir karakter se�iniz:");
		player.selectChar();

		Location location = null;
		while (true) {
			player.printInfo();
			System.out.println();
			System.out.println("#######B�lgeler#######");
			System.out.println();
			System.out.println("1- G�venli Ev --> Buras� sizin i�in g�venli bir ev, d��man yok !");
			System.out.println("2- E�ya D�kkan� --> Silah veya Z�rh sat�n alabilirsiniz !");
			System.out.println("3- Ma�ara --> �d�l: <Yemek>, dikkatli ol Zombi ��kabilir !");
			System.out.println("4- Orman --> �d�l: <Odun>, dikkatli ol Vampir ��kabilir !");
			System.out.println("5- Nehir --> �d�l: <Su>, dikkatli ol Ay� ��kabilir !");
			System.out.println("0- ��k�� Yap!");
			if (player.getInventory().getPrize().length != 2) {
				System.out.println(
						"TEBR�KLER Ma�ara, Orman, Nehir B�LGELER�N� TAMALADINIZ VE BU B�LGELER� ARTIK SE�EMEZS�N�Z !!!");
			}
			System.out.print("L�tfen gitmek istedi�iniz b�lgeyi se�iniz: ");
			int selectLoc = scan.nextInt();
			switch (selectLoc) {
			case 0:
				location = null;
				break;
			case 1:
				System.out.println("*************** TEBR�KLER OYUNU KAZANDINIZ ***************");
				location = new SafeHouse(player);
				break;
			case 2:
				location = new ToolStore(player);
				break;
			case 3:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Yemek")) {
					System.out.println("Bu b�lgeyi tamamlad�n�z l�tfen yeni b�lge se�iniz");
					break;
				}
				location = new Cave(player);
				break;
			case 4:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Odun")) {
					System.out.println("Bu b�lgeyi tamamlad�n�z l�tfen yeni b�lge se�iniz");
					break;
				}
				location = new Forest(player);
				break;
			case 5:
				if (Arrays.asList(player.getInventory().getPrize()).contains("Su")) {
					System.out.println("Bu b�lgeyi tamamlad�n�z l�tfen yeni b�lge se�iniz");
					break;
				}
				location = new River(player);
				break;
			case 6:
				location = new Quarry(player);
				break;
			default:
				System.out.println("L�tfen ge�erli bir b�lge se�iniz!!!");
				break;
			}

			if (location == null) {
				System.out.println("Bu karanl�k ve sisli adadan �abuk vazge�tiniz :D");
				break;
			}

			if (!location.onLocation()) {
				System.out.println("GAME OVER");
				break;
			}
		}

	}
}
