import java.util.ArrayList;
public class Player {
    private String name;
    private int score;
    private ArrayList <Card> hand = new ArrayList<>();
    private int[] money = new int[]{2,4,1,0,0,0};
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    public void selectionSort() {
        for (int i = 0; i < hand.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(j).getValue() < hand.get(index).getValue()) {
                    index = j;//searching for lowest index
                }
            }
            Card smallerNumber = hand.get(index);
            hand.set(index, hand.get(i));
            hand.set(i, hand.get(index));
        }
    }
    public ArrayList<Card> getHand(){
        return hand;
    }
    public void printHand(){
        selectionSort();
        for(int i=0;i<hand.size();i++){
            int n = 1;
            for(int j=i+1;j<hand.size();j++)if(hand.get(j) == hand.get(i))n++;
            System.out.printf("%s: %d\n",hand.get(i),n);
        }
    }
    public boolean has(int card){
        for (Card value : hand) {
            if (value.getValue() == card) {
                return true;
            }
        }
        return false;
    }
    public void buyCard(Card card) {
        this.hand.add(card);
    }
    public int hasMoney(int mon){
        for(int i:money){
            if(mon == i)return i;
        }
        return -1;
    }
    public void addCard(Card card){
        if(card != null)hand.add(card);
    }
    public void addMoney(int valueIdx, int quantity){
        if(valueIdx > 5 || valueIdx < 0 || quantity < 0 || quantity > 20){
            throw new IllegalArgumentException();
        }
        money[valueIdx] += quantity;
    }
    public void removeMoney(int valueIdx, int quantity){
        if(valueIdx > 6 || valueIdx < 0 || quantity < 0 || quantity > 20){
            throw new IllegalArgumentException();
        }
        money[valueIdx] -= quantity;
    }
    public int[] getMoney(){
        return money;
    }
    public int getTotal() {
        int total = 0;
        for (int i = 1; i < money.length; i++) {
            total += money[i] * denominationValue(i);
        }
        return total;
    }
    private int denominationValue(int index) {
        return switch (index) {
            case 0 -> 0;
            case 1 -> 10;
            case 2 -> 50;
            case 3 -> 100;
            case 4 -> 200;
            case 5 -> 500;
            default -> throw new IllegalArgumentException("Invalid denomination index");
        };
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}