import javax.swing.*;
import java.awt.*;

public class FlowerDrawer extends JPanel {
  private int width;
  private int height;
  private int xPosition;
  private int yPosition;
  private int flowerSize;
  private String color;

  public FlowerDrawer(int w, int h) {
    width = w;
    height = h;
    xPosition = width / 5;
    yPosition = height / 2;
    JFrame f = new JFrame();
    f.getContentPane().add(this);
    f.setTitle("FlowerDrawer");
    f.setSize(width, height+22);
    f.setVisible(true);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  /* paintComponent - 화가 메소드
  * @param g - 그래픽스 펜 */
  public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, width, width);
    drawFlower(g, 100, 100, 30, Color.yellow, Color.red);
    drawFlower(g, 400, 80, 20, Color.blue, Color.orange);
    drawFlower(g, 140, 260, 40, Color.cyan, Color.pink);
    drawFlower(g, 400, 230, 50, Color.white, Color.yellow);
  }

  public void drawFlower(Graphics g, int x, int y, int r, Color c1, Color c2) {
    drawPetal(g, x-(2*r/2), y-(2*r/2), r*3, 50, c2);
    g.setColor(c1);
    g.fillOval(x, y, r, r);
  }

  private void drawPetal(Graphics g, int x, int y, int r, int angle, Color color) {
    g.setColor(color);
    g.fillArc(x, y, r, r, 0, angle);
    g.fillArc(x, y, r, r, 72, angle);
    g.fillArc(x, y, r, r, 144, angle);
    g.fillArc(x, y, r, r, 216, angle);
    g.fillArc(x, y, r, r, 288, angle);
  }
}