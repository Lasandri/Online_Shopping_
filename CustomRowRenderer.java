
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class CustomRowRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellRenderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Retrieve the product from the table model based on the row index
        ProductTableModel model = (ProductTableModel) table.getModel();
        Product product = model.getRowObject(row);

        // Check if the product's availability
        if (product != null && product.getAvailableItems() < 3) {
            cellRenderer.setForeground(Color.RED); // Set background color to red
        } else {
            cellRenderer.setForeground(Color.BLACK);
        }
        this.setHorizontalAlignment(JLabel.CENTER);

        return cellRenderer;
    }
}