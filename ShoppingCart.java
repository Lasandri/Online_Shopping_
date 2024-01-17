import java.util.ArrayList;
import java.util.Map;

public class ShoppingCart {
    private final ArrayList<Product> productsOnCart;
    private final Map<Product, Integer> quantityOnCart;


    public ShoppingCart(ArrayList<Product> productsOnCart,Map<Product, Integer> quantityOnCart) {
        this.productsOnCart = productsOnCart;
        this.quantityOnCart = quantityOnCart;
    }

    public ArrayList<Product> getCartList() {
        return productsOnCart;
    }

    public Map<Product, Integer> getQuantityOnCart() {
        return quantityOnCart;
    }

    public void addToCart(Product prodToAdd){
        if(productsOnCart.contains(prodToAdd)) {
            quantityOnCart.put(prodToAdd, quantityOnCart.get(prodToAdd) + 1);
        }
        else{
            productsOnCart.add(prodToAdd);
            quantityOnCart.put(prodToAdd,1);
        }

    }

    public void remove(Product productToRemove){
        productsOnCart.remove(productToRemove);
        quantityOnCart.remove(productToRemove);
    }

    public double calculateTotal(){
        double total = 0;
        double itemsPrice;
        for(Product iterate : this.productsOnCart){
            itemsPrice = iterate.getPrice() * quantityOnCart.get(iterate);
            total += Math.round(itemsPrice * 100.0) / 100.0;
        }
        return total;
    }

    public double getThreeSameItemsDiscount(){
        double discount = 0;
        for(Product product: productsOnCart){
            if(getQuantityOnCart().containsKey(product) && getQuantityOnCart().get(product) >= 3)
                discount += (product.getPrice() * getQuantityOnCart().get(product)) * 0.2;
        }
        return Math.round(discount * 100.0) / 100.0;
    }


}
