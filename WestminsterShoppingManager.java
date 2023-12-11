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
    public Product getProductDetails(String productID) {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null; // Not found
    }

    @Override
    public String toString() {
        return "WestminsterShoppingManager [products=" + products + "]";
    }

    public boolean displayMenu() {
        boolean exit = false;
        System.out.println("Westminster Shopping Manager Menu:");
        System.out.println("1. Add a product");
        System.out.println("2. Delete a product");
        System.out.println("3. Print product list");
        System.out.println("4. Save product list to file");
        System.out.println("5. Exit");

        System.out.print("\nEnter your choice: ");
        return exit;
    }

}
