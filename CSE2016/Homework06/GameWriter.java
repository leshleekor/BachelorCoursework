import java.awt.*;
import javax.swing.*;

public class GameWriter extends JPanel {
  private int width = 400;
  private int size;
  private boolean[][] arr;
  
  /* GameWriter
   * int s : 바둑판 가로세로 크기
   */
  public GameWriter(int s) {
    size = s;
    JFrame f = new JFrame();
    f.getContentPane().add(this);
		// 프레임 만들어 보여주기 
		f.setTitle("Life Game!");
		f.setSize(width,width+22);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void paintComponent(Graphics g) {
    int boxSize = width / size;
    g.setColor(Color.white);
    g.fillRect(0, 0, width, width);
    for(int i=0; i<size; i++) {
      for(int j=0; j<size; j++) {
        if(arr != null && arr[i][j] == true) {
          g.setColor(Color.black);
          g.fillRect(j*boxSize, i*boxSize, boxSize, boxSize);
        } else {
          g.setColor(Color.white);
          g.fillRect(j*boxSize, i*boxSize, boxSize, boxSize);
        }
        g.setColor(Color.gray);
        g.drawRect(j*boxSize, i*boxSize, boxSize, boxSize);
      }
    } 
  }

  public void updateScreen(boolean[][] r) {
    arr = r;
    this.repaint();
  }
}