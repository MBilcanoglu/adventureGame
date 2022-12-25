package adventureGame;

public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Güvenli Evdesiniz !");
		System.out.println("Canýnýz Yenilendi !");
		this.getPlayer().setHealth(this.getPlayer().getOriginHealth());
		return true;
	}

}
