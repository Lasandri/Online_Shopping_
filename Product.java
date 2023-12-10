public abstract class Product {
    private  String productID;
    private String productName;
    private int availableItems;
    private double price;

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product [ProductID= "+productID+ "productName= "+productName +"availableItems= "+availableItems+ "price= "+price +" }";
    }
}
