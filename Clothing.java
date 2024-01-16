public class Clothing extends Product{
    private  String size;
    private  String color;


    public Clothing(String productID, String productName, double price, int availableItems, String productType, String size, String colour) {
        super(productID, productName, price, availableItems, productType);
        this.size = size;
        this.color = colour;
    }

    public Clothing(){

    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size=size;

    }

    public void setColor(String color) {
        this.color =color;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSize: " + getSize() +
                "\nColor: " + getColor();
    }


}
