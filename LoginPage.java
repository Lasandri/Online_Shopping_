import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginPage extends JFrame implements ActionListener {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private  final JLabel message;
    private final ArrayList<User> users;
    private final ArrayList<Product> productsList;

    public LoginPage(ArrayList<User> users, ArrayList<Product> productsList) {
        this.users = users;
        this.productsList = productsList;

        Font headerFont = new Font("Arial", Font.BOLD, 13);
        // Set JFrame properties
        setTitle("Login or Register");
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2,2,25,20));
        topPanel.setBorder(new EmptyBorder(110,0,40,95));
        JLabel username = new JLabel("Username :");
        username.setFont(headerFont);
        username.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel password = new JLabel("Password :");
        password.setFont(headerFont);
        password.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameField.setFont(headerFont);
        passwordField.setFont(headerFont);
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);


        topPanel.add(username);
        topPanel.add(usernameField);
        topPanel.add(password);
        topPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        message = new JLabel("    ");
        message.setBorder(new EmptyBorder(20,0,0,0));
        message.setFont(headerFont);
        message.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1,2,20,20));
        buttonPanel.setBorder(new EmptyBorder(0,150,0,150));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(0,0,150,0));

        bottomPanel.add(buttonPanel,BorderLayout.CENTER);
        bottomPanel.add(message,BorderLayout.SOUTH);

        // Add action listeners
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        // Add components to the JFrame
        add(topPanel,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);

    }


    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword()); // Convert char[] to String for password
        boolean firstPurchase;
        if (e.getActionCommand().equals("Login")) {
            for(User user: users){
                if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                    firstPurchase = user.firstPurchase();

                    this.dispose();
                    final ArrayList<Product> productsOnCart = new ArrayList<>(50);
                    final Map<Product, Integer> quantityOnCart = new HashMap<>();
                    ShoppingCart shoppingCart = new ShoppingCart(productsOnCart,quantityOnCart);
                    ShoppingPage frame = new ShoppingPage(productsList,shoppingCart,firstPurchase);
                    frame.setTitle("Westminster Shopping Center");
                    frame.setSize(700,650);
                    frame.setMinimumSize(new Dimension(600, 400));
                    frame.setVisible(true);
                    return;
                }
                else if(user.getUserName().equals(username)){
                    message.setText("Password is incorrect");
                    passwordField.setText("");
                    passwordField.setBackground(new Color(255,100,100));
                    this.repaint();
                    return;
                }
            }
            usernameField.setText("");
            passwordField.setText("");
            usernameField.setBackground(new Color(255, 100, 100));
            passwordField.setBackground(new Color(255,100,100));
            message.setText("Incorrect username and password");

            this.repaint();

        } else if (e.getActionCommand().equals("Register")) {
            boolean newUser = true;
            for(User user: users){
                if(user.getUserName().equals(username)){
                    newUser = false;
                    break;
                }
            }

            if(!username.isEmpty() && !password.isEmpty() && newUser){
                users.add(new User(username,password));
                usernameField.setBackground(new Color(100, 200, 200));
                passwordField.setBackground(new Color(100,200,200 ));
                message.setText("Registered");
            } else if (!newUser) {
                usernameField.setBackground(new Color(255, 100, 100));
                message.setText("This username is already given");
            }
            else if(username.isEmpty() && password.isEmpty()){
                message.setText("Please enter the username and password");
                usernameField.setBackground(new Color(255, 100, 100));
                passwordField.setBackground(new Color(255,100,100));

            } else if (password.isEmpty()) {
                message.setText("Please enter the password");
                passwordField.setBackground(new Color(255, 100, 100));

            }
            else {
                message.setText("Please enter the username");
                usernameField.setBackground(new Color(255, 100, 100));
            }
        }
    }
}

