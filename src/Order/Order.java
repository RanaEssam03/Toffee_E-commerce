package Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Item.*;

public class Order {

    ArrayList<CartItem>cart = new ArrayList<>();
    private State state;
    public int id;

    private float totalCost;
    private int quantity;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Order(int id, int customerId){
        this.id = id;
        quantity=0;
        totalCost=0;
        state = State.inProgress;
        this.customerId = customerId;

    }
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    public void setCart(ArrayList<CartItem> cart) {
        this.cart = cart;
    }


    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void addToCart(int quantity, Item item ){
        totalCost += quantity* item.getPrice();
        this.quantity += quantity;
        cart.add(new CartItem(item, quantity));
    }

    public int getGainedLoyaltyPts(){
        return (int) (totalCost* 0.2);
    }


}
