import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager{
    private List<Product> products;


    Scanner scanner = new Scanner(System.in);

    public WestminsterShoppingManager(){
        this.products = new ArrayList<>();
    }
    @Override
    public void addProduct(Product product) {


        if(products.size()<50){
            products.add(product);
            System.out.println("Product added successfully....");

        }else {
            System.out.println("MAXIMUM CAPACITY IS 50 !!!!!");
        }


    }

    public void addElectronicsProduct(){
        System.out.println("......Add Electronics Product");

        Product product = new Electronics();



        System.out.println("Enter the brand: ");
        Electronics electronicProduct = (Electronics) products;
        electronicProduct.setBrand(scanner.nextLine());

        System.out.println("Enter the Warranty Period: ");
        electronicProduct.setWarrantyPeriod(scanner.nextInt());

    }


    public void addClothingProduct(){
        System.out.println("..........Add Clothing Product..........");
        Product product = new Clothing();
        Clothing clothingProduct = (Clothing) products;

        System.out.println("Enter Color: ");
        clothingProduct.setColor(scanner.nextLine());

        System.out.println("Enter Product Name: ");
        clothingProduct.setSize(scanner.nextLine());

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
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println(".......Add Product......");
                String productType = scanner.nextLine().toLowerCase();Product product = null;
                System.out.println("Enter Product Name: ");
                product.setProductName(scanner.nextLine());
                System.out.println("Enter Product ID: ");

                product.setProductID(scanner.nextLine());



                System.out.println("Enter the Number of Availability Items: ");
                product.setAvailableItems(scanner.nextInt());
                addProduct(product);

                System.out.println("Enter the Price: ");
                product.setPrice(scanner.nextDouble());

                if (productType.equals("electronics")){
                    addElectronicsProduct();
                }

                else if (productType.equals("clothing")){
                    addClothingProduct();
                }

                else{
                    System.out.println("Invalid Product type !!!!! ");
                }




            case 2:




            case 3:




            case 4:




            case 5:
                exit = true;
        }
        return exit;
    }

    public static void main(String[] args) {
        ShoppingManager say = new WestminsterShoppingManager();

        for(boolean exit = false; !exit; exit = say.displayMenu()){

        }
    }

}
