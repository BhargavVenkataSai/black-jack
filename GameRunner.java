import java.util.Scanner;

public class GameRunner {// Constants for minimum dealer hand sum and maximum hand sum
    private static final int MIN_DEALER_HAND_SUM = 17;
    private static final int MAX_HAND_SUM = 21;

    public static void main(String[] args) {

        // Create a new deck of cards
        Deck theDeck = new Deck(1, true);

        // Create a scanner object to read user input
        Scanner in = new Scanner(System.in);

        // ASCII art for the game
        String asciiArt = "__________ .__                    __         ____.                 __    \n"
                + "\\______   \\|  |  _____     ____  |  | __    |    |_____     ____  |  | __\n"
                + " |    |  _/|  |  \\__  \\  _/ ___\\ |  |/ /    |    |\\__  \\  _/ ___\\ |  |/ /\n"
                + " |    |   \\|  |__ / __ \\_\\  \\___ |    < /\\__|    | / __ \\_\\  \\___ |    < \n"
                + " |______  /|____/(____  / \\___  >|__|_ \\\\________|(____  / \\___  >|__|_ \\\n"
                + "        \\/            \\/      \\/      \\/               \\/      \\/      \\/\n";

        // Print the ASCII art for the game
        System.out.println(asciiArt);

        // Create the player and dealer objects
        System.out.println("\n\t\t\t\t\tWelcome to Blackjack!\n\n");
        System.out.println("Please enter your name:");
        String P_Name = in.nextLine();

        System.out.println(P_Name + ", let's start the game!\n");

        Player me = new Player(P_Name);
        Player dealer = new Player("Dealer");

        // Deal two cards to each player
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        // Print the initial hands of the player and dealer
        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println();

        // Keep playing until both players are done
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;
        try (Scanner sc = new Scanner(System.in)) {
            while (!meDone || !dealerDone) {
                // Ask the player if they want to hit or stay
                if (!meDone) {
                    System.out.print("These are your options: ");
                    System.out.println("\n\n1)Hit\n2)Stand\n");
                    ans = sc.next();
                    System.out.println();
                    if (ans.equalsIgnoreCase("1")) {
                        // Player chooses to hit
                        meDone = !me.addCard(theDeck.dealNextCard());
                        me.printHand(true);
                        dealer.printHand(false);
                    } else {
                        // Player chooses to stand
                        meDone = true;
                    }
                }
                // The dealer hits until their hand is at least 17
                else if (!dealerDone && dealer.getHandSum() < MIN_DEALER_HAND_SUM) {
                    // Dealer chooses to hit
                    System.out.println("The Dealer hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                } else {
                    // Dealer chooses to stand
                    dealerDone = true;
                }
                System.out.println();
            }

            // Print the final hands
            me.printHand(true);
            dealer.printHand(true);

            // Determine the winner based on hand sums
            int mySum = me.getHandSum();
            int dealerSum = dealer.getHandSum();
            if (mySum > dealerSum && mySum <= MAX_HAND_SUM || dealerSum > MAX_HAND_SUM) {
                System.out.println("You win!");
            } else {
                System.out.println("Dealer wins!");
            }
        }
    }
}
// The GameRunner class is the main class that runs the game of blackjack. It creates a new deck of cards,
// prompts the player for their name, deals two cards to both the player and dealer, and allows the player
// to hit or stand until they choose to stand or exceed a hand sum of 21. The dealer then hits until their
// hand sum is at least 17. The final hands are printed and the winner is determined based on the hand sums.




