package Item;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CatalogManager {
    private HashMap<Integer, Item> catalog = new HashMap<>();
    private int itemID;
    public CatalogManager(){
        itemID=0;
    }
    public void updateCatalog(String name, String category, String description, String brand, int quantity, float price){
        catalog.put(++itemID, new Item(name, category, description, brand,quantity, price));
    }
    public void viewCatalog(){
        System.out.println("    -> 0. main menu <-");
        for(Map.Entry<Integer, Item> set : catalog.entrySet()){
            System.out.print(set.getKey() + "." + set.getValue().getName() + " " + set.getValue().getPrice() + " "
                    + set.getValue().getQuantity() + " "+ set.getValue().getBrand());
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
    public int getItemId() {
        return itemID;
    }
    public void setItemId(int orderId) {
        this.itemID = orderId;
    }
    /**
     *
     * @param file : csv file that the data will be read from
     */
    public void loadData(String file){
        try {
            HashMap<Integer, Item> cat = new HashMap<>();
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                ArrayList<String> strings = new ArrayList<>();
                Collections.addAll(strings, nextRecord);
                int id = Integer.parseInt(strings.get(0));
                float price = Float.parseFloat(strings.get(strings.size()-1));
                int quantity = Integer.parseInt(strings.get(strings.size()-2));
                Item item = new Item(strings.get(1), strings.get(2), strings.get(3), strings.get(4), quantity, price);
                cat.put(id, item);
            }
            setCatalog(cat);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     *
     * @param category : category that the discount will be applied on
     * @param discount : discount percentage
     */
    public void addDiscountToCategory(String category, float discount){
        for (Map.Entry<Integer, Item> set : catalog.entrySet()){
            if (set.getValue().getCategory().equals(category)){
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
    public int checkQuantity(int id, int quantity){
        if (quantity > catalog.get(id).getQuantity()){
            // if the quantity wanted is available
            // but is greater than 50
            if (quantity > 50){
                return 1;
            }
            else{
                return 2;
            }
        }
        // if the quantity wanted is not available
        return catalog.get(id).getQuantity();
    }
//    public static void generateCsvFile(String fileName, HashMap<Integer, Item> cat){
//        try{
//            FileWriter writer = new FileWriter(fileName);
//            for (Map.Entry<Integer, Item> set: cat.entrySet()){
//
//            }
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    //lazem a7awel kol el 7agat eli fe el hashmap le strings 3shan a3rf a overwrite
}
