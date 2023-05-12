/**
 * CartItem class
 * This class is used to store the item and quantity of the item in the cart
 * @auther Rana Essam
 * @version 1.0
 * @since 2021-05-09
 * @see Item
 * @see Order
 */

package Order;

import Item.Item;

public class CartItem {

    /**
     * Quantity of the item
     */
    private int quantity;
    /**
     * Item object
     */
    private Item item;
    /**
     * CartItem constructor
     * @param item
     * @param quantity
     */
    CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Getter for item
     * @return item
     */
    public Item getItem() {
        return item;
    }
    /**
     * Setter for item : set the item
     * @param item : item to be set
     */
    public void setItem(Item item) {
        this.item = item;
    }
    /**
     * Getter for quantity of the item
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Setter for quantity
     * @param quantity : quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Item: " + item.getName() + " Quantity: " + quantity;
    }
}
