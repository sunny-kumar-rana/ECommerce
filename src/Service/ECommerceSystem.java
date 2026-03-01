package Service;

import Core.*;

import java.util.ArrayList;
import java.util.List;

public class ECommerceSystem {
    List<User> users;
    List<Product> products;
    List<Order> orders;

    public void registerUser(User user){
        users.add(user);
    }
    private User findUser(int id){
        for(User u : users){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }
    public void login(String username, String password){
    }

    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
    public List<Product> searchProduct(String productName){
        List<Product> prods = new ArrayList<>();
        for(Product p : products){
            if(p.getName().equalsIgnoreCase(productName)){
                prods.add(p);
            }
        }
        return prods;
    }

    public void addToCart(int userId, Product product, int quantity){
        User user = findUser(userId);
        if (user != null) {
            user.getCart().addProduct(new CartItem(product,quantity));
        }
    }
    public void removeFromCart(int userId, Product product, int quantity){
        User user = findUser(userId);
        if (user != null) {
            user.getCart().removeProduct(new CartItem(product,quantity));
        }
    }

    public void placeOrder(int orderId, int userId){
        User user = findUser(userId);
        if (user != null) {
            orders.add(new Order(orderId, user, user.getCart()));
        }
    }
}
