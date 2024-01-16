import java.util.List;

public interface ShoppingManager {
    static void main(String[] args) {
        ShoppingManager say = new WestminsterShoppingManager();
        while (!say.displayMenu()) {

        }
    }


    boolean addProduct();

    void deleteProduct();

    List<Product> printProductList();

    List<Product> readFile();

    Product saveToFile();

    boolean displayMenu();
}
