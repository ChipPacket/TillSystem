public class Product {
    
    private String name;
    private double price;

    // initalise variables for product
    public Product(){
        name = "";
        price = 0.0;
    }

    public Product (String itemName, double itemPrice){
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
}
