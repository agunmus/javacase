public class MobilePhone extends Product {
    private Brand brand;
    private String storage;
    private String screenSize;
    private int batteryPower;
    private String RAM;
    private String color;

    public MobilePhone(
            int id,
            double price,
            double discountRate,
            int quantity,
            String name,
            Brand brand,
            String storage,
            String color
    ) {
        super(id, price, discountRate, quantity, name);
        this.brand = brand;
        this.storage = storage;
        this.screenSize = "6.1 Inc";
        this.batteryPower = 4000;
        this.RAM = "6 MB";
        this.color = color;
    }
}
