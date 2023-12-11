import java.util.List;

public interface ShoppingManager {
    void addProduct(Product product);
    void removeProduct(Product product);
    Product findProduct(String productID);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Product getProductDetails(String productID);

    boolean displayMenu();
}
