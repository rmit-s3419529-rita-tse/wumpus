

public class Pit extends GameItem {
	
	
	private static final char PIT = 'P';
	
	public Pit (){
		
		super(PIT);
		
	}
	
	public void sensePit(){
		System.out.println("You felt a nice, cool, comforting breeze nearby");
	}
	

}
