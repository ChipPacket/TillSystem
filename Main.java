/**
 * Main
 * 
 * @author 
 * @version beginning 10/07/26
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashSet;
import java.io.*;
public class Main {

    public HashSet<Product> getProductDataFromFile(){
        HashSet<Product> productList = new HashSet<Product>();
        
        // create file/buffer readers
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        // string to store read lines from file
        String nextLine;

        try{
            // create filereader, provide product list file
            fileReader = new FileReader("products.txt");
            
            //create buffered reader
            bufferedReader = new BufferedReader(fileReader); 
            
            //attempt to read first line of file
            nextLine = bufferedReader.readLine();
            
            // while the next line of data is valid (e.g. isn't 'null') 
            while (nextLine != null){
                // display the line of data read to the user
                System.out.println(nextLine);

                // split the line up
                String lineArray[] = nextLine.split(",");

                // convert data types
                double id = Double.parseDouble(lineArray[0]);
                double price = Double.parseDouble(lineArray[2]);
                Product newProduct = new Product(id, lineArray[1], price);

                // add it to hashset
                productList.add(newProduct);
                
                // attempt to read another line from the file
                nextLine = bufferedReader.readLine();
            } 
        }
        catch (FileNotFoundException e){
            System.out.println("Problem occurred, file not found.");
        }
        catch (IOException e){
            System.out.println("Problem occurred opening or reading from file.");
        }
        finally{
            if (bufferedReader != null){
                try{
                    // try to close it
                    bufferedReader.close();
                }
                catch (IOException e){
                    System.out.println("Problem occurred closing the file.");
                }
            }
        }

        return productList;
    }

    double orderTotal = 0;
    public void runGUI(Product products[]){

        // create frame
        JFrame frame = new JFrame("Till System!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        // create top panel for items to go on, items will be left aligned
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

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
                orderTotal = orderTotal+(products[0].getPrice());
                String value = String.valueOf(orderTotal);
                label2.setText(value);
            }  
        });

        // add a listener to the button
        btn2.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){  
                // change text of text area
                orderList.append("Slushie + £2.00\n");
                orderTotal = orderTotal+(products[1].getPrice());
                String value = String.valueOf(orderTotal);
                label2.setText(value);
            }  
        });

        // make frame visible
        frame.setVisible(true);

    }

    public static void main(String[] args){
        //initialise array of objects 'Product'
        /*
        Product products[] = new Product[2];
        products[0] = new Product("Ice Cream", 1.51);
        products[1] = new Product("Slushie", 2);
        */
        
        // run UI
        Main main = new Main();
        //main.runGUI(products);
        HashSet<Product> list = main.getProductDataFromFile();
        // STILL NEED TO CHECK DATA IS GETTING INTO HASHSET AND IS ACCESSABLE 
        for (int i = 0; i < list.size(); i++) {

        }
    }
}