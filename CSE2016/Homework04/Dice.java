public class Dice {
  /* throwDice - 주사위 굴리기 */
  public int throwDice() {
    return ((int)(Math.random() * 100) % 6) + 1;
  }
}