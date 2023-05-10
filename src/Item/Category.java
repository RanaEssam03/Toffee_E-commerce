/**
 * Category class Model
 * @auther Noor Eyad
 * @version 1.0
 * @since 2023-05-9
*/
package Item;

import java.util.ArrayList;
import java.util.List;

public class Category {

    /**
     * Category name
     */
    private final String name;
//    /**
//     * All items in this category
//     */
//    HashMap<Object, Object> allItems;
    //TODO: add all items in this category
    /**
     * Discount percentage
     */
    private float discountPercentage;
    /**
     * All items in this category
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Category constructor
     *
     * @param categoryName
     */
    Category(String categoryName) {
        name = categoryName;
    }

    /**
     * Category discount setter
     * @param discount
     */
    public void setDiscountPercentage(float discount) {
        discountPercentage = discount;
    }

}
