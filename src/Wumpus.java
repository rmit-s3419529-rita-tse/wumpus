
public class Wumpus extends GameItem {
	char wumpus = 'w';
	
	
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
    	else
    		return false;
    
    }
}


