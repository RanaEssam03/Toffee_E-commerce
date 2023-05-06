package Item;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private float discountPercentage;
    private ArrayList<Item> itemsInCategory = new ArrayList<Item>();
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    public float getDiscountPercentage() {
        return discountPercentage;
    }
    public void addItem(Item item){
        itemsInCategory.add(item);
    }
    public String deleteItem(Item item){
        for (int i=0; i < itemsInCategory.size(); i++){
            if (itemsInCategory.get(i) == item){
                itemsInCategory.remove(item);
                return "Item deleted";
            }
        }
        return "Item not found";
    }
}
