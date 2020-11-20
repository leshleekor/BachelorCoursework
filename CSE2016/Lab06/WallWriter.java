// CSE2016 - Lab#6

import java.awt.*;

public class WallWriter {
  private Wall wall;
  private Color wallColor;

  public WallWriter(Wall w, Color c) {
    wall = w;
    wallColor = c;
  }

  public void paintComponent(Graphics g) {
    g.setColor(Color.green);
    g.fillRect(wall.getStartX(), wall.getStartY(), wall.getEndX()-wall.getStartX(), wall.getEndY()-wall.getStartY());
    g.setColor(Color.black);
    g.drawRect(wall.getStartX(), wall.getStartY(), wall.getEndX()-wall.getStartX(), wall.getEndY()-wall.getStartY());
  }
}