package Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category {
    private final String name;
    HashMap<Object, Object> allItems;

    private float discountPercentage;
    private final List<Item> items = new ArrayList<>();

    Category(String categoryName) {
        name = categoryName;
    }

    public void setDiscountPercentage(float discount) {
        discountPercentage = discount;
    }

}
