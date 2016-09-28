import java.util.*;

public class Gold extends GameItem {

	//random for amount of gold
	Random randomGenerator = new Random();
	int gold = randomGenerator.nextInt(2) +1;
	
	int i = 0;
	
	//random coordinates
	while (i < gold) {
		int column = randomGenerator.nextInt(3) + 0;
		int row = randomGenerator.nextInt(3) + 0;
		if (board[column][row] == null){
			board[column][row] = 'g';
			i++;
		}
		else{
			continue;
		}
	}
	
	//added statement for coordinates not overlap
	
}
