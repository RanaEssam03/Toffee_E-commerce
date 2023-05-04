package Order;
import Item.*;


import java.util.HashMap;
import java.util.Scanner;


public class OrderManger {

    private HashMap<Integer, Order> orders;

    private HashMap<String, Item> catalog;

    private int orderId;

    public void updateCatalog(String code, String name, float unitPrice, Category category, String description , String brand){
        catalog.put(code, new Item(name, category, description, brand, unitPrice));
    }

    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    public HashMap<String, Item> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<String, Item> catalog) {
        this.catalog = catalog;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void creatOrder(int customerId){
        ++orderId;
        Order order = new Order(orderId, customerId);
        orders.put(orderId, order);
    }

    void checkOutOrder(){
        Order currentOrder = orders.get(orderId);
        System.out.println("Please enter Your Address");
        Scanner myObj = new Scanner(System.in);
        currentOrder.setAddress( myObj.nextLine());
        System.out.println("Total = " + currentOrder.getTotalCost());
        boolean flag = true;
        System.out.println("Confirm Order?\n 1.No\n2.Yes");
        int option = myObj.nextInt();
        if(option == 1){
            currentOrder.setState ( State.outForDelivery);
        }
        orders.put(orderId, currentOrder);
    }

}
