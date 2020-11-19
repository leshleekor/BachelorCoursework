// ID 2018042797 
// Name Seunghyeon Lee

public class SlidePuzzleBoard {
	
	private int size;
	private PuzzlePiece[][] board;
	private int empty_row;
	private int empty_col;
	
	public SlidePuzzleBoard(int s) {
		size = s;
		board = new PuzzlePiece[size][size];
		for(int num = 1; num != size * size; num++) {
			PuzzlePiece p = new PuzzlePiece(num);
			int row = num / size;
			int col = num % size;
			board[size-1-row][size-1-col] = p;
		}
		empty_row = 3;
		empty_col = 3;
	}
	
	public boolean move(int w) {
		final int NOT_FOUND = -1;
		int row = NOT_FOUND;
		int col = NOT_FOUND;
		if(found(w, empty_row-1, empty_col)) {
			row = empty_row-1;
			col = empty_col;
		}
		else if(found(w, empty_row+1, empty_col)) {
			row = empty_row+1;
			col=empty_col;
		}
		else if(found(w, empty_row, empty_col-1)) {
			row = empty_row;
			col=empty_col-1;
		}
		else if(found(w, empty_row, empty_col+1)) {
			row = empty_row;
			col=empty_col+1;
		}
		if(row != NOT_FOUND) {
			board[empty_row][empty_col] = board[row][col];
			empty_row = row;
			empty_col = col;
			board[empty_row][empty_col] = null;
		}
		return row != NOT_FOUND;
	}
	
	public boolean found(int v, int row, int col) {
		if(row < 0 || col < 0) return false;
		if(row > 3 || col > 3) return false;
		return board[row][col].valueOf() == v;

 	}
	
	public PuzzlePiece[][] contents(){
		return board;
	}
}
