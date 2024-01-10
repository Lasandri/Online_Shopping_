
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


class MyFrame extends JFrame{
    MyFrame(){            // constructor
        JLabel label = new JLabel();

        label.setText("Westminster Online Shopping Center ");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.blue);

        this.add(label);
    }
}



public class GUI {
    public static void main(String[] args) {

        MyFrame frame = new MyFrame(); // create frame object

        frame.setTitle(" Online Shopping ");
        frame.setSize(750,750);
        frame.getContentPane().setBackground(new Color(210,237,240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
