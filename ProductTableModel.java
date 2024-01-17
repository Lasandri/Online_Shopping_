import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Product ID","Name","Category","Price(£)","Info"};
    private final ArrayList<Product> productList;

    public ProductTableModel(ArrayList<Product> productList){
        this.productList = productList;
    }


    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product selectedProduct = productList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {return selectedProduct.getProductID();}
            case 1 -> {return selectedProduct.getProductName();}
            case 2 -> {
                if ("Clothing".equalsIgnoreCase(selectedProduct.getProductType())) {
                    return "Clothing";
                } else return "Electronics";
            }
            case 3 -> {return selectedProduct.getPrice();}
            case 4 -> {
                if("Clothing".equalsIgnoreCase(selectedProduct.getProductType())){
                    Clothing selectedClothingProduct = (Clothing)selectedProduct;
                    return selectedClothingProduct.getSize()+", "+selectedClothingProduct.getColor();
                }
                else{
                    Electronics selectedElectronicsProduct = (Electronics) selectedProduct;
                    return selectedElectronicsProduct.getBrand()+ ", " +
                            selectedElectronicsProduct.getWarranty();
                }
            }
            default -> {return null;}
        }
    }

    // needed to show column names in JTable
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    //Set the column class to Double
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Double.class; // fixing the sorting error when price is considered as a string
        }
        else return String.class;
    }

    public Product getRowObject(int Row){
        for(Product product: productList){
            if(this.getValueAt(Row,0).equals(product.getProductID())){
                return product;
            }
        }
        return null;
    }

}
