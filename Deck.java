import java.util.Random;

public class Deck {
    private Card[] myCards; // an array of Card objects representing the cards in the deck
    private int numCards; // the current number of cards in the deck

    public Deck() {  // default constructor creates a single deck of cards and doesn't shuffle them
        this(1, false);
    }

    public Deck(int numDecks, boolean shuffle) {  // constructor that creates a specified number of decks and can shuffle them
        this.numCards = numDecks * 52;  // calculate the total number of cards in the deck
        this.myCards = new Card[this.numCards];  // initialize the deck with the correct number of Card objects
        int c = 0;  // index counter for adding cards to the deck

        for (int d = 0; d < numDecks; d++) {  // loop through each deck
            for (Suit s : Suit.values()) {  // loop through each suit
                for (int n = 1; n <= 13; n++) {  // loop through each card value
                    this.myCards[c] = new Card(s, n);  // add a new Card object to the deck
                    c++;  // increment the index counter
                }
            }
        }
        if (shuffle) {  // shuffle the deck if the shuffle parameter is true
            this.shuffle();
        }
    }

    public void shuffle() {  // randomly shuffle the deck
        Random rng = new Random();
        for (int i = this.numCards - 1; i > 0; i--) {  // iterate through the deck in reverse order
            int j = rng.nextInt(i + 1);  // generate a random index within the remaining cards
            Card temp = this.myCards[i];  // temporarily store the current card
            this.myCards[i] = this.myCards[j];  // swap the current card with the randomly selected card
            this.myCards[j] = temp;
        }
    }

    public Card dealNextCard() {  // remove and return the top card from the deck
        Card top = this.myCards[this.numCards - 1];  // get the top card
        this.myCards[this.numCards - 1] = null;  // remove the top card from the deck
        this.numCards--;  // decrement the number of cards in the deck
        return top;  // return the top card
    }

    public void printDeck(int numtoPrint) {  // print the top cards in the deck
        for (int c = 0; c < numtoPrint; c++) {  // iterate through the top cards in the deck
            System.out.printf("%3d/%d %s\n", c + 1, this.numCards, this.myCards[this.numCards - numtoPrint + c].toString());  // print the card number, the total number of cards, and the card object
        }
        System.out.printf("\t[%d other]\n", this.numCards - numtoPrint);  // print the number of remaining cards in the deck
    }
}