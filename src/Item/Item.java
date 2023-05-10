/**
 * @auther Noor Eyad
 * Item class is responsible for creating new items and setting their attributes
 * @version 1.0
 * @since 2023-05-9
 */
package Item;

public class Item {
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

    /**
     * Item constructor to create new one
     *
     * @param name        : name of the item.
     * @param category    : category of the item.
     * @param description : description of the item (ex: ingredients).
     * @param brand       : brand of the item.
     * @param price       : price of the item.
     */
    Item(String name, String category, String description, String brand, int quantity, float price) {
        setName(name);
        setCategory(category);
        setDescription(description);
        setBrand(brand);
        setPrice(price);
        discountPercentage = 0;
        setQuantity(quantity);
        sales = 0;
        status = ItemStatus.NOT_ON_SALE;
        if (quantity == 0) {
            setStatus(ItemStatus.OUT_OF_STOCK);
        } else if (discountPercentage > 0) {
            setStatus(ItemStatus.ON_SALE);
        } else {
            setStatus(ItemStatus.NOT_ON_SALE);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * this function is responsible for getting the category of the item
     * @return category
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * this function is responsible for setting the category of the item
     * @param category : category of the item
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * this function is responsible for getting the description of the item
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * this function is responsible for setting the description of the item
     * @param description : description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * this function is responsible for getting the brand of the item
     * @return brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * this function is responsible for setting the brand of the item
     * @param brand : brand of the item
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * this function is responsible for getting the price of the item
     * @return price of the item
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * this function is responsible for setting the price of the item
     * @param price : price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * this function is responsible for getting the discount percentage of the item
     * @return discount percentage of the item
     */
    public float getDiscountPercentage() {
        return this.discountPercentage;
    }

    /**
     * this function is responsible for setting the discount percentage of the item
     * @param discount  : discount percentage of the item
     */
    public void setDiscountPercentage(float discount) {
        discountPercentage = discount;
    }

    /**
     * this function is responsible for getting the type of the item
     * @return type of the item
     */
    public Type getType() {
        return this.type;
    }

    /**
     * this function is responsible for setting the type of the item
     * @param type : type of the item
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * this function is responsible for getting the quantity of the item
     * @return quantity of the item
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * this function is responsible for setting the quantity of the item
     * @param quantity : quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * this function is responsible for getting the sales of the item
     * @return sales of the item
     */
    public int getSales() {
        return this.sales;
    }

    /**
     * this function is responsible for setting the sales of the item
     * @param sales : sales of the item
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * this function is responsible for getting the status of the item
     * @return status of the item
     */
    public ItemStatus getStatus() {
        return this.status;
    }

    /**
     * this function is responsible for setting the status of the item
     * @param status : status of the item
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
