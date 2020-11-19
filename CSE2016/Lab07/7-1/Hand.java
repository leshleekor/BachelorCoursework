// CSE2016
// ID: 2018042797
// Name: Seunghyeon Lee

public class Hand {
  private Card[] hand;
  private int number_of_cards;

  public Hand(int how_many) {
    hand = new Card[how_many];
  }

  public void showHand() {
    if(number_of_cards == 0) {
      System.out.println("들고있는 카드가 없습니다.");
    }
    else {
      Card card;
      for(int i=0; i<number_of_cards; i++) {
        card = hand[i];
        System.out.println(card.getSuit() + " " + card.getRank());
      }
    }
  }

  /* 카드를 한 장 받는다. 한도(배열 hand의 크기)를 초과하면 받을 수 없다.
   * @param c - 카드
   * @return 성공적으로 받았으면 true, 그렇지 않으면 false */
  public boolean receiveCard(Card c) {
    if(number_of_cards < hand.length) {
      hand[number_of_cards] = c;
      number_of_cards += 1;
      return true;
    } else {
      return false;
    }
  }

  /* 들고 있는 카드 중 하나를 버림. 여기서는 무작위 선택
   * @return 선택한 카드, 손에 들고 있는 카드가 없으면 null */
  public Card removeCard() {
    if(number_of_cards > 0) {
      int picked = (int)(Math.random() * number_of_cards);
      Card card_to_remove = hand[picked];
      if(number_of_cards -1 > picked) {
        for(int i=picked+1; i<number_of_cards; i++) {
          hand[i-1] = hand[i];
        }
      } 
      number_of_cards -= 1;
      return card_to_remove;
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    Hand h = new Hand(2);
    CardDeck d = new CardDeck();
    Card c1 = d.newCard();
    h.receiveCard(c1);
    Card c2 = d.newCard();
    h.receiveCard(c2);
    Card c3 = d.newCard();
    h.showHand();
    h.receiveCard(c3);
    h.showHand();
    h.removeCard();
    h.showHand();
  }
}