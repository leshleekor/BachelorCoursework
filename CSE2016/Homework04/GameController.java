import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameController extends JPanel {
  private Player player1;
  private Player player2;

  /* GameConntroller - 플레이어 객체를 받고, 메인 창 관리
   * @param p1 - 플레이어1 객체
   * @param p2 - 플레이어2 객체
  */
  public GameController(Player p1, Player p2) {
    JButton jb = new JButton("게임 시작");
    player1 = p1;
    player2 = p2;
    
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("주사위 게임");
    ActionListener listener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        startGame();
      }
    };
    jb.addActionListener(listener);
		f.setSize(300, 200);
    f.add(jb);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT+22);
		g.setColor(Color.black);
		int text_margin = 50;
		int text_baseline = 50;
		g.drawString("Start Game", text_margin, text_baseline + 20);
	}

  /* startGame - 게임 시작 및 제어 */
  public void startGame() {
    int[] result1 = player1.throwDice();
    int[] result2 = player2.throwDice();
    System.out.println("User1 : " + result1[0] + " " + result1[1]);
    System.out.println("User2 : " + result2[0] + " " + result2[1]);
    if(result1[0] == result1[1] && result2[0] == result2[1]) {
      if(result1[0] > result2[0]) {
        player1.showResult(1);
        player2.showResult(0);
      } else if(result1[0] < result2[0]) {
        player1.showResult(0);
        player2.showResult(1);
      } else {
        player1.showResult(2);
        player2.showResult(2);
      }
    } else if(result1[0] == result1[1]) {
      player1.showResult(1);
      player2.showResult(0);
    } else if(result2[0] == result2[1]) {
      player1.showResult(0);
      player2.showResult(1);
    } else if((result1[0] + result1[1]) > (result2[0] + result2[1])) {
      player1.showResult(1);
      player2.showResult(0);
    } else if((result1[0] + result1[1]) < (result2[0] + result2[1])) {
      player1.showResult(0);
      player2.showResult(1);
    } else if((result1[0] + result1[1]) == (result2[0] + result2[1])) {
      if(Math.abs(result1[0] - result1[1]) > Math.abs(result2[0] - result2[1])) {
        player1.showResult(0);
        player2.showResult(1);
      } else if(Math.abs(result1[0] - result1[1]) < Math.abs(result2[0] - result2[1])) {
        player1.showResult(1);
        player2.showResult(0);
      } else {
        player1.showResult(2);
        player2.showResult(2);
      }
    }
  }
}