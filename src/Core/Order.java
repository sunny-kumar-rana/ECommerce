package Core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private List<CartItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;

    public Order(int id, User user, Cart cart) {
        this.orderId = id;
        this.user = user;
        this.items = cart.getCartItems();
        this.totalAmount = calculateTotal();
        this.orderDate = LocalDateTime.now();
    }

    private double calculateTotal(){
        double total = 0;
        for(CartItem item : items){
            total += item.subTotal();
        }
        return total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
