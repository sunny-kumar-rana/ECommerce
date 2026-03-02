package Service;

import Core.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECommerceSystem {
    List<User> users;
    List<Product> products;
    List<Order> orders;

    public ECommerceSystem(){
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        users.add(new User(0,"Superior","Superior@gmail.com","yoyo"));
    }


    // Users Methods
    public void registerUser(User user){
        users.add(user);
    }
    private User findUser(int id) throws IllegalAccessException {
        for(User u : users){
            if(u.getId() == id){
                return u;
            }
        }
        throw new IllegalAccessException("no such user Exists");
    }
    public User login(String username, String password) throws IllegalAccessException {
        User user = null;
        for(User u : users){
            if(u.getName().equalsIgnoreCase(username.trim()) && u.verifyPassword(password)){
                return user = u;
            }
        }
        throw new IllegalAccessException("Incorrect UserName/Password");
    }

    //Product Methods
    public boolean addProduct(User user, Product product){
        if(user.getId() == 0){
            products.add(product);
            return true;
        }
        return false;
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
    public Product searchProduct(int productId){
        Product prods = null;
        for(Product p : products){
            if(p.getId() == productId){
                prods = p;
                break;
            }
        }
        return prods;
    }
    public List<Product> getAllProducts(){
        return new ArrayList<Product>(products);
    }

    //Cart Operations
    public void addToCart(User user, Product product, int quantity) throws IllegalAccessException {
        if(!product.isAvailable(quantity)){
            throw new IllegalStateException("Not in Stock right now");
        }
        user.getCart().addProduct(new CartItem(product, quantity));
    }
    public void removeFromCart(User user, Product product, int quantity) throws IllegalAccessException {
        user.getCart().removeProduct(new CartItem(product, quantity));
    }
    public Cart viewCart(User user){
        return user.getCart();
    }

    //Order Placements
    public void placeOrder(int orderId, User user) throws IllegalAccessException {
        Cart cart = user.getCart();
        if(user.getCart().getCartItems().isEmpty()){
            throw new IllegalStateException("Cart is Empty");
        }
        for(CartItem ci : cart.getCartItems()){
            Product p = ci.getProduct();
            if (!p.isAvailable(ci.getQuantity())){
                throw new IllegalStateException("Not in Stock");
            }
        }
        for(CartItem ci : cart.getCartItems()){
            ci.getProduct().reduceStock(ci.getQuantity());
        }
        Order order = new Order(orderId, user, user.getCart());
        orders.add(order);
        user.addOrder(order);
        cart.clearCart();
        order.printOrder();
    }

    public void printOrders(User user) {
        user.getOrders().forEach(Order::printOrder);
    }
}
