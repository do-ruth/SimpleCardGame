import java.util.*;

public class CardGame {
    public static void main (String[] args) {

        Scanner mrScanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Hello, what is your name?");
        String name = "";
        name = mrScanner.nextLine();
        System.out.println("Hi, " + name + "! Welcome to a simple card game!");
        System.out.println("Whoever has the highest cards wins c:");

        Boolean enterStart = false;
        while (enterStart != true) {

            System.out.println("Press the Enter Key to start the game.");
            String readString = mrScanner.nextLine();

            if (readString.isEmpty()) {
                System.out.println("Here we go!");
                System.out.println(" ");
                enterStart = true;
            } else {
            }
        }

        Deck deck = new Deck();
        System.out.println("New deck");
        deck.showAllCardsFaceUp();
        System.out.println("Size = ".concat(Integer.toString(deck.getSize())));

        deck.shuffle();
        System.out.println("Deck after shuffle");
        deck.showAllCardsFaceUp();
        System.out.println("Size = ".concat(Integer.toString(deck.getSize())));

        Hand systemHand = new Hand (10,deck).getHand();
        Deck remainedDeck = systemHand.getRemainedDeck();

        Hand playerHand = new Hand (10,remainedDeck).getHand();

        System.out.println("System");
        systemHand.showAllCardsFaceUp();
        System.out.println();
        System.out.println("Size = ".concat(Integer.toString(systemHand.getSize())));
        System.out.println("Player");
        playerHand.showAllCardsFaceUp();
        System.out.println();
        System.out.println("Size = ".concat(Integer.toString(playerHand.getSize())));

        int systemPoints = 0;
        int playerPoints = 0;

        int roundCounter = 0;
        while(roundCounter<10){
            System.out.println("Round ".concat(Integer.toString(roundCounter+1)));
            Card systemCard = systemHand.getCardAt(roundCounter);
            Card playerCard = playerHand.getCardAt(roundCounter);

            System.out.println("System's Card: " + systemCard.getRank().concat("-").concat(systemCard.getSuit()));
            System.out.println(name + "'s Card: " + playerCard.getRank().concat("-").concat(playerCard.getSuit()));

            if(playerCard.compare(playerCard,systemCard)){
                System.out.println("You won a point!");
                playerPoints++;
            }
            else{
                System.out.println("System won a point!");
                systemPoints++;
            }

            System.out.println("System's Points: ".concat(Integer.toString(systemPoints)));
            System.out.println(name + "'s Points: ".concat(Integer.toString(playerPoints)));

            roundCounter++;
        }

        //end message for game
        System.out.println(" ");
        System.out.println("The game is done. Here are all of the cards faced up.");
        System.out.println("System's Cards: ");
        systemHand.showAllCardsFaceUp();

        System.out.println("\n"+name + "'s Cards: ");
        playerHand.showAllCardsFaceUp();

        System.out.println("\nSystem's Points: " + systemPoints);
        System.out.println("\n"+name + "'s Points: " + playerPoints);

        System.out.println(" ");
        System.out.println("Result");
        int dots = 0;
        while (dots < 5) {
            System.out.println("...");
            dots++;
        }

        if (systemPoints > playerPoints) {
            System.out.println("Sorry, you lost. Try again!");
        }
        else if (systemPoints == playerPoints) {
            System.out.println("It's a tie.");
        }
        else {
            System.out.println("Congratulations! You won!");
        }

    }
}
