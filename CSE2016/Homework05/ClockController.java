public class ClockController {
  private ClockWriter writer;

  public ClockController() {
    writer = new ClockWriter();
    writer.updateTime();
  }

  public void runClock() {
    int time_unit = 1;
    int painting_delay = 40;
    while(true) {
      delay(painting_delay);
      writer.updateTime();
    }
  }

  private void delay(int how_long) {
    try { Thread.sleep(how_long); }
    catch(InterruptedException e) {}
  }

	public static void main(String[] args) {
    new ClockController().runClock();
	}
}
