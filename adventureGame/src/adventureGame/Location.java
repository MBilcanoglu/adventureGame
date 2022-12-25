package adventureGame;

import java.util.Scanner;

public abstract class Location {

	protected static Scanner scan = new Scanner(System.in);

	private Player player;
	private String locationName;

	Location(Player player, String locationName) {
		this.player = player;
		this.locationName = locationName;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	abstract boolean onLocation();

}
