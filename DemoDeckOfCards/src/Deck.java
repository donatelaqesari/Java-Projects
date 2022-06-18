import java.util.ArrayList;
import java.util.Collections;

public class Deck {
        private ArrayList<Integer> cards = new ArrayList<>();

        public Deck() {

        }

        public void getNames (Integer cards){
            for (int i = 1; i <= 13; i++) {
                this.cards.add(i);
                System.out.println(i);
            }
        }

}
