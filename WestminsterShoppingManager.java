import java.util.ArrayList;
import java.util.List;

public class WestminsterShoppingManager implements ShoppingManager{
    private List<Product> products;

    public WestminsterShoppingManager(){
        this.products = new ArrayList<>();
    }
    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(Product product) {

    }

    @Override
    public Product findProduct(String productID) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public String getProductDetails(String productID) {
        return null;
    }

    @Override
    public String toString() {
        return "WestminsterShoppingManager [products=" + products + "]";
    }
}
