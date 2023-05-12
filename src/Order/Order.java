/**
 * Order class that represents an order made by a customer.
 * It contains the id of the order, the list of items ordered, the total cost of the order,
 * the state of the order, the address to which the order will be delivered,
 * and the id of the customer who made the order.
 *
 * @auther Rana Essam
 * @version 1.0
 * @since 2021-05-09
 */


package Order;

import Item.Item;
import User.Address;

import java.util.ArrayList;

public class Order {
    /**
     *  This array list contains the items in the cart
     *  @see CartItem
     *  @see Item
     */
    ArrayList<CartItem> cart = new ArrayList<>();
    /**
     *  This enum represents the state of the order
     *  @see State
     */
    private State state;
    /**
     *  This int represents the id of the order
     */
    private int id;
    /**
     *  This float represents the total cost of the order
     */
    private float totalCost;
    /**
     *  This int represents the quantity of the order
     */
    private int quantity;
    /**
     *  This string represents the address to which the order will be delivered
     */
    private Address address;
    /**
     *  This int represents the id of the customer who made the order
     */
    private int customerId;

    /**
     * Order constructor that takes the id of the order
     * and the id of the customer who made the order
     * @param id: id of the order
     * @param customerId : id of the customer who made the order
     */
    public Order(int id, int customerId) {
        this.id = id;
        quantity = 0;
        totalCost = 0;
        state = State.inProgress;
        this.customerId = customerId;

    }

    /**
     * Getter for address
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for address
     * @param address : address to which the order will be delivered
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for customerId
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Setter for customerId
     * @param customerId : id of the customer who made the order
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter for cart
     * @return cart
     */
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    /**
     * Setter for cart
     * @param cart : array list of items in the cart
     */
    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }

    /**
     * Getter for totalCost
     * @return totalCost
     */
    public float getTotalCost() {
        return totalCost + 20;
    }

    /**
     * Setter for totalCost
     * @param totalCost : total cost of the order
     */
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Getter for quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for state
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     * Setter for state
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Getter for id
     * @return id
     */
    public int getId() {
        return id;

    }

    /**
     * Setter for id
     * @param id
     */
    public void setId(int id) {

        this.id = id;
    }

    /**
     * This method adds an item to the cart
     * @param quantity
     * @param item
     */
    public void addToCart(int quantity, Item item) {
        totalCost += quantity * item.getPrice();
        this.quantity += quantity;
        cart.add(new CartItem(item, quantity));
    }

    /**
     * This method to get the loyalty points gained from the order
     * @return loyalty points
     */
    public int getGainedLoyaltyPts() {

        return (int) (totalCost * 0.2);
    }

    /**
     * This method to stringify the order
     * @return string of the order
     */
    public String toString() {
        return id + "," + cart.toString() + "," + this.totalCost + "," + this.state + ","
                + this.address + "," + this.customerId + "\nTotal= "+ getTotalCost();

    }
}
