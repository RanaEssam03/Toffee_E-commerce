package ShoppingCart;

import Item.Item;
import Item.Category;
import Item.Type;

public class CartItem extends Item {
    private String id;
    private int quantity;

    CartItem(String name, Category category, String description, String brand, float price, Type type, int quantity, String id){
        super(name, category, description, brand, price,type);
        this.id = id;
        this.quantity = quantity;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
