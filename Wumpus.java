public class Wumpus extends GameItem {
	
	
	private static final char WUMPUS = 'W';

	
	public Wumpus (){
		
		super(WUMPUS);

	}
	
	public void senseWumpus(){
		System.out.println("You smelled something terrible and heard something say 'Lunch is about to be served'");
	}
	
}
