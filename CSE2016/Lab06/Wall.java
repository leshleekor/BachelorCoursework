// CSE2016 - Lab#6

public class Wall {
  private int START_X;
  private int START_Y;
  private int END_X;
  private int END_Y;

  public Wall(int sx, int sy, int ex, int ey) {
    START_X = sx;
    START_Y = sy;
    END_X = ex;
    END_Y = ey;
  }

  public int getStartX() {
    return START_X;
  }
  public int getStartY() {
    return START_Y;
  }
  public int getEndX() {
    return END_X;
  }
  public int getEndY() {
    return END_Y;
  }

  private boolean inHorizontalContact(int x_position) {
    return (x_position >= START_X) && (x_position <= END_X);
  }
  private boolean inVerticalContact(int y_position) {
    return (y_position >= START_Y) &&  (y_position <= END_Y);
  }
  public boolean inHorizontalContact2(int x_position, int y_position) {
    return (inVerticalContact(y_position) && x_position == START_X) || (inVerticalContact(y_position) && x_position == END_X);
  }
  public boolean inVerticalContact2(int x_position, int y_position) {
    return (inHorizontalContact(x_position) && y_position == START_Y) || (inHorizontalContact(x_position) && y_position == END_Y);
  }
  public boolean reflect(int x_position, int y_position) {
    return inHorizontalContact(x_position) && inVerticalContact(y_position);
  }
}