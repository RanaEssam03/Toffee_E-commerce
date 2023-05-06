package Item;

import java.util.HashMap;
import java.util.Map;

public class CatalogManager {
    /**
     * hashmap of all items available in the store
     */
    private HashMap<Integer, Item> allItems = new HashMap<Integer, Item>();

    /**
     *
     * @param id : id of the item
     * @param item : item to be added in the hashmap
     */
    public void addItem(Integer id, Item item){
        allItems.put(id, item);
    }

    /**
     * display all items in the catalog
     */
    public void displayCatalog(){
        for (Map.Entry<Integer, Item> entry : allItems.entrySet()){
            System.out.println(entry.getKey() + ")" + entry.getValue());
        }
    }

    /**
     *
     * @param id : id of the item to be removed
     */
    public void deleteItem(Integer id){
        allItems.remove(id);
    }

    /**
     *
     * @param category : category that the discount will be applied on
     * @param discount : discount percentage
     */
    public void addDiscountToCategory(Category category, float discount){
        for (Map.Entry<Integer, Item> set : allItems.entrySet()){
            if (set.getValue().getCategory() == category){
                set.getValue().setDiscountPercentage(discount);
                if (set.getValue().getQuantity() != 0){
                    set.getValue().setStatus(ItemStatus.ON_SALE);
                }
                float price = set.getValue().getPrice();
                price = price - price*discount;
                set.getValue().setPrice(price);
            }
        }
    }
}
