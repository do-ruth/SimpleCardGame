public class Card {

    private String rank = ""; // 2,3,4,....,Q,K,A
    private String suit = ""; // S:spades, C:clubs, D:diamonds, H:hearts
    private int value = 0;  // 1,2,3,....,13
    private int suitVal = 0; // 1,2,3,4

    public Card(String r, String s){
        this.rank = r;
        this.suit = s;
        this.setValue();
        this.setSuitValue();
    }

    private void setValue(){
        if(Character.isDigit(this.rank.charAt(0))){ //2,3,4,....,9,10
            this.value = Integer.parseInt(this.rank);
        }
        else {
            switch(this.rank.toLowerCase()){
                case "ace":
                    this.value = 14;
                    break;
                case "king":
                    this.value = 13;
                    break;
                case "queen":
                    this.value = 12;
                    break;
                case "jack":
                    this.value = 11;
                    break;
            }
        }
    }

    private void setSuitValue(){
        switch(this.suit.toLowerCase()){
            case "hearts":
                this.suitVal = 4;
                break;
            case "diamonds":
                this.suitVal = 3;
                break;
            case "clubs":
                this.suitVal = 2;
                break;
            case "spades":
                this.suitVal = 1;
                break;
        }
    }

    public int getValue(){
        return this.value;
    }

    public String getRank(){
        return this.rank;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getSuitVal(){
        return this.suitVal;
    }

    public boolean compare(Card thisCard, Card anotherCard){
        if(thisCard.getValue()>anotherCard.getValue()){
            return true;
        }
        else if (thisCard.getValue()==anotherCard.getValue()){
            if(thisCard.getSuitVal()>anotherCard.getSuitVal()){
                return true;
            }
        }
        return false;
    }
}
