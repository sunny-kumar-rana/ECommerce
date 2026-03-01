package Execution;

import Core.CartItem;
import Core.Product;
import Core.User;
import Service.ECommerceSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ECommerceSystem ecs = new ECommerceSystem();
        Scanner sc = new Scanner(System.in);
        int userId = 101;
        final String menu = """
                        1 -> Register
                        2 -> Log-In
                        3 -> Add Product (Admin only)
                        4 -> View Products
                        5 -> Add to Cart
                        6 -> View Cart
                        7 -> Place Order
                        8 -> View Orders
                        9 -> Log-Out
                        0 -> EXIT
                        """;
        byte option;
        boolean running = true;
        User user = null;
        int orderId = 1000;

        while(running){
            System.out.println(menu);
            option = sc.nextByte(); sc.nextLine();
            switch (option){
                case 1 -> {
                    int id = ++userId;
                    System.out.println("Enter Name");
                    String name = sc.nextLine();
                    System.out.println("Enter Email Address");
                    String email = sc.nextLine();
                    System.out.println("Enter Password");
                    String password = sc.nextLine();
                    ecs.registerUser(new User(id, name, email, password));
                    System.out.println("User Registerd with User ID :- "+id);
                }
                case 2 -> {
                    System.out.println("Enter Username");
                    String userName = sc.nextLine();
                    System.out.println("Enter Password");
                    String password = sc.nextLine();
                    try{
                        user = ecs.login(userName, password);
                        System.out.println("Logged In");
                    } catch (IllegalAccessException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    if(user != null){
                        System.out.println("Enter Product ID");
                        int id = sc.nextInt();sc.nextLine();
                        System.out.println("Enter Product Name");
                        String name = sc.nextLine();
                        System.out.println("Enter Product Price");
                        double price = sc.nextDouble();
                        System.out.println("Enter Stock Quantity");
                        int quantity = sc.nextInt();sc.nextLine();
                        if(ecs.addProduct(user,new Product(id, name, price, quantity))){
                            System.out.println("Product Added <<");
                        }
                        else {
                            System.out.println("You're not The Admin!");
                        }
                    }
                    else{
                        System.out.println("You Need to Login First!!");
                    }
                }
                case 4 -> {
                    List<Product> allProducts = ecs.getAllProducts();
                    allProducts.forEach(product -> System.out.println(product));
                }
                case 5 -> {
                    if(user != null){
                        boolean goBack = false;
                        while(!goBack){
                            System.out.println("Enter Product name, mind the spelling..");
                            String pname = sc.nextLine();
                            List<Product> prod = ecs.searchProduct(pname);
                            if(prod.isEmpty()){
                                System.out.println("No such Products Available\n" +
                                        "Enter 'x' to go to the main menu or press enter to try again");
                                char input = sc.next().charAt(0);
                                if (input == 'x'){
                                    goBack = true;
                                }
                            } else {
                                prod.forEach(System.out::println);
                                System.out.println("Enter product id to confirm");
                                int pid = sc.nextByte();sc.nextLine();
                                Product p = ecs.searchProduct(pid);
                                System.out.println("Enter Quantity..");
                                int quantity = sc.nextInt();sc.nextLine();
                                try {
                                    ecs.addToCart(user, p, quantity);
                                    System.out.println("Item Added");
                                    goBack = true;
                                } catch (IllegalAccessException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("You Need to Login first!!");
                    }
                }
                case 6 -> {
                    if(user != null){
                        List<CartItem> cartItems = ecs.viewCart(user).getCartItems();
                        for(CartItem ci : cartItems){
                            System.out.println(ci);
                        }
                    } else {
                        System.out.println("You Need to Login first");
                    }
                }
                case 7 -> {
                    if (user == null){
                        System.out.println("You Need to Login first!");
                    }else {
                        try {
                            ecs.placeOrder(orderId, user);
                        } catch (IllegalAccessException e) {
                            System.out.println(e);
                        }
                    }
                }
                case 8 -> {
                    if(user != null){
                        ecs.printOrders(user);
                    } else {
                        System.out.println("You Need to Login first!");
                    }
                }
                case 9 -> {
                    user = null;
                    System.out.println("Logged Out");
                }
                case 0 -> {
                    System.out.println("Session Ended");
                    sc.close();
                    running = false;
                }
                default -> {
                    System.out.println("Invalid Option, select the right one");
                    System.out.println("-------------------------------------");
                    System.out.println();
                }
            }
        }
    }
}
