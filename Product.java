public  class Product  {
    private String productID;
    private  String productName;
    private  double price;
    private int AvailableItems;
    private String productType;

    public Product(String productID, String productName, double price, int availableItems, String productType) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.AvailableItems = availableItems;
        this.productType = productType;
    }

    public Product() {

    }


    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableItems() {
        return AvailableItems;
    }

    public String getProductType(){
        return productType;
    }


    public  void setProductID(String productID) {
        this.productID=productID;
    }

    public void setProductName(String productName) {
        this.productName=productName;
    }

    public void setPrice(double price) {
        this.price=price;
    }

    public  void setAvailableItems(int availableItems) {
        this.AvailableItems=availableItems;
    }
    public  void setProductType(String productType) {
        this.productType=productType;
    }


    public String toString() {
        return "Product Type: " + getProductType() +
                "\nProduct Id: " + getProductID() +
                "\nProduct Name: " + getProductName() +
                "\nPrice: " + getPrice() +
                "\nAvailable Items: " + getAvailableItems();
    }
}
