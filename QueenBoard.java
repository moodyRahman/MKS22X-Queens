public class QueenBoard{

private int[][] board;
private int size;

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
			if (board[x][xt] != -1){
				board[x][xt]++;
			}
		}

		for(int xt = 0; xt < size; xt++){
			if (board[xt][y] != -1){
				board[xt][y]++;
			}
		}

		// for(){}
		return true;
	}

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
	q.placeQueen(5, 5);
	q.placeQueen(5, 6);
	q.placeQueen(6, 6);
	System.out.println();
	System.out.println(q.toString());
}


}
