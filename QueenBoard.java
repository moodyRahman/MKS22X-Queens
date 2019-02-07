public class QueenBoard{

private int[][] board;
private int size;

public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < size;x++){
		for (int y = 0; y < size; y++){
			System.out.print(board[x][y]);
			System.out.print(" ");
		}
		System.out.println();
	}
	this.size = size;
}

public boolean placeQueen(int x, int y){
	board[x][y] = -1;
	return true;
}

public String toString(){
	String output = "";
	for(int x = 0; x < size;x++){
		for (int y = 0; y < size; y++){
			output += board[x][y];
			output += " ";
		}
		output += "\n";
	}
	return output;
}


public static void main(String[] args) {
	QueenBoard q = new QueenBoard(8);
	q.placeQueen(0, 0);
}


}
