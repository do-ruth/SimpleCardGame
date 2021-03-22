import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
    private ArrayList<Card> deck = new ArrayList<Card>();

    /*
     * Constructor.
     * Loop through the two arrays to initialize 52 cards in a deck
     */
    public Deck(){

        for(int rank = 0; rank < ranks.length; rank++){
            for(int suit = 0; suit < suits.length; suit++){
                Card aCard = new Card(ranks[rank],suits[suit]);
                deck.add(aCard);
            }
        }
    }

    /*
     * Get a deck of card
     * @return ArrayList<Card>:	52 cards
     * @see	./Card.java
     */
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    /*
     * Show all cards in a deck
     * This method is for Testing purpose
     */
    public void showAllCardsFaceUp(){

        for(int card = 0; card < this.deck.size(); card++){

            System.out.print(" ".concat(this.deck.get(card).getRank().concat("-").concat(
                    this.deck.get(card).getSuit())));

            if((card + 1) % 13 == 0){
                System.out.println("");
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();
        int min = 1;
        int max = this.deck.size();
        ArrayList<Integer> rndVals = new ArrayList<Integer>();

        // fill the rndVals array list with randomized elements
        while(rndVals.size() < max){

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = rand.nextInt((max - min) + 1) + min;

            if(rndVals.indexOf(randomNum) == -1){

                rndVals.add(randomNum);
            }
        }

        ArrayList<Card> shuffledList = new ArrayList<Card>();

        // for each element in the rndVals array list
        // match it with element in the original this.cardList
        for(int rdvl = 0; rdvl < rndVals.size(); rdvl++){

            shuffledList.add(this.deck.get(rndVals.get(rdvl) - 1));

        }

        // swap the original list to the shuffled list
        this.deck.clear();
        this.deck.addAll(shuffledList);
    }

    public Card getCardAt(int position){
        return this.deck.get(position);
    }

    public void removeCardAt(int position){
        this.deck.remove(position);
    }

    public int getSize(){
        return this.deck.size();
    }
}
