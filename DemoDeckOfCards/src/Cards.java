import java.util.HashMap;
import java.util.Map;

public class Cards {

    private String values;
    private String suit;
    public Integer rank; // 13 cards which means 13 integers

    //CONSTRUCTOR
    public Cards() {
    }

    public Cards(String values, String suit) {
        this.suit = suit;
        this.values = values;
    }

    public void showCard() {
        System.out.println(this.values + " of " + this.suit);
    }

    public void getValues() {
        HashMap<Integer, String> userMap = new HashMap<Integer, String>();
        userMap.put(1, "Ace");
        userMap.put(11, "Jack");
        userMap.put(12, "Queen");
        userMap.put(13, "King");
        for (String i : userMap.values()) {
            System.out.println(i + userMap.get(rank));
        }
    }


}
