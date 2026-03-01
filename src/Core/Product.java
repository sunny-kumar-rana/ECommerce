package Core;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantityAvailable;

    Product(int id, String name, double price, int quantityAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return price;
    }
    public String getName(){
        return this.name;
    }

    public void reduceStock(int quantity) {
        this.quantityAvailable -= quantity;
    }
    public void increaseStock(int quantity) {
        this.quantityAvailable += quantity;
    }
    public boolean isAvailable(int quantity) {
        return this.quantityAvailable <= quantity;
    }
}
