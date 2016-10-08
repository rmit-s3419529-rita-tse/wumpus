import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

public class Game {

	GameItem[][] board = new GameItem[4][4];

	private int playercol;
	private int playerrow;

	Random ran = new Random();
	ClearGround ground = new ClearGround();

	int goldno = ran.nextInt(3) + 1;

	int pickgold = 0;
	
	int warpupleft = 0;
	
	int warpdownright = 3;

	public void runGame() {

		setBoard();
		while (true) {
			display();
			senseNearby();
			menu();
		}

	}

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

	private void display() {

		// use to loop through game item array to display to board
		System.out.println("-------------");
		for (int i = 0; i < board.length; i++) {
			System.out.print("|");

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
			System.out.println("-------------");
		}
		System.out.println();
	}

	private void senseNearby() {
		int sensedown = playerrow + 1;
		int senseup = playerrow - 1;
		int senseleft = playercol - 1;
		int senseright = playercol + 1;

		if (sensedown > warpdownright) {
			sensedown = 0;
		}
		if (senseup < warpupleft) {
			senseup = 3;
		}
		if (senseleft < warpupleft) {
			senseleft = 3;
		}
		if (senseright > warpdownright) {
			senseright = 0;
		}

		/* TO SENSE NEARBY GOLD */
		if (board[senseup][playercol] instanceof Gold) {
			((Gold) board[senseup][playercol]).senseGold();
		}
		if (board[sensedown][playercol] instanceof Gold) {
			((Gold) board[sensedown][playercol]).senseGold();
		}
		if (board[playerrow][senseleft] instanceof Gold) {
			((Gold) board[playerrow][senseleft]).senseGold();
		}
		if (board[playerrow][senseright] instanceof Gold) {
			((Gold) board[playerrow][senseright]).senseGold();
		}
		
		/* TO SENSE NEARBY WUMPUS */
		if (board[senseup][playercol] instanceof Wumpus) {
			((Wumpus) board[senseup][playercol]).senseWumpus();
		}
		if (board[sensedown][playercol] instanceof Wumpus) {
			((Wumpus) board[sensedown][playercol]).senseWumpus();
		}
		if (board[playerrow][senseleft] instanceof Wumpus) {
			((Wumpus) board[playerrow][senseleft]).senseWumpus();
		}
		if (board[playerrow][senseright] instanceof Wumpus) {
			((Wumpus) board[playerrow][senseright]).senseWumpus();
		}
		
		/* TO SENSE NEARBY PITS */
		if (board[senseup][playercol] instanceof Pit) {
			((Pit) board[senseup][playercol]).sensePit();
		}
		if (board[sensedown][playercol] instanceof Pit) {
			((Pit) board[sensedown][playercol]).sensePit();
		}
		if (board[playerrow][senseleft] instanceof Pit) {
			((Pit) board[playerrow][senseleft]).sensePit();
		}
		if (board[playerrow][senseright] instanceof Pit) {
			((Pit) board[playerrow][senseright]).sensePit();
		} else {

		}

	}

	private void menu() {
		Scanner scan = new Scanner(System.in);
		int left = 1;
		int right =2;
		int up =3;
		int down = 4;
		int quit = 5;
		

		do {
			System.out.println();
			System.out.println("====== Wumpus Menu ======");
			System.out.println("Press <1> to move player left");
			System.out.println("Press <2> to move player right");
			System.out.println("Press <3> to move player up");
			System.out.println("Press <4> to move player down");
			System.out.println("Press <5> to quit the game");
			try {
				String s = scan.nextLine();
				int input = Integer.parseInt(s);
				if (input == left) {
					playercol--;
					if (playercol < warpupleft) {
						playercol = 3;
					}
					break;
				} else if (input == right) {
					playercol++;
					if (playercol > warpdownright) {
						playercol = 0;
					}
					break;
				} else if (input == up) {
					playerrow--;
					if (playerrow < warpupleft) {
						playerrow = 3;
					}
					break;
				} else if (input == down) {
					playerrow++;
					if (playerrow > warpdownright) {
						playerrow = 0;
					}
					break;
				} else if (input == quit) {
					System.out.println("Thanks for playing");
					System.exit(0);
					scan.close();
					break;
				} else {
					System.out.println("You need to choose a number between 1-5");
				}
			} catch (Exception e) {
				System.out.println("You need to choose a number between 1-5");
			}
		} while (true);

		if (board[playerrow][playercol] instanceof Gold) {
			System.out.println("You have found gold.");
			board[playerrow][playercol] = ground;
			pickgold++;
			if (pickgold == goldno) {
				System.out.println("You have picked up all of the gold. You WIN!!!");
				System.exit(0);

			}
		} else if (board[playerrow][playercol] instanceof Wumpus) {
			System.out.println("You have been eaten by the Wumpus. You lose.");
			System.out.println("Game Over!");
			System.exit(0);
		} else if (board[playerrow][playercol] instanceof Pit) {
			System.out.println("You fell down into the pit. You lose.");
			System.out.println("Game Over!");
			System.exit(0);
		}

	}

}
