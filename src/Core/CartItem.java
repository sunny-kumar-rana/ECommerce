package Core;

public class CartItem {
    private Product product;
    private int quantity;

    public Product getProduct(){
        return this.product;
    }
    public CartItem(Product product, int quantity) {
        this.product = product;
    }

    public double subTotal() {
        return product.getPrice() * quantity;
    }
}
