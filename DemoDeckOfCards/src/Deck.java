import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Cards> cards = new ArrayList<>();

    public Deck() {
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String value : values) {
            cards.add(new Cards(value, "Spades"));
            cards.add(new Cards(value, "Clubs"));
            cards.add(new Cards(value, "Diamonds"));
            cards.add(new Cards(value, "Hearts"));
        }
    }

    public void showDeck() {
        for (Cards card : this.cards) {
            card.showCard();
        }

    }
}
