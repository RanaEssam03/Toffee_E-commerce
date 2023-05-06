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


//    public void addItem(Item item){
//        items.add(item);
//    }
//    public void displayCategoryList(){
//        for (Item item : items) {
//            System.out.println(item);
//        }
//    }
//    public void deleteItem(Item item){
//        items.removeIf(i -> i == item);
//    }
}
