// CSE2016 Lab#7-1

public class Card {
	
	public static final String SPADES = "spades";
	public static final String HEARTS = "hearts";
	public static final String DIAMONDS = "diamonds";
	public static final String CLUBS = "clubs";
	
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	public static final int SIZE_OF_ONE_SUIT = 13;
	
	private String suit;
	private int rank;

	/** Constructor - Card의 무의와 등급을 설정 
	 * @param s - 무늬 
	 * @param r - 등급  */
	public Card(String s, int r) { 
		suit = s;
		rank = r;
	}

	/** getSuit - 카드의 무늬 리턴 */ 
	public String getSuit() { 
		return suit; 
	}
	
	/** getCount - 카드의 등급 리턴 */ 
	public int getRank() { 
		return rank; 
	}
	
}
