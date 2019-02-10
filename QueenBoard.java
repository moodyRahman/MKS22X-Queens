public class QueenBoard{

private int[][] board;
private int size;
private int solutions;

public QueenBoard(int size){
	board = new int[size][size];
	this.size = size;
}

public boolean placeQueen(int x, int y){
	if (board[x][y] == -1 || board[x][y] >= 1){
		return false;
	}
	else {
		board[x][y] = -1;
		for(int xt = 0; xt < size; xt++){
			if (board[xt][y] != -1){
				board[xt][y]++;
			}
			if (board[x][xt] != -1){
				board[x][xt]++;
			}
		}
		for (int xt = 0; xt < size; xt++){
			try {
				if (board[x + xt][y + xt] != -1){
					board[x + xt][y + xt]++;
				}
			} catch (Exception e){}

			try{
				if (board[x - xt][y + xt] != -1){
					board[x - xt][y + xt]++;
				}
			} catch (Exception e){}

			try{
				if (board[x + xt][y - xt] != -1){
					board[x + xt][y - xt]++;
				}
			} catch (Exception e){}

			try{
				if (board[x - xt][y - xt] != -1){
					board[x - xt][y - xt]++;
				}
			} catch (Exception e){}

		}
		return true;
	}

}

public boolean removeQueen(int x, int y){
	int rawx = x;
	int rawy = y;

	if (board[x][y] != -1){
		return false;
	}
	else{
		board[x][y] = 0;

		for(int xt = 0; xt < size; xt++){
			if (board[xt][y] != -1){
				board[xt][y]--;
			}
			if (board[x][xt] != -1){
				board[x][xt]--;
			}
		}
		for (int xt = 0; xt < size; xt++){
			try {
				if (board[x + xt][y + xt] != -1){
					board[x + xt][y + xt]--;
				}
			} catch (Exception e){}

			try{
				if (board[x - xt][y + xt] != -1){
					board[x - xt][y + xt]--;
				}
			} catch (Exception e){}

			try{
				if (board[x + xt][y - xt] != -1){
					board[x + xt][y - xt]--;
				}
			} catch (Exception e){}

			try{
				if (board[x - xt][y - xt] != -1){
					board[x - xt][y - xt]--;
				}
			} catch (Exception e){}

		}
		board[x][y] = 0;
		return true;
	}
}

public boolean solvehelp(int col){
	if (col >= size){
		return true;
	}
	for (int x = 0; x < size; x++){
		placeQueen(x, col);
		if (solvehelp(col + 1)){
			return true;
		}
		board[x][col] = 0;
	}
	return false;
}

public boolean solve(){
	for (int x = 0; x < size; x++){
		for (int y = 0; y < size; y++){
			if (board[x][y] == 0){
				this.placeQueen(x, y);
			}
		}
	}
	return true;
}

public int countSpaces(){
	int output = 0;
	for (int x = 0; x < size; x++){
		for (int y = 0; y < size; y++){
			if (board[x][y] == 0){
				output++;
			}
		}
	}
	return output;
}

public boolean haySpaces(){
	if ((countSpaces()) > 0){
		return true;
	}
	return false;
}

public String toString(){
	String output = "";
	for(int x = 0; x < size;x++){
		for (int y = 0; y < size; y++){
			if (board[x][y] < 0){
				output += " ";
			}
			else{
				output += "  ";
			}
			output += board[x][y];
		}
		output += "\n";
	}
	return output;
}


public static void main(String[] args) {
	QueenBoard q = new QueenBoard(8);
	// q.placeQueen(4, 5);
	// q.placeQueen(2, 4);
	// // System.out.println(q);
	// q.placeQueen(1, 1);
	// // System.out.println(q);
	// q.placeQueen(0, 3);
	// // System.out.println(q);
	// q.removeQueen(1, 1);
	// System.out.println(q);
	// System.out.println();
	// System.out.println();
	// System.out.println();
	// q.placeQueen(4, 5);
	// q.placeQueen(2, 4);
	// q.placeQueen(0, 3);
	// System.out.println(q);
	q.solve();
	System.out.println(q);


}


}
