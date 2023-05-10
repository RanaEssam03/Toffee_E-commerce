/**
 * OrderManger class is responsible for managing the orders of the users and
 * the cart of each user and the checkout process of the order and the payment
 * process of the order and the delivery process of the order and the canceling
 * process of the order
 *
 * @auther Rana Essam
 * @version 1.0
 * @see Order
 * @since 2021-05-09
 */
package Order;

import Item.CatalogManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class OrderManger {
    /**
     * This int represents the id of the order
     */
    private final CatalogManager catalog;
    /**
     * This HashMap contains the orders of the users
     * @see Order
     */
    private HashMap<Integer, Order> orders = new HashMap<>();
    /**
     * This int represents the id of the order
     */
    private static int orderId;

    /**
     * OrderManger constructor that takes the catalog manager
     * @param catalog
     */
    public OrderManger(CatalogManager catalog) {
        this.catalog = catalog;
    }

    /**
     * Getter for orders
     * @return orders
     */
    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    /**
     * Setter for orders
     * @param orders
     */
    public void setOrders(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    /**
     * Getter for the order id
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Setter for the order id
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * This method is responsible for creating an order
     * @param customerId : id of the customer who made the order
     * @return order : the order that was created
     */
    public Order creatOrder(int customerId) {
        ++orderId;
        Order order = new Order(orderId, customerId);
        orders.put(orderId, order);
        return order;
    }

    /**
     * This method is responsible for checking out the order and the payment process
     * and the delivery process
     * @throws IOException
     */
    public void checkOutOrder() throws IOException {
        Order currentOrder = orders.get(orderId);
        if (currentOrder== null) {
            System.out.println("CART IS EMPTY!");
            return;
        }
        System.out.println("Please enter Your Address");
        Scanner myObj = new Scanner(System.in);
        currentOrder.setAddress(myObj.nextLine());
        System.out.println("Total = " + currentOrder.getTotalCost());
        boolean flag = true;
        System.out.println("Confirm Order?\n 1.No\n2.Yes");
        int option = myObj.nextInt();
        if (option == 1) {
            currentOrder.setState(State.outForDelivery);
            uploadOrders();
        }
        orders.put(orderId, currentOrder);
    }

    /**
     * This method is responsible for uploading the orders to the file
     * @throws IOException : if the file is not found
     */
    public void uploadOrders() throws IOException {

        File file = new File("orders.txt");
        file.delete();

        FileWriter outputFile = new FileWriter("order.txt");
        int x = 0;


        for (Map.Entry<Integer, Order> set : orders.entrySet()) {

            outputFile.write(set.getValue() + "\n");

        }
        outputFile.close();

    }

}
