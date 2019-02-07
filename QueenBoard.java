public class QueenBoard{

private int[][] board;

public QueenBoard(int size){
	board = new int[size][size];
	for(int x = 0; x < size;x++){
		for (int y = 0; y < size; y++){
			System.out.print(board[x][y]);
			System.out.print(" ");
		}
		System.out.println();
	}
}


public static void main(String[] args) {
	QueenBoard q = new QueenBoard(8);
}


}
