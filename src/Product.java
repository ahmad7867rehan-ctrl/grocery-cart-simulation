public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("%-20s $%.2f", name, price);
    }
}
