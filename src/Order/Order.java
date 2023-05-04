package Order;

import ShoppingCart.Cart;

public class Order {
    private Cart cart;
    private State state;
    public String id;

    public float finalCost(){
        return 20+ cart.getTotalCost();
    }

    public Cart getCart() {
        return cart;
    }

    public int gainedLoyaltyPts(){
        return (int) (finalCost()*0.2);
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
