import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ViewTable extends AbstractMethodError implements TableModel {
    private final ShoppingCart shoppingCart;
    private final String[] columnNames = {"Product","Quantity","Price"};

    public ViewTable(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }




    public Object getValueAt(int rowIndex, int columnIndex) {
        Product selectedProduct = shoppingCart.getCartList().get(rowIndex);
        switch (columnIndex) {
            case 0:
                String details = selectedProduct.getProductID() + ", " + selectedProduct.getProductName() + ", ";
                if ("Clothing".equalsIgnoreCase(selectedProduct.getProductType())) {
                    Clothing selectedClothingProduct = (Clothing) selectedProduct;
                    details += selectedClothingProduct.getSize() + ", " + selectedClothingProduct.getColor();
                } else {
                    Electronics selectedElectronicsProduct = (Electronics) selectedProduct;
                    details += selectedElectronicsProduct.getBrand() + ", " +
                            selectedElectronicsProduct.getWarranty();
                }
                return details;
            case 1:
                return shoppingCart.getQuantityOnCart().get(selectedProduct);
            case 2:
                double price = selectedProduct.getPrice() * shoppingCart.getQuantityOnCart().get(selectedProduct);
                price = Math.round(price * 100.0) / 100.0;
                return price + " £";
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void fireTableDataChanged() {
    }
}
