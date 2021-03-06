public class QueenBoard{

private int[][] board;
private int size;
private int solutions;

public QueenBoard(int size){
	board = new int[size][size];
	this.size = size;
}

private boolean placeQueen(int x, int y){
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

private boolean removeQueen(int x, int y){
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

private boolean isZeroed(){
	for (int x = 0; x < size; x++) {
		for (int y = 0; y < size;y++) {
			if (board[x][y] != 0){
				return false;
			}
		}
	}
	return true;
}

private boolean solvehelp(int col){
	// if (!isZeroed()){
	// 	throw new IllegalStateException();
	// }
	if (col >= size){
		// solutions++;
		// System.out.println(this);
		// solvehelp(col);
		return true;
	}
	for (int x = 0; x < size; x++){
		if (placeQueen(x, col)){
			// debug();
			if (solvehelp(col + 1)){
				// debug();
				return true;
			}
			// debug();
			removeQueen(x, col);
		}
	}
	return false;
}

public boolean solve(){
	if (!isZeroed()){
		throw new IllegalStateException("Zero the board first");
	}
	return solvehelp(0);
}

public int countSolutions(){
	if (!isZeroed()){
		throw new IllegalStateException("Zero the board first");
	}
	return counthelp(0);
}

private int counthelp(int col){
	// int out = 0;
	if (col >= size){
		// debug();
		solutions++;
		return 1;
	}
	for (int x = 0; x < size; x++){
		if (placeQueen(x, col)){
			counthelp(col + 1);
			removeQueen(x, col);
		}
	}

	// return 0;

	return solutions;
}

public String toString(){
	String output = "";
	for(int x = 0; x < size;x++){
		for (int y = 0; y < size; y++){
			if (board[x][y] < 0){
				output += "Q ";
			}
			else{
				output += "_ ";
			}
		}
		output += "\n";
	}
	return output;
}

private void debug(){
	System.out.println(Text.go(1,1));
	System.out.println(this);Text.wait(1000); //adjust this delay
}


public static void main(String[] args) {
	double s = System.currentTimeMillis();

	QueenBoard q = new QueenBoard(2);
	// System.out.println(q.solve());
	System.out.println(q.countSolutions());

	System.out.println((System.currentTimeMillis() - s) / 1000);
}


}
