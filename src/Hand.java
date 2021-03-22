import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cardList = new ArrayList<Card>();
    private Deck remainedDeck;

    public Hand(int numCard, Deck deck){
        this.receiveCard(numCard,deck);
    }

    private void receiveCard(int numCard, Deck deck){
        int counter = 0;
        while (counter < numCard){
            Card c = deck.getCardAt(0);
            this.cardList.add(c);

            deck.removeCardAt(0);
            counter++;
        }
        this.remainedDeck = deck;
    }

    public Hand getHand(){
        return this;
    }

    public Deck getRemainedDeck(){
        return this.remainedDeck;
    }

    public void showAllCardsFaceUp(){

        for(int card = 0; card < this.cardList.size(); card++){

            System.out.print(" ".concat(this.cardList.get(card).getRank().concat("-").concat(
                    this.cardList.get(card).getSuit())));

            if((card + 1) % 13 == 0){
                System.out.println("");
            }
        }
    }

    public Card getCardAt(int position){
        return this.cardList.get(position);
    }

    public int getSize(){
        return this.cardList.size();
    }
}
