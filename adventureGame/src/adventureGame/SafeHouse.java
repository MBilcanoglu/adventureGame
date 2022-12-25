package adventureGame;

public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
	}

	@Override
	public boolean onLocation() {
		System.out.println("G�venli Evdesiniz !");
		System.out.println("Can�n�z Yenilendi !");
		this.getPlayer().setHealth(this.getPlayer().getOriginHealth());
		return true;
	}

}
