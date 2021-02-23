import java.util.*;

public class cardGame {
    public static void main (String[] args){

        Scanner mrScanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Hello, what is your name?");
        String name = "";
        name = mrScanner.nextLine();
        System.out.println("Hi, " + name + "! Welcome to a simple card game!");
        System.out.println("Whoever has the highest cards wins c:");

        ArrayList<Integer> systemDeck = new ArrayList<Integer>();
        ArrayList<Integer> userDeck = new ArrayList<Integer>();

        int counter = 1;
        while (counter < 11) {
            systemDeck.add(rand.nextInt(13) + 1);
            counter++;
        }
        System.out.println("System's Deck: " + systemDeck);

        int deckCounter = 1;
        while (deckCounter < 11) {
            userDeck.add(rand.nextInt(13) + 1);
            deckCounter++;
        }
        System.out.println(name + "'s Deck: " + userDeck);

        int systemPoints = 0;
        int userPoints = 0;

        int pointCounter = 0;
        while (pointCounter < 10) {
            if (systemDeck.get(pointCounter) < userDeck.get(pointCounter)) {
                userPoints++;
            }
            else if (systemDeck.get(pointCounter) == userDeck.get(pointCounter)) {
                int suite = rand.nextInt(1);
                if (suite == 1) {
                    userPoints++;
                }
                else {
                    systemPoints++;
                }
            }
            else {
                systemPoints++;
            }
            pointCounter++;
        }

        System.out.println("System's Points: " + systemPoints);
        System.out.println(name + "'s Points: " + userPoints);

        //int deckCounter = 1;
        //while (deckCounter < 11) {
        //    System.out.println(systemDeck.get(deckCounter - 1));
        //    deckCounter++;
        //}


    }

}
