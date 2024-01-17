import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class ShoppingPage extends JFrame {

    public ShoppingPage(ArrayList<Product> productList, ShoppingCart shoppingCart, boolean firstPurchase){
        JPanel selectProductPanel,selectProductAndCartBtn,topPanel,bottomPanel;
        JLabel selectProductCategory;
        String[] categories = {"All","Electronics","Clothing"};
        JComboBox<String> selectProductCategoryComboBox;
        JButton cartBtn,addToCartBtn;
        Font headerFont = new Font("Arial", Font.BOLD, 12);
        Font bodyFont = new Font("Arial", Font.PLAIN, 12);

        this.setLayout(new BorderLayout());
        // selectProductPanel
        selectProductPanel = new JPanel();
        selectProductPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));

        // components
        selectProductCategory = new JLabel("  Select Product Category");
        selectProductCategoryComboBox = new JComboBox<>(categories);
        selectProductCategoryComboBox.setPreferredSize(new Dimension(120,20));

        // add components
        selectProductPanel.add(selectProductCategory);
        selectProductPanel.add(selectProductCategoryComboBox);

        // selectProductAndCartBtn
        selectProductAndCartBtn = new JPanel();
        selectProductAndCartBtn.setLayout(new BorderLayout());
        // components
        JPanel cartButtonPanel = new JPanel();
        cartButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        cartBtn = new JButton("Shopping Cart");
        cartBtn.setPreferredSize(new Dimension(120,30));
        cartButtonPanel.add(cartBtn);

        // add components
        selectProductAndCartBtn.add(selectProductPanel,BorderLayout.CENTER);
        selectProductAndCartBtn.add(cartButtonPanel,BorderLayout.EAST);

        // topPanel
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        // components
        ProductTableModel tableModel = new ProductTableModel(productList);
        JTable productsTable = new JTable(tableModel);

        // set header attributes
        JTableHeader tableHeader = productsTable.getTableHeader();
        tableHeader.setReorderingAllowed(false); // Disable reordering
        tableHeader.setFont(headerFont); // Set font to bold
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 35));

        // custom renderer to each column of the table
        for (int i = 0; i < productsTable.getColumnCount(); i++) {
            productsTable.getColumnModel().getColumn(i).setCellRenderer(new CustomRowRenderer());
        }


        productsTable.setRowHeight(30);
        productsTable.getColumnModel().getColumn(4).setMinWidth(150);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(new EmptyBorder(40,0,10,0));
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(new JScrollPane(productsTable),BorderLayout.CENTER);



        // add components
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.add(selectProductAndCartBtn,BorderLayout.NORTH);
        topPanel.add(tablePanel,BorderLayout.CENTER);

        // bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // components
        JPanel productDetails = new JPanel();
        productDetails.setLayout(new GridLayout(7,1,10,10));
        productDetails.setBorder(new EmptyBorder(0, 30, 30, 10));

        JLabel productDetailsHeader = new JLabel("Selected Product - Details");
        JLabel id,category,name,additional1,additional2,availability;
        id = new JLabel("");
        category = new JLabel("");
        name = new JLabel("");
        additional1 = new JLabel("");
        additional2 = new JLabel("");
        availability = new JLabel("");
        id.setFont(bodyFont);
        category.setFont(bodyFont);
        name.setFont(bodyFont);
        additional1.setFont(bodyFont);
        additional2.setFont(bodyFont);
        availability.setFont(bodyFont);
        productDetails.add(productDetailsHeader);
        productDetails.add(id);
        productDetails.add(category);
        productDetails.add(name);
        productDetails.add(additional1);
        productDetails.add(additional2);
        productDetails.add(availability);

        JPanel addToCartPanel = new JPanel();
        addToCartPanel.setLayout(new FlowLayout());
        addToCartBtn = new JButton("Add to Shopping Cart");
        addToCartPanel.add(addToCartBtn);

        // add components
        bottomPanel.add(productDetails,BorderLayout.CENTER);
        bottomPanel.add(addToCartPanel,BorderLayout.SOUTH);

        //add to frame
        this.add(topPanel,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.SOUTH);

        // product table selection model
        productsTable.getSelectionModel().addListSelectionListener(new ProductTable(productsTable,
                productList,id,category,name,additional1,additional2,availability));

        // sorting instance to sort table columns
        TableRowSorter<ProductTableModel> sorter = new TableRowSorter<>(tableModel);
        productsTable.setRowSorter(sorter);

        // Action Listener to filtering products on products table
        selectProductCategoryComboBox.addActionListener(new ProductCatogory
                (selectProductCategoryComboBox,productsTable,sorter));

        // cart table model to create cart GUI
        ViewTable viewTable = new ViewTable(shoppingCart);

        // creating cart GUI  (still not visible)
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(viewTable);
        shoppingCartPage.setTitle("Shopping Cart");
        shoppingCartPage.setSize(700, 450);
        shoppingCartPage.setVisible(false);

        // adding action listener to addToCart button
        addToCartBtn.addActionListener(new AddToCart(productsTable,productList,
                viewTable, shoppingCartPage,firstPurchase));

        // adding action listener to cart button
        cartBtn.addActionListener(new CartButton(shoppingCartPage));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                shoppingCartPage.dispose();
            }
        });
    }


}
