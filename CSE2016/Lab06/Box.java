// CSE2016 - Lab#6

/* 공이 돌아다니는 상자 */
public class Box {
  private int BOX_SIZE;

  public Box(int size) {
    BOX_SIZE = size;
  }
  /* inHorizontalContact - 공이 x축 방향으로 좌/우 벽에 도달여부를 리턴
   */
  public boolean inHorizontalContact(int x_position) {
    return (x_position <= 0 ) || (x_position >= BOX_SIZE);
  }

  /* inVerticalContact - 공이 y축 방향으로 좌/우 벽에 도달여부를 리턴
   */
  public boolean inVerticalContact(int y_position) {
    return (y_position <= 0) || (y_position >= BOX_SIZE);
  }

  /* sizeOf - 상자의 크기를 리턴 */
  public int sizeOf() {
    return BOX_SIZE;
  }
}