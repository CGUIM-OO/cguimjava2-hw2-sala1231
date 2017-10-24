import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0344250 歐宜宣
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: 宣告i,x,y三個變數，i代表有幾副牌、x代表的是花色(共有四種)、y代表的則是點數(1-13)，
 * 用for迴圈可以從第一副的第一張牌取到最後一副的最後一張牌(從1-13、梅花到黑桃)，
 * 取出後再使用printCard將牌全數印出。 
 */

class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int i =0;i < nDeck; i++)
			{
				for(int x =1;x < 5;x++)
					{
						for(int y = 1;y<14;y++)
							{
								Card card = new Card (x,y);
								cards.add(card);
							}
					}
			}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		
		for (Card Pcard:cards)
		{
			Pcard.printCard(Pcard);
		}

			
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: 用if&else if去判斷花色(suit)跟點數(rank)，
 * 宣告PokerSuit&PokerRank為String，用來顯示花色及點數,並輸出。
 * (因為rank有部分要顯示數字，但PokerRank為String所以必須先將rank轉成String才能輸出)
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;	
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(Card card){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		String PokerSuit = null ;
		String PokerRank = null;
		Integer R = card.rank;
		if (card.suit == 1)
			{
				PokerSuit = "Clubs";
			}
		else if(card.suit==2)
			{
				PokerSuit = "Diamonds";
			}
		else if(card.suit==3)
			{
				PokerSuit = "Hearts";
			}
		else if(card.suit==4)
			{
				PokerSuit = "Spades";
			}
	
		if (card.rank == 1)
			{
				PokerRank = "Ace";
			}
		else if(card.rank == 11)
			{
				PokerRank ="Jack";
			}
		else if(card.rank == 12)
			{
				PokerRank ="Queen";
			}
		else if(card.rank == 13)
			{
				PokerRank ="King";
			}
		else
			{
				PokerRank = R.toString();
			}
	
		System.out.println(PokerSuit + PokerRank);
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
