public abstract class Character{
	private int hp;
	private int damage;

	public Character(int hp, int damage){
		this.hp = hp;
		this.damage = damage;
	}
	public void takeDamage(int damage){
		hp-=damage;
	}
	public void attack(Character defender){
		defender.takeDamage(damage);
	}
	public boolean isAlive(){
		if(hp<=0)
			return false;
		return true;
	}
	public int getDamage(){
		return damage;
	}
}