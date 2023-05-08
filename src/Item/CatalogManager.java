package Item;


import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
    public void loadData(String file) throws IOException {
        File file2 = new File("items.csv");
        try {
            HashMap<Integer, Item> cat = new HashMap<>();
            FileReader fileReader = new FileReader(file2);

            Scanner sc = new Scanner(new File(file2.toURI()));
            sc.useDelimiter(",");
//            CSVReader csvReader = new CSVReader(fileReader, ',');
//            System.out.print(sc.next());
            String[] nextRecord;
            while (sc.hasNext()){
                ArrayList<String> strings = new ArrayList<>();
                int x = 6;
                int y = 0;
                while(x!=0){
                    String s = sc.next();
                    ((ArrayList<String>) strings).add(s);
                    x--;
                }

                float price = Float.parseFloat(strings.get(strings.size()-1));
                int quantity = Integer.parseInt(strings.get(strings.size()-2));
                    Item item = new Item(strings.get(0), strings.get(1), strings.get(2), strings.get(3), quantity, price);
                cat.put(++itemID, item);
            }


            setCatalog(cat);
        }
        catch (IOException e) {
            FileWriter outputfile = new FileWriter(file2);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<String[]>();
//            catalogManager.updateCatalog("cotton candy","Category1", "kids", "egyFood" );
//            catalogManager.updateCatalog("Lollipop", "Category2", "kids","egyFood");
            data.add(new String[] {"1","Lollipop", "Category2", "kids","egyFood" , "100" });
            data.add(new String[]{"2","Lollipop", "Category2", "kids","egyFood" , "100" });
            data.add(new String[] { "2","Lollipop", "Category2", "kids","egyFood" , "100" });
            writer.writeAll(data);
            writer.close();

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
        if (quantity <= catalog.get(id).getQuantity()){
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
    public void decreaseQuantity(int id, int quant){
        int newQuantity = catalog.get(id).getQuantity();
        newQuantity -= quant;
        catalog.get(id).setQuantity(newQuantity);
    }


    // TODO overwrite function
    //
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


//                Collections.addAll(strings, nextRecord);
//                int id = Integer.parseInt(strings.get(0));

