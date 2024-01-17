import java.util.List;

public interface ShoppingManager {



    boolean addProduct();

    void deleteProduct();

    List<Product> printProductList();

    List<Product> loadFile();

    Product saveToFile();

    boolean displayMenu();

    void openUI();
}
