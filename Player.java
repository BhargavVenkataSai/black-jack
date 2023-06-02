import java.util.ArrayList;

public class Player {

    // The player's name
    private String name;

    // The cards in the player's current hand
    private ArrayList<Card> hand;

    // The sum of the cards in the player's current hand.
    private int handSum;

    // Player Constructor
    public Player(String aName) {

        // Set the player's name
        this.name = aName;

        // Initialize the player's hand as an empty ArrayList
        this.hand = new ArrayList<>();

        // Set the initial hand sum to zero
        this.handSum = 0;
    }

    // Remove all the cards from the player's hand and reset the hand sum
    public void emptyHand() {
        this.hand.clear();
        this.handSum = 0;
    }

    // Add a card to the player's hand
    public boolean addCard(Card aCard) {
        if (this.hand.size() >= 10) {   // If the player already has 10 cards in their hand
            return false;               // The player cannot add another card
        }

        this.hand.add(aCard);           // Add the card to the player's hand
        this.handSum = getHandSum();    // Update the hand sum

        // Return true if the new hand sum is less than or equal to 21, false otherwise
        return (this.handSum <= 21);
    }

    // Calculate the sum of the cards in the player's hand
    public int getHandSum() {
        int handSum = 0;        // Initialize the hand sum to zero
        int numAces = 0;        // Initialize the number of aces in the hand to zero

        // Loop through each card in the player's hand
        for (Card card : this.hand) {
            int cardNum = card.getNumber();    // Get the number of the current card

            // If the card is an ace
            if (cardNum == 1) {
                numAces++;                      // Increment the number of aces in the hand
                handSum += 11;                  // Add 11 to the hand sum
            }
            // If the card is a face card (jack, queen, king)
            else if (cardNum >= 11 && cardNum <= 13) {
                handSum += 10;                  // Add 10 to the hand sum
            }
            // If the card is a numbered card (2-10)
            else {
                handSum += cardNum;             // Add the card's number to the hand sum
            }
        }

        // If the hand sum is greater than 21 and there are aces in the hand
        while (handSum > 21 && numAces > 0) {
            handSum -= 10;      // Subtract 10 from the hand sum
            numAces--;          // Decrement the number of aces in the hand
        }

        // Return the final hand sum
        return handSum;
    }

    // Print the cards in the player's hand
    public void printHand(boolean showFirstCard) {
        // Print the name of the player and indicate that their cards are being printed
        System.out.printf("%s's cards:\n", this.name);

        // Iterate over each card in the player's hand
        for (int c = 0; c < this.hand.size(); c++) {
            // If this is the first card and showFirstCard is false, print [hidden]
            if (c == 0 && !showFirstCard) {
                System.out.println("  [hidden]");
            }
            // Otherwise, print the card's string representation using its toString method
            else {
                System.out.printf("   %s\n", this.hand.get(c).toString());
            }
        }
    }
}