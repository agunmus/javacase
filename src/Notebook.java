public class Notebook extends Product {
    private Brand brand;
    private String RAM;
    private String storage;
    private double screenSize;

    public Notebook(int id,
                       double price,
                       double discountRate,
                       int quantity,
                       String name,
                       Brand brand,
                       double screenSize
    ) {
        super(id, price, discountRate, quantity, name);
        this.brand = brand;
        this.storage = "512 SSD";
        this.screenSize = screenSize;
        this.RAM = "8 GB";
    }
}
