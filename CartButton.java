import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartButton implements ActionListener {
    ShoppingCartPage shoppingCartPage;

    public CartButton(ShoppingCartPage shoppingCartPage){
        this.shoppingCartPage = shoppingCartPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!shoppingCartPage.isActive()){
            shoppingCartPage.setVisible(true);
        }
    }
}
