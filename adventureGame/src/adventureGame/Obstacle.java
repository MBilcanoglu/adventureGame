package adventureGame;

public class Obstacle {
	private int id;
	private int damage;
	private int health;
	private String obstacleName;
	private int award;
	private int originHealth;

	public Obstacle(int id, int damage, int health, String obstacleName, int award) {
		super();
		this.id = id;
		this.damage = damage;
		this.health = health;
		this.obstacleName = obstacleName;
		this.originHealth = health;
		this.award = award;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getObstacleName() {
		return obstacleName;
	}

	public void setObstacleName(String obstacleName) {
		this.obstacleName = obstacleName;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getOriginHealth() {
		return originHealth;
	}

	public void setOriginHealth(int originHealth) {
		this.originHealth = originHealth;
	}

}
