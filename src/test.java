
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameItem a = new GameItem();
		
		a.displayBoard(); // empty board
		
		
		a.PlayerMove('*', 0, 0);
		//a.wumpusPost('w', 2, 1); //now in its class - how to access?
		a.pitPost('p', 3, 2);
		a.goldPost('g', 3, 3);
		a.displayBoard();
    /*
    int[] Ygold = {0, 1, 2, 3};
    int[] Xgold = {0, 1, 2, 3};
    
         */
	}

}
