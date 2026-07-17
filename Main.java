/**
 * Main
 * 
 * @author 
 * @version beginning 10/07/26
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {

    double orderTotal = 0;
   
    public void runGUI(){

        // create frame
        JFrame frame = new JFrame("Till System!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        // create top panel for items to go on, items will be left aligned
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // set price of ice cream
        double price = 1.51;
        double slushprice = 2;

        // create button with labels
        JButton btn = new JButton("Ice Cream: £1.51");
        JButton btn2 = new JButton("Slushie: £2.00");
        JLabel label1 = new JLabel("Current Total: £");
        JLabel label2 = new JLabel("0.00");
        topPanel.add(btn); // dont forget to add items to the panel
        topPanel.add(btn2);
        topPanel.add(label1);
        topPanel.add(label2);
        
        // add the top panel to the frame, to sit at the top / North
        frame.add(topPanel, BorderLayout.NORTH);

        // create a new text area to form the main, central part of the frame
        JTextArea orderList = new JTextArea();

        //scroll pain
        JScrollPane scrollPane = new JScrollPane(orderList);
        orderList.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add the text area to the centre of the frame, under the top panel
        frame.add(scrollPane, BorderLayout.CENTER);

        // add a listener to the button
        btn.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){  
                // change text of text area
                orderList.append("Ice Cream + £1.51\n");
                orderTotal = orderTotal+price;
                String value = String.valueOf(orderTotal);
                label2.setText(value);
            }  
        });

        // add a listener to the button
        btn2.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){  
                // change text of text area
                orderList.append("Slushie + £2.00\n");
                orderTotal = orderTotal+slushprice;
                String value = String.valueOf(orderTotal);
                label2.setText(value);
            }  
        });

        // make frame visible
        frame.setVisible(true);

    }

    public static void main(String[] args){
        Main main = new Main();
        main.runGUI();
        
        //swag
        Product item = new Product();

        // create product
        item.setName("Strawberry Ice Cream");
        item.setPrice(2.99);
    }
}