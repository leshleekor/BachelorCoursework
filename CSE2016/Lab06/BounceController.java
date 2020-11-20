// CSE2016 - Lab#6

public class BounceController {
  private AnimationWriter writer;
  private MovingBall ball1, ball2;

  public BounceController(MovingBall b1, MovingBall b2, AnimationWriter w) {
    ball1 = b1;
    ball2 = b2; 
    writer = w;
  }

  public void runAnimation() {
    int time_unit = 1;
    int painting_delay = 40;
    while(true) {
      delay(painting_delay);
      ball1.move(time_unit);
      ball2.move(time_unit);
      // System.out.println(ball.xPosition() + ", " + ball.yPosition());
      writer.repaint();
    }
  }

  private void delay(int how_long) {
    try { Thread.sleep(how_long); }
    catch(InterruptedException e) {}
  }
}