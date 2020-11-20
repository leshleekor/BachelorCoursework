import javax.swing.JOptionPane;

public class HumanPlayer extends CardPlayer {

    public HumanPlayer(int max_cards) {
        super(max_cards);
    }
    /** wantsACard - 카드 한 장을 받겠는지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog("한 장 더 드릴까요?");
        return response.equals("Y");
    }
}