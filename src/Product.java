public class Product {

    private int id;
    private double price;
    private double discountRate;
    private int quantity;
    private String name;

    public Product(int id, double price, double discountRate, int quantity, String name) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.quantity = quantity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
