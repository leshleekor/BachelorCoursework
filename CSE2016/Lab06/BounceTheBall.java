// CSE2016 - Lab#6
import java.awt.*;

public class BounceTheBall {
  public static void main(String[] args) {
    int box_size = 250;
    int balls_radius = 6;
    Box box = new Box(box_size);
    Wall wall = new Wall(60, 110, 180, 118);
    WallWriter wall_writer = new WallWriter(wall, Color.red);

    MovingBall ball1 = new MovingBall((int)(box_size / 3.0), (int)(box_size / 5.0), +3, +5, balls_radius, box, wall);
    MovingBall ball2 = new MovingBall((int)(box_size / 5.0), (int)(box_size / 3.0), +3, +2, balls_radius, box, wall);
    
    BallWriter ball_writer = new BallWriter(ball1, ball2, Color.red, Color.blue);
    BoxWriter box_writer = new BoxWriter(box);

    AnimationWriter animation_writer = new AnimationWriter(box_writer, ball_writer, wall_writer, box_size);

    new BounceController(ball1, ball2, animation_writer).runAnimation();
  }
}