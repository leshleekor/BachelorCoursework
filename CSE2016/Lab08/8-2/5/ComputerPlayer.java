public class ComputerPlayer extends CardPlayer {

    public ComputerPlayer(int max_cards) {
        super(max_cards);
    }
    /** wantsACard - 카드 한 장을 받겠는지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public boolean wantsACard() {
        String response = "";
        return response.equals("Y");
    }
}