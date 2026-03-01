package Core;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getCartItems(){
        return this.items;
    }
    public void addProduct(CartItem item) {
        items.add(item);
    }
    public void removeProduct(CartItem item) {
        for(CartItem ci : items){
            if(ci.getProduct().getId() == item.getProduct().getId()){
                items.remove(ci);
            }
        }
    }

    public double calculateTotal(){
        double total = 0;
        for (CartItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public void clearCart(){
        items.clear();
    }
}
