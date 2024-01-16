public class Electronics extends Product {
    private  String brand;
    private  int WarrantyPeriod;

    // constructor


    public Electronics(String productID, String productName, double price, int availableItems, String productType, String brand, int warrantyPeriod) {
        super(productID, productName, price, availableItems, productType);
        this.brand = brand;
        this.WarrantyPeriod = warrantyPeriod;
    }

    public Electronics() {

    }

    // getter for brand
    public String getBrand() {
        return brand;
    }

    // getter for warranty
    public int getWarranty() {
        return WarrantyPeriod;
    }


    public  void setWarrantyPeriod(int warrantyPeriod) {
        this.WarrantyPeriod = warrantyPeriod;

    }
    public  void setBrand(String brand){
        this.brand=brand;

    }

    public String toString() {
        return super.toString() + "\nBrand: " + getBrand() +
                "\nWarranty Period: " + getWarranty();
    }


}