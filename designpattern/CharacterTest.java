import java.util.*;

public class CharacterTest{
	public static void main(String[] args){
		Character k = new King();
		k.fight();
		Character q = new Queen();
		q.fight();
		Character n = new Knight();
		n.fight();
		Character t = new Troll();
		t.fight();

		System.out.println("----------------------------------------");

		Character k2 = new King(new SwordBehavior());
		k2.fight();
		Character q2 = new Queen(new AxeBehavior());
		q2.fight();
		Character n2 = new Knight(new BowAndArrowBehavior());
		n2.fight();
		Character t2 = new Troll(new KnifeBehavior());
		t2.fight();

		System.out.println("----------------------------------------");

		Character k3 = new King(new AxeBehavior());
		k3.fight();
		Character q3 = new Queen(new SwordBehavior());
		q3.fight();
		Character n3 = new Knight(new KnifeBehavior());
		n3.fight();
		Character t3 = new Troll(new BowAndArrowBehavior());
		t3.fight();

		System.out.println("----------------------------------------");

		Character k4 = new King(new BowAndArrowBehavior());
		k4.fight();
		Character q4 = new Queen(new KnifeBehavior());
		q4.fight();
		Character n4 = new Knight(new AxeBehavior());
		n4.fight();
		Character t4 = new Troll(new SwordBehavior());
		t4.fight();
	}	
}
