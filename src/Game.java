import java.util.Random;
import java.util.Scanner;

public class Game {

	GameItem[][] board = new GameItem[4][4];

	private int playercol;
	private int playerrow;

	Random ran = new Random();
	ClearGround ground = new ClearGround();

	private void setBoard() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ground;
			}
		}

		boolean empty = true;

		while (empty) {
			int col = ran.nextInt(4);
			int row = ran.nextInt(4);

			if (board[row][col] == ground) {
				board[row][col] = new Wumpus();
				empty = false;

			}

		}

		for (int i = 0; i < 3; i++) {
			empty = true;

			while (empty) {
				int col = ran.nextInt(4);
				int row = ran.nextInt(4);

				if (board[row][col] == ground) {
					board[row][col] = new Pit();
					empty = false;
				}

			}

		}

		int goldno = ran.nextInt(3) + 1;

		for (int i = 0; i < goldno; i++) {
			empty = true;
			while (empty) {

				int col = ran.nextInt(4);
				int row = ran.nextInt(4);

				if (board[row][col] == ground) {
					board[row][col] = new Gold();
					empty = false;

				}

			}

		}

		empty = true;
		while (empty) {
			int col = ran.nextInt(4);
			int row = ran.nextInt(4);

			if (board[row][col] == ground) {
				playercol = col;
				playerrow = row;
				empty = false;

			}

		}

	}

	private void senseNearby() {
		int addrow = playerrow + 1;
		int minusrow = playerrow - 1;
		int senseleft = playercol - 1;
		int senseright = playercol + 1;

		if (addrow > 3) {
			addrow = 0;
		}
		if (minusrow < 0) {
			minusrow = 3;
		}
		if (senseleft < 0) {
			senseleft = 3;
		}
		if (senseright > 3) {
			senseright = 0;
		}

		if (board[addrow][playercol] != ground || board[minusrow][playercol]!= ground
				|| board[playerrow][senseleft] != ground || board[playerrow][senseright] != ground) {
			System.out.println("senses tingling");
			
		
		} else
			System.out.println("nothing around");
	}

	
	
	private void menu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(
				"Options: 0 for moving Left, 1 for moving Right, 2 for movinng up  annd 3 for moving Down. 4 to Quit");
		
		int input=scan.nextInt();
	
		        switch (input) {
		        case 0:  
		                playercol--;
		            	if (playercol < 0) {playercol = 3;}
		                 break;
		                 
		        case 1:  
		        		playercol++; if (playercol > 3) {playercol = 0;}
		                 break;
		                 
		        case 2:  
		        	    playerrow--; if (playerrow < 0) {playerrow = 3;}
	                     break;
	                     
	            case 3:  playerrow++; if (playerrow > 3) {playerrow = 0;}
	                     break;
	                     
	            case 4:  System.out.println("Game Over!! HAHA");
			             System.exit(0);
			             scan.close();
                         break;
		        }

			if (board[playerrow][playercol] instanceof Gold){
				System.out.println("YAY YOU FOUND GOLD HAHA");
				board[playerrow][playercol] = ground;
			}
			else if (board[playerrow][playercol] instanceof Wumpus  || board[playerrow][playercol] instanceof Pit){
				System.out.println("LoL YOu DIED");
				System.out.println("Game over!!!");
				System.exit(0);
			}
			
		}
		
		
			

	// run game
	public void runGame() {
		
		setBoard();
		for(int i = 0 ; i<1000 ; i++){
		display();
		senseNearby();
		menu();
		}
		
	}

	private void display() {

		// use to loop through game item array to display to board
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {
				if (i == playerrow && j == playercol) {
					System.out.print('*');
				} else {
					System.out.print(" ");
				}

				board[i][j].Display();
				System.out.print("|");
			}
			System.out.println();
			System.out.println("------------");
		}

	}
}
