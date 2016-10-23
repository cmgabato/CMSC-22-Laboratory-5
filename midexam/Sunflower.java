public class Sunflower extends Plant implements Producer{
	public Sunflower(){
		super(30, 0, 50);
	}
	public int produce(){
		return 100;
	}
}