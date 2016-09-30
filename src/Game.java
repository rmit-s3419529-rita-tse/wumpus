import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public void runGame(){
		
	GameItem a = new GameItem();
	setBoard();

		
	}
	
	    private void setBoard(){
	    	
	    	/*for (int count = 0; count < 4; count= count+1) {
	            Random RCor = new Random();
	        	int row = RCor.nextInt(4);
	        	
	        	Random CCor = new Random();
	        	int column = CCor.nextInt(4);
	    	  */	          
	          
	          GameItem T = new GameItem();
	          Wumpus W = new Wumpus();
	          //Gold G = new Gold();
	          
	          T.setItem('w', W.row, W.column); //IT WORKs!!!!!!!!!!!
	          
	         


	          T.SetPit();
	          T.SetGold();

	          T.displayBoard();
	         //T.PlayerMove('*', row, column);
	         //T.pitPost('p', row, column);
	         //T.goldPost('g', row, column);
	    }

	    	
	    }
	    
	    
	    /*
	    private void display(){
	    	
	    }
	    
	    private void senseNearby(){
	    }
		
	    private void menu(){
	    	Scanner scan = new Scanner(System.in);
	    	System.out.println("Options: L for moving Left, R for moving Right, U for moving Up annd D for moving Down.");
	    }
	    
	    public void runGame(){
	    	displayBoard(); // or display();
	    	
	    }
	    


	}
*/
