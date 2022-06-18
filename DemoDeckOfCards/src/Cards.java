import java.util.HashMap;

public class Cards {

    private String suit;
    private Integer rank;
    private String name;

    public Cards(String suit, Integer rank, String name){
        this.name = name;
        this.rank = rank;
        this.suit = suit;
    }

    public static void hashMap(){
    HashMap<Integer, String> map= new HashMap<Integer, String>();
    map.put( 1, "as");
    map.put( 11, "Jack");
    map.put( 12, "Queen");
    map.put( 13, "King");
    }


}
