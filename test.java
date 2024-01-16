import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test implements ShoppingManager{

    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    private final ArrayList<Product> productList = new ArrayList<>(MAX_PRODUCTS);
    private static final int MAX_PRODUCTS = 50;


    @Override
    public boolean addProduct() {


        System.out.println("Enter product Type: ");
        String productType = scanner.nextLine();

        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        product.setProductID(productId);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        product.setProductName(productName);

        System.out.print("Enter available items: ");
        int availableItems = scanner.nextInt();
        product.setAvailableItems(availableItems);

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        product.setPrice(price);


        if (productType.equals("Electronics")) {
            elect();
        }
        else if (productType.equals("clothing")) {
            cloth();
        }

        else {
            System.out.println("Enter Electronics or Clothing ");
        }

        productList.add(product);
        System.out.println("Product added successfully!");
        return false;
    }




    public void elect(){
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        ((Electronics) product).setBrand(brand);

        System.out.print("Enter warranty period (in months): ");
        int warrantyPeriod = scanner.nextInt();
        ((Electronics) product).setWarrantyPeriod(warrantyPeriod);
    }

    public void cloth(){
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        ((Clothing) product).setSize(size);

        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        ((Clothing) product).setColor(color);
    }

    public static void main(String[] args) {
        test shoppingManager = new test();
        while (!shoppingManager.addProduct()) {
        }

    }

























    @Override
    public void deleteProduct() {

    }

    @Override
    public List<Product> printProductList() {
        return null;
    }

    @Override
    public List<Product> readFile() {
        return null;
    }

    @Override
    public Product saveToFile() {
        return null;
    }

    @Override
    public boolean displayMenu() {
        return false;
    }
}
