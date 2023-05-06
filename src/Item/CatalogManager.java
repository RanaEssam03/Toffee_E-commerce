package Item;

import java.util.HashMap;
import java.util.Map;

public class CatalogManager {
    private HashMap<Integer, Item> catalog = new HashMap<>();
    private int orderId;
    public CatalogManager(){
        orderId=0;
    }

    public void updateCatalog( String name, float unitPrice,String  category, String description , String brand){
        catalog.put(++orderId, new Item(name, category, description, brand, unitPrice));
    }

    public void viewCatalog(){
        //TODO view available quantity
        System.out.println("    -> 0. main menu <-");

        for(Map.Entry<Integer, Item> set : catalog.entrySet()){
            System.out.print(set.getKey() + "." + set.getValue().getName() + " " + set.getValue().getPrice() + " "+ set.getValue().getBrand());
            System.out.println();
        }

        System.out.println("_________________________________________________");


    }

    public HashMap<Integer, Item> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<Integer, Item> catalog) {
        this.catalog = catalog;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void loadData(){
        //TODO implement function loadData
    }


    /**
     *
     * @param category : category that the discount will be applied on
     * @param discount : discount percentage
     */

    public void addDiscountToCategory(String category, float discount){
        for (Map.Entry<Integer, Item> set : catalog.entrySet()){
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
    /**
     *
     * @param id : id of the item to be removed
     */
    public void deleteItem(Integer id){
        catalog.remove(id);
    }


}
