
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


class MyFrame extends JFrame{

    JLabel label;
    JButton button;
    JComboBox<String> productTypes;
    JFrame frame;

    MyFrame(){            // constructor
        label = new JLabel("Westminster Online Shopping Center ");
        label.setForeground(Color.blue);
        this.add(label);


        button = new JButton("Shopping Cart");
        button.setBounds(500,120,125,40);
        this.add(button);

        label = new JLabel("Select product type:");
        add(label);

        // Create the dropdown menu with options
        String[] types = {"All", "Electronics", "Clothes"};
        productTypes = new JComboBox<>(types);
        add(productTypes);
        // Add the dropdown menu to the frame


        productTypes.addActionListener(e -> {
            String selectedType = (String) productTypes.getSelectedItem();
            // Here you can handle what happens when a type is selected
            // For instance, trigger the visualization of the selected product type
            System.out.println("Selected product type: " + selectedType);
        });


    }
}



public class GUI {
    public static void main(String[] args) {

        MyFrame frame = new MyFrame(); // create frame object

        frame.setTitle(" Online Shopping ");
        frame.setSize(750,750);
        frame.getContentPane().setBackground(new Color(210,237,240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);


    }
}
