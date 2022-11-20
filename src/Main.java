import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        addBrands();

        Command command = null;
        PatikaStore patikaStore = new PatikaStore();
        do {
            try {
                command = Command.executeMatching(IN.readLine(), patikaStore);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (command == null || command.isRunning());
    }

    private static void addBrands() {
        Brand samsung = new Brand(1, "Samsung");
        Brand lenovo = new Brand(2, "Lenovo");
        Brand apple = new Brand(3, "Apple");
        Brand huawei = new Brand(4, "Huawei");
        Brand casper = new Brand(5, "Casper");
        Brand asus = new Brand(6, "Asus");
        Brand hp = new Brand(7, "HP");
        Brand xiaomi = new Brand(8, "Xiaomi");
        Brand monster = new Brand(9, "Monster");

        PatikaStore.addBrand(samsung);
        PatikaStore.addBrand(lenovo);
        PatikaStore.addBrand(apple);
        PatikaStore.addBrand(huawei);
        PatikaStore.addBrand(casper);
        PatikaStore.addBrand(asus);
        PatikaStore.addBrand(hp);
        PatikaStore.addBrand(xiaomi);
        PatikaStore.addBrand(monster);

    }
}