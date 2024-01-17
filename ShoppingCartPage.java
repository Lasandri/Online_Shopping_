
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;

public class ShoppingCartPage extends JFrame {
    JLabel totalPrice,firstPurchaseDiscountPrice,threeItemsDiscountPrice,finalPrice;

    public ShoppingCartPage(ViewTable viewTable){
        Font bodyFont = new Font("Arial", Font.PLAIN, 12);
        Font headerFont = new Font("Arial", Font.BOLD, 12);
        this.setLayout(new BorderLayout());

        JTable cartTable = new JTable( viewTable);
        // Add the cartTable to a JScrollPane and add it to the frame
        JScrollPane scrollPane = new JScrollPane(cartTable);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(new EmptyBorder(40,20,10,20));
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0; i<3; i++){
            cartTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        cartTable.setRowHeight(30);
        cartTable.getColumnModel().getColumn(0).setMinWidth(150);

        // set header attributes
        JTableHeader tableHeader = cartTable.getTableHeader();
        tableHeader.setReorderingAllowed(false); // Disable reordering
        tableHeader.setFont(headerFont); // Set font to bold
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 35));

        //bottom panel - contains four panels for each row
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4,1,0,10));
        bottomPanel.setBorder(new EmptyBorder(15,20,35,100));

        //panels for 4 rows - each panel has 2 labels
        JPanel totalPanel,firstPurchasePanel,threeItemsPanel,finalTotalPanel;

        totalPanel = new JPanel(new BorderLayout());
        firstPurchasePanel = new JPanel(new BorderLayout());
        threeItemsPanel = new JPanel(new BorderLayout());
        finalTotalPanel = new JPanel(new BorderLayout());

        // labels for fill the
        JLabel totalLabel,firstPurchaseLabel, threeItemsLabel,finalTotalLabel;


        // labels for prices description
        totalLabel = new JLabel("Total      ");
        firstPurchaseLabel = new JLabel("First Purchase Discount (10%)      ");
        threeItemsLabel = new JLabel("Three Items in same Category (20%)      ");
        finalTotalLabel = new JLabel("Final Total      ");

        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        firstPurchaseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        threeItemsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        finalTotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // labels for prices values
        totalPrice = new JLabel("0 £");
        firstPurchaseDiscountPrice = new JLabel("-0 £");
        threeItemsDiscountPrice = new JLabel("-0 £");
        finalPrice = new JLabel("0 £");

        totalLabel.setFont(bodyFont);
        firstPurchaseLabel.setFont(bodyFont);
        threeItemsLabel.setFont(bodyFont);
        totalPrice.setFont(bodyFont);
        firstPurchaseDiscountPrice.setFont(bodyFont);
        threeItemsDiscountPrice.setFont(bodyFont);


        Dimension priceLabelsSize = new Dimension(100,20);
        totalPrice.setPreferredSize(priceLabelsSize);
        firstPurchaseDiscountPrice.setPreferredSize(priceLabelsSize);
        threeItemsDiscountPrice.setPreferredSize(priceLabelsSize);
        finalPrice.setPreferredSize(priceLabelsSize);

        totalPanel.add(totalLabel,BorderLayout.CENTER);
        totalPanel.add(totalPrice,BorderLayout.EAST);
        firstPurchasePanel.add(firstPurchaseLabel,BorderLayout.CENTER);
        firstPurchasePanel.add(firstPurchaseDiscountPrice,BorderLayout.EAST);
        threeItemsPanel.add(threeItemsLabel,BorderLayout.CENTER);
        threeItemsPanel.add(threeItemsDiscountPrice,BorderLayout.EAST);
        finalTotalPanel.add(finalTotalLabel,BorderLayout.CENTER);
        finalTotalPanel.add(finalPrice,BorderLayout.EAST);

        bottomPanel.add(totalPanel);
        bottomPanel.add(firstPurchasePanel);
        bottomPanel.add(threeItemsPanel);
        bottomPanel.add(finalTotalPanel);

        add(tablePanel,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
    }

    public void updatePrices(double totalPrice,ShoppingCart shoppingCart,boolean firstPurchase){
        double discount1 = 0;
        double discount2 = shoppingCart.getThreeSameItemsDiscount();

        this.totalPrice.setText((Math.round(totalPrice* 100.0) / 100.0) +" £");
        if(firstPurchase) {
            discount1 = Math.round((totalPrice*0.1) * 100.0) / 100.0;
            this.firstPurchaseDiscountPrice.setText("-" + discount1 + " £");
        }

        this.threeItemsDiscountPrice.setText("-"+ discount2 +" £");

        totalPrice = totalPrice-(discount1+discount2);
        this.finalPrice.setText((Math.round(totalPrice* 100.0) / 100.0) +" £");
    }

}
