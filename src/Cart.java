import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> items = new ArrayList<>();
    private static final double TAX_RATE = 0.08;

    public void addItem(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add a null product to the cart.");
        }
        items.add(product);
        System.out.println("✔ \"" + product.getName() + "\" added to your cart.");
    }
    public void removeItem(int index) {
        if (index < 1 || index > items.size()) {
            System.out.println("⚠ Invalid item number. Nothing was removed.");
            return;
        }
        Product removed = items.remove(index - 1);
        System.out.println("✔ \"" + removed.getName()+ "\" removed from your cart.");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("\n Your cart is empty.");
            return;
        }
        System.out.println("\n========== YOUR CART ==========");
        System.out.printf("%-4s %-20s %s%n", "#", "Item", "Price");
        System.out.println("-------------------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%-4d %s%n", (i + 1), items.get(i));
        }
        System.out.println("--------------------------------");
        System.out.printf("%-24s $%.2f%n", "Subtotal:", getSubtotal());
        System.out.printf("%-24s $%.2f%n", "Tax (8%):", getTax());
        System.out.printf("%-24s $%.2f%n", "Total:", getTotal());
        System.out.println("================================\n");
    }
    public void printReceipt() {
        if (items.isEmpty()) {
            System.out.println("\n Your cart is empty. Nothing to checkout.");
            return;
        }
        System.out.println("\n======================================");
        System.out.println("         GROCERY STORE RECEIPT        ");
        System.out.println("======================================");
        for (Product item : items) {
            System.out.printf("%-20s $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.println("--------------------------------------");
        System.out.printf("%-20s $%.2f%n", "Subtotal:", getSubtotal());
        System.out.printf("%-20s $%.2f%n", "Tax (8%):", getTax());
        System.out.printf("%-20s $%.2f%n", "TOTAL:", getTotal());
        System.out.println("======================================");
        System.out.println("   Thank you for shopping with us!   ");
        System.out.println("======================================\n");
    }
    public double getSubtotal() {
        double subtotal = 0;
        for (Product item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }
    public double getTax() {
        return getSubtotal() * TAX_RATE;
    }
    public double getTotal() {
        return getSubtotal() + getTax();
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public int getSize() {
        return items.size();
    }
}