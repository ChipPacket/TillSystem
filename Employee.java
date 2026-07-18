import java.util.HashSet;
public class Employee {
    private String name;
    private boolean isManager;
    private HashSet<Product> order = new HashSet<Product>(); // might make this integer instead - product id?

    public Employee(String newName, boolean newManager){
        name = newName;
        isManager = newManager;
    }

    public Employee(){
        name = "";
        isManager = false;
    }

    // get/sets
    public void setEmployeeName(String newName){
        name = newName;
    }

    public String getEmployeeName(){
        return name;
    }

    public void setManagerStatus(boolean newManager){
        isManager = newManager;
    }

    public boolean getManagerStatus(){
        return isManager;
    }

    public HashSet<Product> getOrder(){
        return order;
    }

    // add product to order
    public void addProductToOrder(Product newProduct){
        order.add(newProduct);
    }

    // delete product from order
    public void deleteProductFromOrder(Product deletedProduct){
        // would want to change this so that its a bit more complicated since it needs to know what item to delete first
        order.remove(deletedProduct);
    }
}
