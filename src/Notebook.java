public class Notebook extends Product {
    private Brand brand;
    private String RAM;
    private String storage;
    private String screenSize;

    public Notebook(int id,
                       double price,
                       double discountRate,
                       int quantity,
                       String name,
                       Brand brand
    ) {
        super(id, price, discountRate, quantity, name);
        this.brand = brand;
        this.storage = "512 SSD";
        this.screenSize = "6 Inch";
        this.RAM = "8 GB";
    }
}
