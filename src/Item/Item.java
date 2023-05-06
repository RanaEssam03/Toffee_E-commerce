package Item;

public class Item {
    static int ID = 0;
    private String name;
    private String category;
    private String description;
    private String brand;
    private float price;
    private float discountPercentage;
    private Type type;
    private int quantity;
    private int sales;
    private ItemStatus status;
    public Item(String name, String category, String description, String brand, float price){
        setName(name);
        setCategory(category);
        setDescription(description);
        setBrand(brand);
        setPrice(price);
        discountPercentage = 0;
        setType(Type.LOOSE);
        setQuantity(quantity);
        sales = 0;
        status = ItemStatus.NOT_ON_SALE;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return this.category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand(){
        return this.brand;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice(){
        return this.price;
    }
    public void setDiscountPercentage(float discount) {
        discountPercentage = discount;
    }
    public float getDiscountPercentage(){
        return this.discountPercentage;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setSales(int sales){
        this.sales = sales;
    }
    public int getSales(){
        return this.sales;
    }
    public void setStatus(ItemStatus status){
        this.status = status;
    }
    public ItemStatus getStatus(){
        return this.status;
    }
}
