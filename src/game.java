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

        Boolean enterStart = false;
        while (enterStart != true) {

            System.out.println("Press the Enter Key to start the game.");
            String readString = mrScanner.nextLine();

            if (readString.isEmpty()) {
                System.out.println("Here we go!");
                System.out.println(" ");
                enterStart = true;
            }
            else {
            }
        }

        ArrayList<Integer> systemDeck = new ArrayList<Integer>();
        ArrayList<Integer> userDeck = new ArrayList<Integer>();

        ArrayList<String> systemDeckString = (ArrayList)systemDeck.clone();
        ArrayList<String> userDeckString = (ArrayList)userDeck.clone();

        ArrayList<Integer> systemDeckSuiteInt = new ArrayList<Integer>();
        ArrayList<Integer> userDeckSuiteInt = new ArrayList<Integer>();

        ArrayList<String> systemDeckSuiteString = new ArrayList<String>();
        ArrayList<String> userDeckSuiteString = new ArrayList<String>();

        ArrayList<String> systemDeckFullString = new ArrayList<String>();
        ArrayList<String> userDeckFullString = new ArrayList<String>();

        //assigning suit
        int systemDeckSuiteCounter = 1;
        while (systemDeckSuiteCounter < 11) {
            int suiteValue = rand.nextInt(4) + 1;
            systemDeckSuiteInt.add(suiteValue);
            if (suiteValue == 1) {
                systemDeckSuiteString.add("Spades");
            }
            else if (suiteValue == 2) {
                systemDeckSuiteString.add("Clubs");
            }
            else if (suiteValue == 3) {
                systemDeckSuiteString.add("Diamonds");
            }
            else if (suiteValue == 4) {
                systemDeckSuiteString.add("Hearts");
            }
            systemDeckSuiteCounter++;
        }

        //assigning suit
        int userDeckSuiteCounter = 1;
        while (userDeckSuiteCounter < 11) {
            int suiteValue = rand.nextInt(4) + 1;
            userDeckSuiteInt.add(suiteValue);
            if (suiteValue == 1) {
                userDeckSuiteString.add("Spades");
            }
            else if (suiteValue == 2) {
                userDeckSuiteString.add("Clubs");
            }
            else if (suiteValue == 3) {
                userDeckSuiteString.add("Diamonds");
            }
            else if (suiteValue == 4) {
                userDeckSuiteString.add("Hearts");
            }
            userDeckSuiteCounter++;
        }

        //changing 11 to Jack, etc. and assigning card value
        int systemDeckCounter = 1;
        while (systemDeckCounter < 11) {
            int cardValue = rand.nextInt(13) + 1;
            systemDeck.add(cardValue);
            if (cardValue == 1) {
                systemDeckString.add("Ace");
            }
            else if (cardValue <= 10) {
                systemDeckString.add(String.valueOf(cardValue));
            }
            else if (cardValue == 11) {
                systemDeckString.add("Jack");
            }
            else if (cardValue == 12) {
                systemDeckString.add("Queen");
            }
            else if (cardValue == 13) {
                systemDeckString.add("King");
            }
            systemDeckCounter++;
        }

        //changing 11 to Jack, etc. and assigning card value
        int userDeckCounter = 1;
        while (userDeckCounter < 11) {
            int cardValue = rand.nextInt(13) + 1;
            userDeck.add(cardValue);
            if (cardValue == 1) {
                userDeckString.add("Ace");
            }
            else if (cardValue <= 10) {
                userDeckString.add(String.valueOf(cardValue));
            }
            else if (cardValue == 11) {
                userDeckString.add("Jack");
            }
            else if (cardValue == 12) {
                userDeckString.add("Queen");
            }
            else if (cardValue == 13) {
                userDeckString.add("King");
            }
            userDeckCounter++;
        }
        //System.out.println(name + "'s Deck: " + userDeckString);

        //making array of the deck number/face and suit for system
        int systemDeckFullCounter = 0;
        while (systemDeckFullCounter < 10) {
            systemDeckFullString.add(systemDeckString.get(systemDeckFullCounter) + " " + systemDeckSuiteString.get(systemDeckFullCounter));
            systemDeckFullCounter++;
        }

        //making array of the deck number/face and suit for user
        int userDeckFullCounter = 0;
        while (userDeckFullCounter < 10) {
            userDeckFullString.add(userDeckString.get(userDeckFullCounter) + " " + userDeckSuiteString.get(userDeckFullCounter));
            userDeckFullCounter++;
        }


        int systemPoints = 0;
        int userPoints = 0;

        //requiring enter key to be pressed to advance to next round
        int pointCounter = 0;
        while (pointCounter < 10) {

            Boolean enterPlay = false;
            while (enterPlay != true) {

                System.out.println("Press the Enter Key for next round.");
                String readString = mrScanner.nextLine();

                if (readString.isEmpty()) {
                    int roundNumber = pointCounter + 1;
                    System.out.println("Round " + roundNumber);
                    System.out.println(" ");
                    enterPlay = true;
                }
                else {
                }
            }

            //if system or user draw an ACE
            if (systemDeck.get(pointCounter) == 1 || userDeck.get(pointCounter) == 1) {
                //if both draw an ACE
                if (userDeck.get(pointCounter) == 1 && systemDeck.get(pointCounter) == 1) {
                    //check for system suit lower than user suit
                    if (systemDeckSuiteInt.get(pointCounter) < userDeckSuiteInt.get(pointCounter)) {
                        userPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("You win one point!");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                    //check if both suit the same
                    else if (systemDeckSuiteInt.get(pointCounter) == userDeckSuiteInt.get(pointCounter)) {
                        systemPoints++;
                        userPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("It's a tie. Both get a point.");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                    //otherwise, system suit is higher and gains a point
                    else {
                        systemPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("System wins one point");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                }
                //check if user didn't draw an ace, user loses round
                else if (userDeck.get(pointCounter) != 1 && systemDeck.get(pointCounter) == 1){
                    systemPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("System wins one point");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
                //check if system didn't draw an ACE, system loses round
                else if (userDeck.get(pointCounter) == 1 && systemDeck.get(pointCounter) != 1) {
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("You win one point!");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
            }
            //check if system card value is less than user card value
            else if (systemDeck.get(pointCounter) < userDeck.get(pointCounter)) {
                userPoints++;
                System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                System.out.println("You win one point!");
                System.out.println("System's points: " + systemPoints);
                System.out.println(name + "'s points: " + userPoints);
            }
            //check if both card values are equivalent
            else if (systemDeck.get(pointCounter) == userDeck.get(pointCounter)) {
                //checking suit of the cards
                if (systemDeckSuiteInt.get(pointCounter) < userDeckSuiteInt.get(pointCounter)) {
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("You win one point!");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
                // here, if there is a tie with the number and the suit then both sides get a point (cards are not mutually exclusive
                //i.e. the same card can be drawn for both sides
                else if (systemDeckSuiteInt.get(pointCounter) == userDeckSuiteInt.get(pointCounter)){
                    systemPoints++;
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("It's a tie. Both get a point.");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);

                }
                //if all "if" cases fail then the system wins round
                else {
                    systemPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("System wins one point");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
            }
            //if all "if" cases fail then the system wins round
            else {
                systemPoints++;
                System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                System.out.println("System wins one point");
                System.out.println("System's points: " + systemPoints);
                System.out.println(name + "'s points: " + userPoints);
            }
            pointCounter++;
        }

        //end message for game
        System.out.println(" ");
        System.out.println("The game is done. Here are all of the cards faced up.");
        System.out.println("System's Cards: " + systemDeckFullString);
        System.out.println(name + "'s Cards: " + userDeckFullString);

        System.out.println("System's Points: " + systemPoints);
        System.out.println(name + "'s Points: " + userPoints);

        System.out.println(" ");
        System.out.println("Result");
        int dots = 0;
        while (dots < 5) {
            System.out.println("...");
            dots++;
        }

        if (systemPoints > userPoints) {
            System.out.println("Sorry, you lost. Try again!");
        }
        else if (systemPoints == userPoints) {
            System.out.println("It's a tie.");
        }
        else {
            System.out.println("Congratulations! You won!");
        }




    }

}
