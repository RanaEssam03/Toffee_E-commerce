package Item;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;
    private float discountPercentage;
    private List<Item> items = new ArrayList<>();
    Category(String categoryName){
        name = categoryName;
    }
    public void setDiscountPercentage(float discount){
        discountPercentage = discount;
    }
}
