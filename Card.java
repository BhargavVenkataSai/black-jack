import java.util.HashMap; // Importing the HashMap class from the java.util package
import java.util.Map; // Importing the Map interface from the java.util package

public class Card { // Declaring a public class named 'Card'
    private Suit mySuit; // Declaring a private instance variable 'mySuit' of the data type 'Suit'
    private int myNumber; // Declaring a private instance variable 'myNumber' of the data type 'int'

    public Card(Suit aSuit, int aNumber) { // Declaring a public constructor method named 'Card' with two parameters of data types 'Suit' and 'int'
        this.mySuit = aSuit; // Assigning the value of the parameter 'aSuit' to the instance variable 'mySuit'
        if (aNumber >= 1 && aNumber <= 13) { // Checking if the value of parameter 'aNumber' is between 1 and 13 (inclusive)
            this.myNumber = aNumber; // Assigning the value of the parameter 'aNumber' to the instance variable 'myNumber'
        } else { // If the value of parameter 'aNumber' is not between 1 and 13 (inclusive)
            System.out.println(aNumber + "is not a valid card Number"); // Printing an error message to the console
            System.exit(1); // Terminating the program with an error code
        }
        this.myNumber = aNumber; // Assigning the value of the parameter 'aNumber' to the instance variable 'myNumber'
    }

    public int getNumber() { // Declaring a public method named 'getNumber' which returns an integer value
        return myNumber; // Returning the value of the instance variable 'myNumber'
    }

    public String toString() { // Declaring a public method named 'toString' which returns a String value
        String numStr = "Error"; // Declaring and initializing a local variable 'numStr' with the value "Error"
        Map<Integer, String> numStringMap = new HashMap<>(); // Creating a new HashMap object with Integer keys and String values and assigning it to the variable 'numStringMap'
        numStringMap.put(1, "Ace"); // Adding a key-value pair (1, "Ace") to the 'numStringMap' object
        numStringMap.put(2, "Two"); // Adding a key-value pair (2, "Two") to the 'numStringMap' object
        numStringMap.put(3, "Three"); // Adding a key-value pair (3, "Three") to the 'numStringMap' object
        numStringMap.put(4, "Four"); // Adding a key-value pair (4, "Four") to the 'numStringMap' object
        numStringMap.put(5, "Five"); // Adding a key-value pair (5, "Five") to the 'numStringMap' object
        numStringMap.put(6, "Six"); // Adding a key-value pair (6, "Six") to the 'numStringMap' object
        numStringMap.put(7, "Seven"); // Adding a key-value pair (7, "Seven") to the 'numStringMap' object
        numStringMap.put(8, "Eight"); // Adding a key-value pair (8, "Eight") to the 'numStringMap' object
        numStringMap.put(9, "Nine"); // Adding a key-value pair (9, "Nine") to the 'numStringMap' object
        numStringMap.put(10, "Ten"); // Adding a key-value pair (10, "Ten") to the 'numStringMap' object
        numStringMap.put(11, "Jack"); // Adding a key-value pair (11, "Jack") to the 'numStringMap' object
        numStringMap.put(12, "Queen"); // Adding a key-value pair (12, "Queen") to the 'numStringMap' object
        numStringMap.put(13, "King"); // Adding a key-value pair (13, "King") to the 'numStringMap' object

        if (numStringMap.containsKey(myNumber)) { // Checking if the 'numStringMap' object contains a key with the same value as the instance variable 'myNumber'
            numStr = numStringMap.get(myNumber); // Assigning the value of the key that matches 'myNumber' to the variable 'numStr'
        }

        return numStr + " of " + mySuit.toString(); // Concatenating the values of 'numStr' and the result of the 'toString' method of the 'mySuit' instance variable, and returning the resulting string
    }
}
