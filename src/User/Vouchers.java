package User;

import java.util.HashMap;

public class Vouchers {
    HashMap<Integer, Float> vouchers;

    public HashMap<Integer, Float> getVouchers() {
        return vouchers;
    }

    public void setVouchers(HashMap<Integer, Float> vouchers) {
        this.vouchers = vouchers;
    }

    void addVoucher(int id, float percentage){
        vouchers.put(id, percentage);
    }

    float getDiscount(int id){
        return vouchers.get(id);
    }

    void useVoucher(int id){
       vouchers.remove(vouchers.get(id));
    }

    void decreasePercentage(int id, int percentage){
        if(percentage == vouchers.get(id)){
            useVoucher(id);
        }
        else if(percentage > vouchers.get(id)){
            vouchers.put(id,vouchers.get(id)- percentage);
        }
        else{
            System.out.println("invalid Voucher");
        }
    }
}
