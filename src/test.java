import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//random
	    Random RCor = new Random();
		int row = RCor.nextInt(4);
		
		Random CCor = new Random();
		int column = CCor.nextInt(4);
		
		System.out.println(column + "/"+ row);
		

		//
		GameItem a = new GameItem();
		Wumpus b = new Wumpus();
		
		
		a.displayBoard(); // empty board
		
		
		//fill boards
		a.PlayerMove('*', 0, 0);
		b.wumpusSet();
		a.pitPost('p', row, column); //only executes once when initiatized
		a.goldPost('g', 2, 2);
		a.displayBoard();
		

		
    /*
    int[] Ygold = {0, 1, 2, 3};
    int[] Xgold = {0, 1, 2, 3};
    
         */
	}
		
	}

