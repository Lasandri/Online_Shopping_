
import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {
    private static final int MAX_PRODUCTS = 50;
    private static final String FILE_NAME = "productList.txt";

    final ArrayList<User> users = new ArrayList<>(50);
    private final ArrayList<Product> productList = new ArrayList<>(MAX_PRODUCTS);



    @Override
    public boolean addProduct() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter product Type (Electronics/Clothing): ");
            Product product = new Product();
            String productType = scanner.nextLine();
            product.setProductType(productType);


            if ("Electronics".equalsIgnoreCase(productType)) {
                Electronics electronics = new Electronics();
                setCommonProductDetails(electronics, scanner);

                System.out.print("Enter brand: ");
                scanner.nextLine();
                String brand = scanner.nextLine();
                electronics.setBrand(brand);

                System.out.print("Enter warranty period (in months): ");
                int warrantyPeriod = getValidIntInput(scanner);
                electronics.setWarrantyPeriod(warrantyPeriod);

                productList.add(electronics);
                System.out.println("Electronics product added successfully!");
                break;

            } else if ("Clothing".equalsIgnoreCase(productType)) {
                Clothing clothing = new Clothing();
                setCommonProductDetails(clothing, scanner);

                System.out.print("Enter size\"XS\", \"S\", \"M\", \"L\", \"XL\", \"14\", \"14.5\", \"15\", \"15.5\", \"16\", \"16.5\", \"17\": ");
                scanner.nextLine();
                String size = getValidSizeInput(scanner);
                clothing.setSize(size);

                System.out.print("Enter color: ");
                String color = getValidColorInput(scanner);
                clothing.setColor(color);

                productList.add(clothing);
                System.out.println("Clothing product added successfully!");
                break;

            } else {
                System.out.println("Invalid product type. Please enter Electronics or Clothing.");
            }
        }


        return false;
    }

    private void setCommonProductDetails(Product product, Scanner scanner) {
        System.out.print("Enter product ID: ");
        String productId = getValidProductIdInput(scanner);
        product.setProductID(productId);

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        product.setProductName(productName);

        System.out.print("Enter available items: ");
        int availableItems = getValidIntInput(scanner);
        product.setAvailableItems(availableItems);

        System.out.print("Enter price: ");
        double price = getValidDoubleInput(scanner);
        product.setPrice(price);
    }


    private String getValidProductIdInput(Scanner scanner) {
        while (true) {
            String productId = scanner.nextLine();
            if (isValidProductId(productId)) {
                return productId;
            } else {
                System.out.println("Invalid product ID. Please enter a valid ID (4 characters, starting with a letter followed by numbers): ");
            }
        }
    }

    private boolean isValidProductId(String productId) {
        return productId.matches("[A-Za-z]\\d{3}");
    }

    private int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer: ");
            scanner.next();  // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scanner.next();  // Consume the invalid input
        }
        return scanner.nextDouble();
    }

    private String getValidSizeInput(Scanner scanner) {
        String[] validSizes = {"XS", "S", "M", "L", "XL", "14", "14.5", "15", "15.5", "16", "16.5", "17"};
        while (true) {
            String size = scanner.nextLine();
            for (String validSize : validSizes) {
                if (validSize.equals(size)) {
                    return size;
                }
            }
            System.out.println("Invalid size. Please enter a valid size: ");
        }
    }

    private String getValidColorInput(Scanner scanner) {
        String[] validColors = {"White", "Black", "Red", "Yellow", "Blue", "Gray", "Pink", "Green", "Purple", "Orange"};
        while (true) {
            String color = scanner.nextLine();
            for (String validColor : validColors) {
                if (validColor.equalsIgnoreCase(color)) {
                    return color;
                }
            }
            System.out.println("Invalid color. Please enter a valid color: ");
        }
    }




    @Override
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the product ID to delete: ");
            String productId = getValidProductIdInput(scanner);

            boolean productFound = false;

            for (Product product : productList) {
                if (product.getProductID().equals(productId)) {
                    productList.remove(product);
                    System.out.println("Product deleted successfully!");
                    System.out.println("Remaining products: " + productList.size());
                    productFound = true;
                    break;
                }
            }

            if (productFound) {
                break; // Exit the loop if product is found and deleted
            } else {
                System.out.println("Product not found! Please enter a valid product ID.");
            }
        }
    }

    @Override
    public List<Product> printProductList() {
        // Remove deleted products from the list
        productList.removeIf(product -> product.getAvailableItems() == 0);

        Collections.sort(productList, Comparator.comparing(Product::getProductID));

        for (Product product : productList) {
            if (product instanceof Electronics) {
                System.out.println("Product Type: " +product.getProductType() + " ->" + product.getProductName() + " (ID: " + product.getProductID() + ")");
            } else if (product instanceof Clothing) {
                System.out.println("Product Type: " +product.getProductType() + " ->" + product.getProductName() + " (ID: " + product.getProductID() + ")");
            }
            System.out.println("   Price: $" + product.getPrice());
            System.out.println("   Available Items: " + product.getAvailableItems());

            // Additional details for Electronics and Clothing
            if (product instanceof Electronics) {
                System.out.println("   Brand: " + ((Electronics) product).getBrand());
                System.out.println("   Warranty Period: " + ((Electronics) product).getWarranty() + " months");
            } else if (product instanceof Clothing) {
                System.out.println("   Size: " + ((Clothing) product).getSize());
                System.out.println("   Color: " + ((Clothing) product).getColor());
            }
        }
        return null;
    }




    @Override
    public Product saveToFile() {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (Product product : productList) {
                    writer.write(product.toString());
                    writer.newLine(); // Move to the next line
                }
                System.out.println("Product list saved to file successfully!");
            } catch (IOException e) {
                System.out.println("Error: " );
            }
        return null;
    }

    @Override
    public List<Product> loadFile() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line (deserialize and add to productList)
                // Note: You need to implement the deserialization logic based on your file format.
            }
            System.out.println("Successfully loaded from file: " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for detailed information
        }
        return productList;

    }

    public void openUI(){
        LoginPage loginPage = new LoginPage(users, productList);
        loginPage.setTitle("Login or Register");
        loginPage.setSize(500, 500);
        loginPage.setResizable(false);
        loginPage.setVisible(true);
    }


    @Override
    public boolean displayMenu() {
        boolean exit = false;
        System.out.println("\nWestminster Shopping Manager Menu:");
        System.out.println("1. Add a product");
        System.out.println("2. Delete a product");
        System.out.println("3. Print product list");
        System.out.println("4. Save product list to file");
        System.out.println("5. Load data from file ");
        System.out.println("6. Open Shopping GUI");
        System.out.println("7. Exit");

        System.out.print("\nEnter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(".......Add Product......");
                addProduct();
                // Implement the logic to add a new product
                break;

            case 2:
                System.out.println("........... Delete Product........");
                deleteProduct();
                break;

            case 3:
                System.out.println("........... View Product........");
                printProductList();
                break;

            case 4:
                System.out.println("........... Save Product........");
                saveToFile();
                break;

            case 5:
                System.out.println("........... Load Products ........");
                loadFile();
                break;

            case 6:
                System.out.println("........... Open GUI........");
                // Implement the logic to open the GUI
                openUI();
                break;

            case 7:
                exit = true;
                break;

            default:
                System.out.println("Invalid choice! Please enter a valid choice.");
        }
        return exit;
    }



    public static void main(String[] args) {
        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        while (!shoppingManager.displayMenu()) {

        }
        shoppingManager.saveToFile();
    }


}
