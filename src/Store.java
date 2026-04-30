import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private final List<Product> inventory = new ArrayList<>();
    public Store() {
        loadProducts();
    }

    private void loadProducts() {
        inventory.add(new Product("Apple (1 lb", 1.49));
        inventory.add(new Product("Bananas (1 bunch", 0.99));
        inventory.add(new Product("Whole Milk (1 gal", 3.49));
        inventory.add(new Product("Eggs (12 ct", 4.99));
        inventory.add(new Product("Cheddar Cheese", 5.49));
        inventory.add(new Product("Chicken Breast", 7.99));
        inventory.add(new Product("Orange Juice", 3.99));
        inventory.add(new Product("Pasta (1 lb", 1.29));
        inventory.add(new Product("Tomato Sauce", 1.99));
    }

    public List<Product> getInventory() {
        return Collections.unmodifiableList(inventory);
    }

    public void displayMenu() {
        System.out.println("\n========== GROCERY STORE ==========");
        System.out.printf("%-4s %-22s %s%n","#", "Item", "Price");
        System.out.println("-------------------------------------");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.printf("%-4d %s%n", (i + 1), inventory.get(i));
        }
        System.out.println("====================================\n");
    }

    public Product getProductByIndex(int index) {
        if (index < 1 || index > inventory.size()) {
            return null;
        }
        return inventory.get(index - 1);
    }

    public int getInventorySize() {
        return inventory.size();
    }

}