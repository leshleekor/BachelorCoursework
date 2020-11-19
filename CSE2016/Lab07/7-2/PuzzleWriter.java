// ID 2018042797 
// Name Seunghyeon Lee

import javax.swing.*;
import java.awt.*;

public class PuzzleWriter extends JPanel {
	private SlidePuzzleBoard board;
	private int size;
	private int piece_size = 30;
	private int panel_width;
	private int panel_height;
	
	public PuzzleWriter(SlidePuzzleBoard b, int s) {
		board = b;
		size = s;
		panel_width = piece_size * s + piece_size * 2;
		panel_height = piece_size * s + piece_size * 2;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Slide puzzle");
		f.setSize(panel_width, panel_height+22);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(0,  0, panel_width, panel_height);
		PuzzlePiece[][] b = board.contents();
		for(int i = 0; i != size; i++) {
			for(int j = 0; j != size; j++) {
				paintPiece(g, b[i][j], i, j);
			}
		}
	}
	
	private void paintPiece(Graphics g, PuzzlePiece p, int i, int j) {
		int x_pos = piece_size + (piece_size * j);
		int y_pos = piece_size + (piece_size * i);
		
		if(p != null) {
			g.setColor(Color.white);
			g.fillRect(x_pos, y_pos,  piece_size, piece_size);
			g.setColor(Color.black);
			g.drawRect(x_pos, y_pos, piece_size, piece_size);
			g.drawString(p.valueOf()+"", x_pos+10, y_pos+10);
		}
		else {
			g.setColor(Color.black);
			g.fillRect(x_pos, y_pos, piece_size, piece_size);
		}
	}
	
	public void displayBoard() {
		this.repaint();
	}
	public void printError(String s) {
		JOptionPane.showMessageDialog(null, "오류"+s);
		
	}
} 
