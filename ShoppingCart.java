import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public ShoppingCart(){
    this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public double calculateTCost(){
        double totalCost = 0;
        for (Product product:products){
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        return "ShoppingCart [products=" + products + "]";
    }

}
