package Core;

public class CartItem {
    private Product product;
    private int quantity;

    public Product getProduct(){
        return this.product;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double subTotal() {
        return product.getPrice() * quantity;
    }
    @Override
    public String toString(){
        return "qty : "+quantity+" >> "+product.toString();
    }
}
