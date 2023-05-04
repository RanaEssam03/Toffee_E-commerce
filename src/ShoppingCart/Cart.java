package ShoppingCart;
import java.util.ArrayList;

public class Cart {
//    private Boolean isPrePay;
    private float totalCost;
    private ArrayList<CartItem>  items;

//    public Boolean getPrePay() {
//        return isPrePay;
//    }
//
//    public void setPrePay(Boolean prePay) {
//        isPrePay = prePay;
//    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    void addItem(CartItem item){
        totalCost += item.getPrice()* item.getQuantity();

       for( int i = 0 ; i < items.size() ; i++){
           if(this.items.get(i).getName() == item.getName()){
               items.get(i).setQuantity(items.get(i).getQuantity()+item.getQuantity()); // check of the added item already in the cart
                    return;                                                             // then its quantity will be updated only
           }
       }
       items.add(item);
    }
}
