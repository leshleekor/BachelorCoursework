// ID 2018042797 
// Name Seunghyeon Lee

import javax.swing.JOptionPane;

public class PuzzleController {
	
	private SlidePuzzleBoard board;
	private PuzzleWriter writer;
	
	public PuzzleController(SlidePuzzleBoard b, PuzzleWriter w) {
		board = b;
		writer = w;
	}
	
	public void play() {
		while(true) {
			writer.displayBoard();
			int i = Integer.parseInt(JOptionPane.showInputDialog("퍼즐 조각 번호를 선택하세요."));
			if (!board.move(i))
				writer.printError("움직일 수 없는 퍼즐조각입니다.");  
		}
	}
}
