import java.util.Random;

public class Wumpus extends GameItem {
	//wumpus

    Random RCor = new Random();
	int row = RCor.nextInt(4);
	Random CCor = new Random();
	int column = CCor.nextInt(4);

    	
    	public boolean SetWumpus(int row, int column){
    		//wrow = row;
    		//wcolumn = column;
    		
            setItem('w', row, column);
    	
    	return true;
    }
    	

    	
	
}
