import java.awt.*;
import javax.swing.*;

public class Player extends JPanel {

	private int WIDTH = 420;
	private int HEIGHT = 270;
  private int win;
  private int lose;
  private String name = "";
  private String message = "";
  private int[] num = new int[2];

  /* Player - 플레이어 별 창 관리 및 초기화 
   * @param n = 플레이어 이름
  */
  public Player(String n) {
    win = 0;
    lose = 0;
    name = n;

		JFrame f = new JFrame();

		f.getContentPane().add(this);
		f.setTitle(n);
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
  }

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT+22);
		g.setColor(Color.black);
		int text_margin = 20;
		int text_baseline = 40;
		g.drawString(message, text_margin, text_baseline);
		g.drawString("현재 승리 횟수 : " + win, text_margin, text_baseline + 20);
		g.drawString("현재 패배 횟수 : " + lose, text_margin, text_baseline + 40);
		g.drawString("[규칙]", text_margin, text_baseline + 70);
		g.drawString("주사위 두개가 같은 수가 나오면 이긴다. 둘 다 같은 수이면 큰 수가 이긴다.", text_margin, text_baseline + 90);
		g.drawString("다른 수 끼리는 두 주사위의 합이 크면 이긴다.", text_margin, text_baseline + 110);
		g.drawString("합이 동률인 경우에는 두 수의 차이가 작으면 이긴다.", text_margin, text_baseline + 130);
		g.drawString("두수의 차이도 동률이면 비긴다.", text_margin, text_baseline + 150);
	}
  
  /* showResult - 게임 결과 화면에 표시 */
  public void showResult(int isWin) {
    if(isWin == 1) {
      increaseWin();
      message = "내가 낸 주사위 : (" + num[0] + ", " + num[1] + ") 승리하였습니다!";
    } else if(isWin == 0) {
      increaseLose();
      message = "내가 낸 주사위 : (" + num[0] + ", " + num[1] + ") 패배하였습니다!";
    } else {
      message = "내가 낸 주사위 : (" + num[0] + ", " + num[1] + ") 무승부입니다!";
    }
		this.repaint();
  }

  public int[] throwDice() {
    Dice dice = new Dice();
    num[0] = dice.throwDice();
    num[1] = dice.throwDice();
    return num;
  }

  private void increaseWin() {
    win++;
  }

  private void increaseLose() {
    lose++;
  }

  public String getName() {
    return name;
  }
}