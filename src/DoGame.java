import java.util.*;
public class DoGame {
    private static Scanner scanner = new Scanner(System.in);
    private static int current = 0;
    private static Player[] players = new Player[3];
    private static Deck deck = new Deck();
    private static char[] action = new char[3];
    public static void doGame(int player){
        if(player > 0&&5 >= player){
            players = new Player[player];
        }
        else {
            System.out.println("Invalid Player Input players set to 3");
        }
    }
    public static int choice(){
        System.out.printf("Player %d what do you want to do?\n[0] Do you want to draw a card\n[Player with who you want to trade] Do you want to trade\n",current);
        int input;
        while(true){
            if (scanner.hasNextInt()){
                input = scanner.nextInt();
                if (input >= 0&& 5>= input){
                    break;
                }
            }
            System.out.println("Please enter a valid number 1 or 2");
            scanner.next();
        }
        if(input == 0 && !deck.isEmpty()){
            return 0;
        }
        else if(input != 0 && input != current){
            action[0] = (char)(current+48);
            action[1] = (char)(input+48);
            return input;
        }
        return -1;
    }
    public static boolean doTrade(){
        System.out.println("Which animal do you want to trade?");
        return true;
    }
    public static void main(String[] args) {
        choice();
    }
}