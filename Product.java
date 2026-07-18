public class Product {
    
    private double productID;
    private String name;
    private double price;

    // initalise variables for product
    public Product(){
        productID = 0.0;
        name = "";
        price = 0.0;
    }

    public Product (double newID, String itemName, double itemPrice){
        productID = newID;
        name = itemName;
        price = itemPrice;
    }

    // ### GET / SETS
    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }

    public double getID(){
        return productID;
    }

    public void setID(double newID){
        productID = newID;
    }
}
