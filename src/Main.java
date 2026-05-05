import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        System.out.println("Welcome to the Grocery Store!");

        while (true) {
            displayMainMenu();
            System.out.print("Choose an option (1-5): ");

            int choice = getValidIntInput(scanner, 1, 5);

            switch (choice) {
                case 1:
                    browseProducts(scanner, store, cart);
                    break;
                case 2:
                    cart.displayCart();
                    break;
                case 3:
                    removeFromCart(scanner, cart);
                    break;
                case 4:
                    checkout(scanner, cart);
                    break;
                case 5:
                    System.out.println("\nThank you for visiting! Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Browse Products");
        System.out.println("2. View Cart");
        System.out.println("3. Remove Item from Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        System.out.println("================================");
    }

    private static void browseProducts(Scanner scanner, Store store, Cart cart) {
        store.displayMenu();

        while (true) {
            System.out.print("Enter product number to add (0 to go back): ");
            int productNum = getValidIntInput(scanner, 0, store.getInventorySize());

            if (productNum == 0) {
                break;
            }

            Product selected = store.getProductByIndex(productNum);
            if (selected != null) {
                cart.addItem(selected);
                System.out.print("Add another item? (y/n): ");
                String response = scanner.next().trim().toLowerCase();
                if (!response.equals("y") && !response.equals("yes")) {
                    break;
                }
            }
        }
    }

    private static void removeFromCart(Scanner scanner, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("\n Your cart is empty. Nothing to remove.");
            return;
        }

        cart.displayCart();
        System.out.print("Enter item number to remove (0 to cancel): ");
        int itemNum = getValidIntInput(scanner, 0, cart.getSize());

        if (itemNum == 0) {
            System.out.println("Removal cancelled.");
            return;
        }

        cart.removeItem(itemNum);
    }

    private static void checkout(Scanner scanner, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("\n Your cart is empty. Add some items before checking out.");
            return;
        }

        System.out.println("\n========== CHECKOUT ==========");
        cart.displayCart();

        System.out.print("Confirm purchase? (y/n): ");
        String confirm = scanner.next().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            cart.printReceipt();
            System.out.println("Transaction complete! Your cart has been emptied.");

            // Clear the cart after successful checkout
            while (!cart.isEmpty()) {
                cart.removeItem(1);
            }
        } else {
            System.out.println("Checkout cancelled. Items remain in your cart.");
        }
    }

    private static int getValidIntInput(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                }
            } else {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}