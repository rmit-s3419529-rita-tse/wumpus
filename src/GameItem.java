import java.util.*;


public class GameItem {
    
    //GameItem - Board
    protected char [][] gameBoard;
    
    public GameItem()
    {
    	gameBoard = new char [4][4];
    	
    	for (int row=0; row < gameBoard.length; row++)
    	{
    		Arrays.fill(gameBoard[row], ' ');
    	}
    
    }
    //board
    public void displayBoard()
    {
    	for (int row = 0; row <gameBoard.length; row++){
    		for (int column = 0; column < gameBoard[0].length; column++) {
    			System.out.print("\t"+gameBoard[row][column]);
    			if (column == 0 || column == 1 || column == 2)
    				System.out.print("|");
    		}
    		System.out.print("\n-----------------------------------\n");
    	}
    	System.out.print("\n \n");
}

    
	//set items on board
        public boolean setItem(char item, int row, int column)
        {
        	if (row >=0 && row <=3 && column >=0 && column <=3)
        	{
        	    if (gameBoard[row][column] != ' ')
        		    return false;
        	    else
        	    {
        		gameBoard[row][column] = item;
        		    return true;
        	     }
        }
        	else return false;
        
        }
        
        
     	//random--- make it forloop ??
        Random RCor = new Random();
     	int row = RCor.nextInt(4);
     	Random CCor = new Random();
     	int column = CCor.nextInt(4);



}
   	




