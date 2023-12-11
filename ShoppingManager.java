import java.util.List;

public interface ShoppingManager {
    void addProduct(Product product);
    void removeProduct(Product product);
    Product findProduct(String productID);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    String getProductDetails(String productID);
}
