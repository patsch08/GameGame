import java.security.InvalidParameterException;

public class Money {
    public static void main(String[] args) {

    }
    private int[] money = new int[]{2,4,0,1,0,0,0};
    public void addMoney(int valueIdx, int quantity){
        if(valueIdx > 6 || valueIdx < 0 || quantity < 0 || quantity > 20){
            throw new InvalidParameterException();
        }
        money[valueIdx] += quantity;
    }
    public void subtractMoney(int valueIdx, int quantity){
        if(valueIdx > 6 || valueIdx < 0 || quantity < 0 || quantity > 20){
            throw new InvalidParameterException();
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
            case 2 -> 20;
            case 3 -> 50;
            case 4 -> 100;
            case 5 -> 200;
            case 6 -> 500;
            default -> throw new InvalidParameterException("Invalid denomination index");
        };
    }
}