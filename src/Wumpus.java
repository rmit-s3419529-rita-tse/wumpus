import java.util.Random;

public class Wumpus extends GameItem {
	
	char wumpus = 'w';
	
    Random RCor = new Random();
	int row = RCor.nextInt(4);
	
	Random CCor = new Random();
	int column = CCor.nextInt(4);

	
	//wumpus
    public boolean wumpusPost(char wumpus, int row, int column)
    {
    	if (row >=0 && row <=3 && column >=0 && column <=3)
    	{
    	    if (gameBoard[row][column] != ' ')
    		    return false;
    	    else
    	    {
    		gameBoard[row][column] = wumpus;
    		    return true;
    	     }
    }
    	else return false;
    
    }
    
    
	public void wumpusSet(){
		wumpusPost('w', row, column);
	}
}

