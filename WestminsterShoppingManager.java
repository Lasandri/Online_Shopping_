import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    private List<Product> products;
    private Scanner scanner;

    public WestminsterShoppingManager() {
        this.products = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addProduct(Product product) {
        if (product.getAvailableItems() <= 50) {
            products.add(product);
            System.out.println("Product added successfully....");
        } else {
            System.out.println("Either MAXIMUM CAPACITY (50) exceeded or invalid available items! Product not added.");
        }
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
        return null;
    }

    public void addElectronicsProduct() {
        System.out.println("......Add Electronics Product");

        Electronics electronicProduct = new Electronics();

        System.out.println("Enter the brand: ");
        scanner.nextLine(); // Consume the newline character
        electronicProduct.setBrand(scanner.nextLine());

        System.out.println("Enter the Warranty Period: ");
        electronicProduct.setWarrantyPeriod(scanner.nextInt());

        // Add the electronics product to the list
        addProduct(electronicProduct);

    }

    public void addClothingProduct() {
        System.out.println("..........Add Clothing Product..........");

        Clothing clothingProduct = new Clothing();

        System.out.println("Enter Color: ");
        scanner.nextLine(); // Consume the newline character
        clothingProduct.setColor(scanner.nextLine());

        System.out.println("Enter Size: (M or L)");
        clothingProduct.setSize(scanner.nextLine());



        addProduct(clothingProduct);

    }

    // Other methods...

    public boolean displayMenu() {
        boolean exit = false;
        System.out.println("Westminster Shopping Manager Menu:");
        System.out.println("1. Add a product");
        System.out.println("2. Delete a product");
        System.out.println("3. Print product list");
        System.out.println("4. Save product list to file");
        System.out.println("5. Exit");

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(".......Add Product......");

                scanner.nextLine();
                System.out.println("Enter Product Type (electronics/clothing): ");
                String productType = scanner.nextLine().toLowerCase();
                Product product = new Product();

                System.out.println("Enter Product Name: ");
                product.setProductName(scanner.nextLine());

                System.out.println("Enter Product ID: ");
                product.setProductID(scanner.nextLine());

                System.out.println("Enter the Number of Availability Items: ");
                product.setAvailableItems(scanner.nextInt());

                System.out.println("Enter the Price: ");
                product.setPrice(scanner.nextDouble());

                if (productType.equals("electronics")) {
                    addElectronicsProduct();
                } else if (productType.equals("clothing")) {
                    addClothingProduct();
                } else {
                    System.out.println("Invalid Product type !!!!! ");
                }
                break;

            case 2:
                // Code for case 2
                break;

            case 3:
                // Code for case 3
                break;

            case 4:
                // Code for case 4
                break;

            case 5:
                exit = true;
                break;

            default:
                System.out.println("Invalid choice! Please enter a valid choice.");
        }
        return exit;
    }

    public static void main(String[] args) {
        ShoppingManager say = new WestminsterShoppingManager();
        while (!say.displayMenu()) {
            // Loop until the user chooses to exit
        }
    }
}
