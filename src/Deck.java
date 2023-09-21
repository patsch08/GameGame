import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList <Card> deck = new ArrayList<Card>();
    public Deck() {
        for(int i = 0; i < 4; i++) {
                deck.add(new Card(10));
                deck.add(new Card(40));
                deck.add(new Card(90));
                deck.add(new Card(160));
                deck.add(new Card(250));
                deck.add(new Card(350));
                deck.add(new Card(500));
                deck.add(new Card(650));
                deck.add(new Card(800));
                deck.add(new Card (1000));
        }
        shuffle();
    }
    public void shuffle() {
        Collections.shuffle(deck);
    }
    public boolean isEmpty(){
        return deck.isEmpty();
    }
    public Card draw() {
        Card temp = deck.get(0);
        deck.remove(0);
        return temp;
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
    }
}
