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

public boolean isZeroed(){
	for (int x = 0; x < size; x++) {
		for (int y = 0; y < size;y++) {
			if (board[x][y] != 0){
				return false;
			}
		}
	}
	return true;
}

public boolean solvehelp(int col){
	// if (!isZeroed()){
	// 	throw new IllegalStateException();
	// }
	if (col >= size){
		solutions++;
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
		System.out.println("HERE");
	}
	return solvehelp(0);
}

public int countSolutions(){
	if (!isZeroed()){
		System.out.println("HERE");
	}
	return counthelp(0);
}

public int counthelp(int col){
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

	return solutions;
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

public void debug(){
	System.out.println(Text.go(1,1));
	System.out.println(this);Text.wait(1); //adjust this delay
}


public static void main(String[] args) {
	double s = System.currentTimeMillis();
	QueenBoard q = new QueenBoard(8);
	System.out.println(q.isZeroed());
	int b = q.countSolutions();
	System.out.println(b);
	// System.out.println(q);
	// System.out.println((System.currentTimeMillis() - s) / 1000);


}


}
