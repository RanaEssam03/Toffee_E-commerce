package Item;

public class Item {
    /**
     * This is a static variable that increments
     * whenever a new object from class item is created
     */
    static Integer ID = 0;
    private String name;
    private Category category;
    private String description;
    private String brand;
    private float price;
    private float discountPercentage;
    private Type type;
    private int quantity;
    private int sales;
    private ItemStatus status;
    /**
     *
     * @param name : name of the item.
     * @param category : category of the item.
     * @param description : description of the item (ex: ingredients).
     * @param brand : brand of the item.
     * @param price : price of the item.
     * @param type : type of the item (ex: loose or solid).
     * @param quantity : available quantity of the item.
     */
    Item(String name, Category category, String description, String brand, float price, Type type, int quantity){
        setName(name);
        setCategory(category);
        setDescription(description);
        setBrand(brand);
        setPrice(price);
        discountPercentage = 0;
        setType(type);
        setQuantity(quantity);
        sales = 0;
        status = ItemStatus.NOT_ON_SALE;
    }
    /**
     *
     * @param name : name of the item
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     *
     * @return String
     */
    public String getName(){
        return this.name;
    }
    /**
     *
     * @param category : category of the item
     */
    public void setCategory(Category category){
        this.category = category;
    }
    /**
     *
     * @return Category
     */
    public Category getCategory(){
        return this.category;
    }
    /**
     *
     * @param description : description of the item (ex: ingredients)
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *
     * @return String
     */
    public String getDescription(){
        return this.description;
    }
    /**
     *
     * @param brand : brand of the item
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     *
     * @return String
     */
    public String getBrand(){
        return this.brand;
    }
    /**
     *
     * @param price : price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }
    /**
     *
     * @return float
     */
    public float getPrice(){
        return this.price;
    }
    /**
     *
     * @param discount : discount set on an item
     */
    public void setDiscountPercentage(float discount) {
        discountPercentage = discount;
    }
    /**
     *
     * @return float
     */
    public float getDiscountPercentage(){
        return this.discountPercentage;
    }
    /**
     *
     * @param type : type of the item (ex: loose or solid)
     */
    public void setType(Type type){
        this.type = type;
    }
    /**
     *
     * @return Type
     */
    public Type getType(){
        return this.type;
    }
    /**
     *
     * @param quantity : available quantity of the item
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     *
     * @return int
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     *
     * @param sales : quantity sold of that item
     */
    public void setSales(int sales){
        this.sales = sales;
    }
    /**
     *
     * @return int
     */
    public int getSales(){
        return this.sales;
    }
    /**
     *
     * @param status : status of the item (ex: out of stock, on sale or not on sale)
     */
    public void setStatus(ItemStatus status){
        this.status = status;
    }
    /**
     *
     * @return ItemStatus
     */
    public ItemStatus getStatus(){
        return this.status;
    }
}
