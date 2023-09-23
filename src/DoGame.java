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
    public static void doGame(int playerCount) {
        // Initialize the game with the specified number of players
        if (playerCount < 1 || playerCount > 5) {
            System.out.println("Invalid number of players. Setting players to 3.");
            playerCount = 3;
        }
        players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        boolean gameRunning = true;

        while (gameRunning) {
            int decision = choice();
            if (decision == -1) {
                continue;
            }
            if (decision == 0) {
                while (true) {
                    int doA = doAuction();
                    if (doA == -1) {
                        continue;
                    } else {
                        players[doA].addCard(card);
                        card = deck.draw();
                    }
                }
            }
            if(deck.isEmpty())gameRunning = false;
        }
    }

    public static int doAuction() {
        ArrayList<Integer> exclude = new ArrayList<>();
        exclude.add(current - 1);
        int highestBid = 0;
        int highestBidder = current - 1;

        for (int i = 0; exclude.size() < players.length - 1; i++) {
            if (exclude.contains(i)) {
                i++;
                if (i >= players.length) {
                    i = 0;
                }
            }
            if (i >= players.length) {
                i = 0;
            }
            if (exclude.contains(i)) {
                continue;
            }

            System.out.println(card.animal + " " + card.value);
            System.out.printf("Player %d how much do you want to bid? (0 to exit)\n", i + 1);
            int bid = 0;
            boolean playerExited = false; // Flag to track if the player exits

            while (true) {
                System.out.print("> ");
                if (scanner.hasNextInt()) {
                    bid = scanner.nextInt();
                    if (bid == 0) {
                        System.out.println("Player " + (i + 1) + " is out of the auction!");
                        exclude.add(i);
                        playerExited = true; // Set the flag to indicate player exit
                        break;
                    }
                    if (bid > highestBid) {
                        System.out.printf("Player %d has the lead\n",i+1);
                        highestBidder = i;
                        highestBid = bid;
                    }
                    break;
                } else {
                    scanner.next();
                }
            }

            if (exclude.size() == players.length - 1 || playerExited) {
                break; // Exit the loop when a player exits or when all players are excluded
            }
        }

        if (highestBid < players[highestBidder].getTotal()) {
            int whole = 0;
            while (whole < 50) {
                int has50 = players[highestBidder].hasMoney(3);
                if (has50 != -1) {
                    players[highestBidder].removeMoney(3, 1);
                    break;
                }
                players[highestBidder].removeMoney(1, 1);
                whole += 10;
            }
            return -1;
        }
        System.out.printf("Player %d has won the auction!\n He now has a %s",highestBidder,card.getAnimal());
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

    

}