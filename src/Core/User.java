package Core;

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
        this.cart = new Cart();
    }

    public int getId(){
        return this.id;
    }
    public boolean verifyPassword(String password) {
        return password.equals(this.password);
    }

    public void addOrder(){

    }

    public Cart getCart(){
        return this.cart;
    }
}
