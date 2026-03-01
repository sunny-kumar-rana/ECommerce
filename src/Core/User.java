package Core;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<Order> orders;
    private Cart cart;


    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public boolean verifyPassword(String password) {
        return password.equals(this.password);
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public Cart getCart(){
        return this.cart;
    }
    public List<Order> getOrders(){
        return this.orders;
    }
}
