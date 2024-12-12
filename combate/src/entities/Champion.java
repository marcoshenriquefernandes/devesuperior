package entities;

public class Champion {	
	private String name;
	private int life;
	private int attack;
	private int armor;
	
	public Champion(String name, int life, int attack, int armor) {
		this.name = name;
		this.life = life;
		this.attack = attack;
		this.armor = armor;
	}
		
	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getArmor() {
		return armor;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void takeDamage(Champion champion) {
		if (this.getAttack() <= champion.getArmor())
			champion.setLife(champion.getLife() - 1);
		else
			champion.setLife(champion.getLife() - (this.getAttack() - champion.getArmor()));
	}
	
	public String status() {
		return (this.getLife() > 0) ? this.getName() + ": " + this.getLife() + " de vida" : this.getName() + ": 0 de vida (morreu)";
	}
}
