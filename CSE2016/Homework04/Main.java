public class Main {

  public static void main(String[] args) {
    Player player1 = new Player("User1");
    Player player2 = new Player("User2");
    GameController gc = new GameController(player1, player2);
  }
}