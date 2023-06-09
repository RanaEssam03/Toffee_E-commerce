/**
 * This file integrates the catalog with items and contains
 * all the functions related to Catalog control
 * @auther Noor Eyad
 * @version 1.0
 */

package Item;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CatalogManager {

    /**
     * this int represents the id of the item
     */
    private int itemID;

    /**
     * this HashMap contains the items in the catalog
     *
     * @see Item
     */
    private HashMap<Integer, Item> catalog = new HashMap<>();

    /**
     * Catalog manager Constructor  which sets initial value for items id
     */
    public CatalogManager() {
        itemID = 0;
    }

    /**
     * catalog getter
     *
     * @return the catalog of the items
     */
    public HashMap<Integer, Item> getCatalog() {
        return catalog;
    }

    /**
     * this function responsible for set catalog after loading it from the database
     *
     * @param catalog the catalog of the items
     */
    public void setCatalog(HashMap<Integer, Item> catalog) {
        this.catalog = catalog;
    }

    /**
     * this function update the catalog with new item
     *
     * @param name        item name
     * @param category    refers to the category of the item
     * @param description refers to the nutrition facts description of the item
     * @param brand       refers to the brand of the item
     * @param quantity    refers to the available quantity in the store
     * @param price       refers to the price of the item
     */
    public void updateCatalog(String name, String category, String description, String brand, int quantity, float price, Type type) {
        catalog.put(++itemID, new Item(name, category, description, brand, quantity, price, type));
    }

    /**
     * itemId getter
     *
     * @return the item id which set automatically by the system
     */
    public int getItemId() {
        return itemID;
    }

    /**
     * orderId setter
     *
     * @param orderId with set automatically by the system
     */
    public void setItemId(int orderId) {
        this.itemID = orderId;
    }

    /**
     * this function responsible for load the catalog from the database
     * or create a file with initial values if it does not exist
     *
     * @throws IOException
     */
    public void loadData() throws IOException {
        File file2 = new File("items.csv");
        try {
            HashMap<Integer, Item> cat = new HashMap<>();
            FileReader fileReader = new FileReader(file2);

            Scanner sc = new Scanner(new File(file2.toURI()));
            sc.useDelimiter(",");

            while (sc.hasNext()) {
                ArrayList<String> strings = new ArrayList<>();
                int x = 7;
                int y = 0;
                while (x != 0) {
                    String s = sc.next();
                    strings.add(s);
                    x--;
                }

                float price = Float.parseFloat(strings.get(strings.size() - 2));
                int quantity = Integer.parseInt(strings.get(strings.size() - 3));
                Type type;
                if(strings.get(6).equals("1")){
                    type = Type.LOOSE;
                }
                else{
                    type = Type.SEALED;
                }
                Item item = new Item(strings.get(0), strings.get(1), strings.get(2), strings.get(3), quantity, price, type);
                cat.put(++itemID, item);
            }


            setCatalog(cat);
        } catch (IOException e) {
            FileWriter outputfile = new FileWriter(file2);
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"1", "Lollipop", "Category2", "kids", "egyFood", "100","1"});
            data.add(new String[]{"2", "Lollipop", "Category2", "kids", "egyFood", "100","2"});
            data.add(new String[]{"2", "Lollipop", "Category2", "kids", "egyFood", "100","1"});
            writer.writeAll(data);
            writer.close();
            loadData();
        }
    }

    /**
     * this function is responsible for add a discount by category
     *
     * @param category : category that the discount will be applied on
     * @param discount : discount percentage
     */
    public void addDiscountToCategory(String category, float discount) {
        for (Map.Entry<Integer, Item> set : catalog.entrySet()) {
            if (set.getValue().getCategory().equals(category)) {
                set.getValue().setDiscountPercentage(discount);
                if (set.getValue().getQuantity() != 0) {
                    set.getValue().setStatus(ItemStatus.ON_SALE);
                }
                float price = set.getValue().getPrice();
                price = price - price * discount;
                set.getValue().setPrice(price);
            }
        }
    }

    /**
     * this function is responsible for delete an item by its id
     *
     * @param id : id of the item to be removed
     */
    public void deleteItem(Integer id) {
        catalog.remove(id);
    }

    /**
     * This function is responsible for check if the chosen quantity
     * of the user is accepted or not
     *
     * @param id       : id of the item
     * @param quantity : quantity of the item
     * @return 1 quantity available but not accepted,
     * 2 quantity available and accepted
     * 0 quantity not available and not accepted
     */
    public int checkQuantity(int id, int quantity) {
        if (quantity <= catalog.get(id).getQuantity()) {
            // if the quantity wanted is available
            // but is greater than 50
            if (quantity > 50) {
                return 1;
            } else {
                return 2;
            }
        }
        // if the quantity wanted is not available
        return catalog.get(id).getQuantity();
    }

    /**
     * this function decrease the available quantity after being taken by some user
     *
     * @param id    : id of the item
     * @param quant : quantity of the item
     */
    public void decreaseQuantity(int id, int quant) {
        int newQuantity = catalog.get(id).getQuantity();
        newQuantity -= quant;
        catalog.get(id).setQuantity(newQuantity);
    }


}