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
	//Player moves
    public boolean PlayerMove(char player, int row, int column)
    {
    	if (row >=0 && row <=3 && column >=0 && column <=3)
    	{
    	    if (gameBoard[row][column] != ' ')
    		    return false;
    	    else
    	    {
    		gameBoard[row][column] = player;
    		    return true;
    	     }
    }
    	else
    		return false;
    
    }
    

    
    //pit
    public boolean pitPost(char pit, int row, int column)
    {
    	if (row >=0 && row <=3 && column >=0 && column <=3)
    	{
    	    if (gameBoard[row][column] != ' ')
    		    return false;
    	    else
    	    {
    		gameBoard[row][column] = pit;
    		    return true;
    	     }
    }
    	else
    		return false;
    
    }
    

    //gold
    public boolean goldPost(char gold, int row, int column)
    {
    	if (row >=0 && row <=3 && column >=0 && column <=3)
    	{
    	    if (gameBoard[row][column] != ' ')
    		    return false;
    	    else
    	    {
    		gameBoard[row][column] = gold;
    		    return true;
    	     }
    }
    	else
    		return false;
    
    }
    
}
   	
    /*
     //constructor GameItem(char c)

    private String[][] board;
    public GameItem()
    {
    	//game item array
    	char gameitems [] = {g, p, w, d }


*/    



