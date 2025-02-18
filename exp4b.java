import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class exp4b {
    private static Collection<Card> cardDeck = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    searchCards();
                    break;
                case 3:
                    displayCards();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Card Symbol (e.g., Hearts, Spades, Diamonds, Clubs): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Value (e.g., Ace, 2, 3, ... King): ");
        String value = scanner.nextLine();

        cardDeck.add(new Card(symbol, value));
        System.out.println("Card added successfully.");
    }

    private static void searchCards() {
        System.out.print("Enter Symbol to Search: ");
        String symbol = scanner.nextLine();

        boolean found = false;
        System.out.println("\nCards in " + symbol + ":");
        for (Card card : cardDeck) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for the symbol: " + symbol);
        }
    }

    private static void displayCards() {
        if (cardDeck.isEmpty()) {
            System.out.println("No cards in the collection.");
        } else {
            System.out.println("\nAll Cards:");
            for (Card card : cardDeck) {
                System.out.println(card);
            }
        }
    }
}
