import java.util.ArrayList;
import java.util.List;

public class Cherrybomb extends Plant implements SplashAttacker{
	private int turnCount;

	public Cherrybomb(){
		super(10, 150, 150);
		turnCount = 2;
	}
	public void splashAttack(List<Zombie> school){		
		if(turnCount != 0)
			turnCount--;
		else{
			for(Zombie s: school){
				if(s instanceof Zombie)
					s.takeDamage(super.getDamage());
			}
			super.takeDamage(super.getDamage());
		}		
	} 
}