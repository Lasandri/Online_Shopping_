import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class AddToCart implements ActionListener {
    private final JTable productsTable;
    private final ArrayList<Product> productList;
    private final ViewTable viewTable;
    private final ShoppingCartPage shoppingCartPage;
    private final boolean firstPurchase;

    public AddToCart(JTable productsTable, ArrayList<Product> productList,
                           ViewTable viewTable, ShoppingCartPage shoppingCartPage, boolean firstPurchase){
        this.productsTable = productsTable;
        this.productList = productList;
        this.viewTable = viewTable;
        this.shoppingCartPage = shoppingCartPage;
        this.firstPurchase = firstPurchase;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int selectedRow = productsTable.getSelectedRow();
        if(selectedRow != -1) {
            String selectedProductId = productsTable.getValueAt(selectedRow, 0).toString();
            Map<Product, Integer> quantityOnCart = viewTable.getShoppingCart().getQuantityOnCart();

            // get the selected product and check its availability
            for (Product checker : productList) {
                if (checker.getProductID().equals(selectedProductId) && checker.getAvailableItems()>0) {
                    int availableItems;
                    if(quantityOnCart.containsKey(checker)){
                        availableItems = checker.getAvailableItems() - quantityOnCart.get(checker);
                    }
                    else availableItems = checker.getAvailableItems();

                    if (availableItems > 0) {
                        viewTable.getShoppingCart().addToCart(checker);
                        shoppingCartPage.updatePrices(viewTable.getShoppingCart().calculateTotal(), viewTable.getShoppingCart(),firstPurchase);
                        viewTable.fireTableDataChanged();
                    }

                    break;
                }
            }

        }
    }
}

