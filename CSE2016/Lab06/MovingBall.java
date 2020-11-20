// CSE2016 - Lab#6

public class MovingBall {
  private int x_pos;
  private int y_pos;
  private int radius;

  private int x_velocity = +5;
  private int y_velocity = +2;

  private Box container;
  private Wall wall;

  /* Constructor MovingBall - 공 만들기
   * @param x_initial - 공의 중심 x 좌표
   * @param y_initial - 공의 중심 y 좌표
   * @param r - 공의 반지름
   * @param box - 공이 살고 있는 상자
   */
  public MovingBall(int x_initial, int y_initial, int r, int x_vel_initial, int y_vel_initial, Box box, Wall w) {
    x_pos = x_initial;
    y_pos = y_initial;
    x_velocity = x_vel_initial;
    y_velocity = y_vel_initial;
    radius = r;
    container = box;
    wall = w;
  }
  /* xPosition - 공의 x축 위치 리턴 */
  public int xPosition() {
    return x_pos;
  }
  /* yPosition - 공의 y축 위치 리턴 */
  public int yPosition() {
    return y_pos;
  }
  /* radiusOf - 공의 반지름 리턴 */
  public int radiusOf() {
    return radius;
  }
  /* move - time unit 만큼 공을 이동, 벽에 부딪히면 방향을 바꿈
   * @param time_units - 프레임 사이의 시간 */
  public void move(int time_units) {
    x_pos = x_pos + x_velocity * time_units;
    y_pos = y_pos + y_velocity * time_units;
    if(container.inHorizontalContact(x_pos) || wall.inHorizontalContact2(x_pos, y_pos))
      x_velocity = - x_velocity;
    if(container.inVerticalContact(y_pos) || wall.inVerticalContact2(x_pos, y_pos))
      y_velocity = - y_velocity;
    if(wall.reflect(x_pos, y_pos))
      y_velocity = - y_velocity;
  }
}