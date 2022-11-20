import java.util.ArrayList;
import java.util.List;

public class PatikaStore {
    private static List<Brand> brandList;
    private List<Product> products;

    public PatikaStore() {
        this.products = new ArrayList<>();
    }

    public static void addBrand(Brand brand) {
        brandList.add(brand);
    }

    public Brand getBrandByName(String name) {
        return brandList.stream()
                .filter(brand -> brand.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(int id) {
        this.products.removeIf(p -> p.getId() == id);
    }
}
