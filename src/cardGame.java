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

        //System.out.println("System Deck Suite: " + systemDeckSuiteString);

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

        //System.out.println("User Deck Suite: " + userDeckSuiteString);

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
        //System.out.println("System's Deck: " + systemDeckString);

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

        int systemDeckFullCounter = 0;
        while (systemDeckFullCounter < 10) {
            systemDeckFullString.add(systemDeckString.get(systemDeckFullCounter) + " " + systemDeckSuiteString.get(systemDeckFullCounter));
            systemDeckFullCounter++;
        }


        int userDeckFullCounter = 0;
        while (userDeckFullCounter < 10) {
            userDeckFullString.add(userDeckString.get(userDeckFullCounter) + " " + userDeckSuiteString.get(userDeckFullCounter));
            userDeckFullCounter++;
        }


        int systemPoints = 0;
        int userPoints = 0;

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

            if (systemDeck.get(pointCounter) == 1 || userDeck.get(pointCounter) == 1) {
                if (userDeck.get(pointCounter) == 1 && systemDeck.get(pointCounter) == 1) {
                    if (systemDeckSuiteInt.get(pointCounter) < userDeckSuiteInt.get(pointCounter)) {
                        userPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("You win one point!");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                    else if (systemDeckSuiteInt.get(pointCounter) == userDeckSuiteInt.get(pointCounter)) {
                        systemPoints++;
                        userPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("It's a tie. Both get a point.");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                    else {
                        systemPoints++;
                        System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                        System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                        System.out.println("System wins one point");
                        System.out.println("System's points: " + systemPoints);
                        System.out.println(name + "'s points: " + userPoints);
                    }
                }
                else if (userDeck.get(pointCounter) != 1 && systemDeck.get(pointCounter) == 1){
                    systemPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("System wins one point");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
                else if (userDeck.get(pointCounter) == 1 && systemDeck.get(pointCounter) != 1) {
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("You win one point!");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
            }
            else if (systemDeck.get(pointCounter) < userDeck.get(pointCounter)) {
                userPoints++;
                System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                System.out.println("You win one point!");
                System.out.println("System's points: " + systemPoints);
                System.out.println(name + "'s points: " + userPoints);
            }
            else if (systemDeck.get(pointCounter) == userDeck.get(pointCounter)) {
                if (systemDeckSuiteInt.get(pointCounter) < userDeckSuiteInt.get(pointCounter)) {
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("You win one point!");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
                // here, if there is a tie with the number and the suit then both sides get a point
                else if (systemDeckSuiteInt.get(pointCounter) == userDeckSuiteInt.get(pointCounter)){
                    systemPoints++;
                    userPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("It's a tie. Both get a point.");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);

                }
                else {
                    systemPoints++;
                    System.out.println("System's Card: " + systemDeckFullString.get(pointCounter));
                    System.out.println(name + "'s Card: " + userDeckFullString.get(pointCounter));
                    System.out.println("System wins one point");
                    System.out.println("System's points: " + systemPoints);
                    System.out.println(name + "'s points: " + userPoints);
                }
            }
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

        //int systemDeckCounter = 1;
        //while (systemDeckCounter < 11) {
        //    if (systemDeck.get(systemDeckCounter) == 1) {
        //
        //    }
        //    systemDeckCounter++;
        //}

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
