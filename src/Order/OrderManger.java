package Order;

import Item.CatalogManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class OrderManger {

    private HashMap<Integer, Order> orders = new HashMap<>();
    private CatalogManager catalog ;

    private int orderId;

    public OrderManger(CatalogManager catalog){
        this.catalog = catalog;
    }


    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order creatOrder(int customerId){
        ++orderId;
        Order order = new Order(orderId, customerId);
        orders.put(orderId, order);
        return order;
    }

   public void checkOutOrder(){
        Order currentOrder = orders.get(orderId);
        if(currentOrder.getCart().size() == 0){
            System.out.println("CART IS EMPTY!");
            return;
        }
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

    public void uploadOrders(){
        try {
            FileWriter writer = new FileWriter("orders.txt");
            for(Map.Entry<Integer,Order > set : orders.entrySet()){
                writer.write(set.getValue() +"\n");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
