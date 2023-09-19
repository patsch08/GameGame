import java.util.ArrayList;
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
                shuffle();
        }
    }
    public void shuffle() {
        for(int i = 0; i < 1000; i++) {
            int random = (int)(Math.random() * 40);
            Card temp = deck.get(0);
            deck.set(0, deck.get(random));
            deck.set(random, temp);
        }
    }
    public boolean isEmpty(){
        return deck.size() == 0;
    }
    public Card draw() {
        Card temp = deck.get(0);
        deck.remove(0);
        return temp;
    }
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        for(int i = 0; i < 40; i++) {
            System.out.println(deck.deck.get(i).getAnimal());
        }
    }
}
