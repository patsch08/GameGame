import java.util.*;
public class DoGame {
    public static void main(String[] args) {
        doGame(3);
    }
    private static Scanner scanner = new Scanner(System.in);
    private static int current = 1;
    private static Player[] players = new Player[3];
    private static Deck deck = new Deck();
    private static int[] action = new int[3];
    private static Card card = deck.draw();
    public static void doGame(int player){
        if(player > 0&&5 >= player){
            players = new Player[player];
        }
        else {
            System.out.println("Invalid Player Input players set to 3");
        }
        while(true){
            int decision = choice();
            if (decision == -1)continue;
            if(decision == 0){
                while(true){
                    int doA = doAuction();
                    if(doA == -1)continue;
                    else players[doA].addCard(card);
                    card = deck.draw();
                }
            }
        }
    }
    public static int doAuction(){
        ArrayList<Integer> exclude = new ArrayList<>();
        exclude.add(current-1);
        int highestBid = 0;
        int highestBidder= current-1;
        for(int i=0;true;i++){
            while(true) {
                if (exclude.contains(i)) {
                    i++;
                    if (i == players.length) {
                        i = 0;
                    }
                }
                else break;
            }
            System.out.println(card.animal + " " + card.value);
            System.out.printf("Player %d how much do you want to bid?\n",i);
            int bid = 0;
            while(true){
                System.out.println("> ");
                if (scanner.hasNextInt()){
                    bid = scanner.nextInt();
                    //checks if bid is 0 then excludes him from further bidding
                    if (bid == 0){
                        System.out.println("Youre out!");
                        exclude.add(i);
                    }
                    if(bid > highestBid){
                        System.out.println("You have the lead");
                        highestBidder = i;
                        highestBid = bid;
                    }
                    break;
                }
            }
            if(exclude.size() == players.length-1)break;
        }
        if(highestBid < players[highestBidder].getTotal()){
            int whole = 0;
            while(whole < 50){
                int has50 = players[highestBidder].hasMoney(3);
                if (has50 != -1){
                    players[highestBidder].removeMoney(3, 1);
                    break;
                }
                players[highestBidder].removeMoney(1,1);
                whole += 10;
            }
            return -1;
        }
        return highestBidder;
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
            action[0] = current;
            action[1] = input;
            return input;
        }
        return -1;
    }
    public static boolean doTrade(){
        System.out.println("Which animal do you want to trade?");
        return true;
    }
}