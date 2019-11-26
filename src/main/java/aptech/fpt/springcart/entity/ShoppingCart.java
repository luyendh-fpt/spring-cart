package aptech.fpt.springcart.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {

    private HashMap<Long, CartItem> items;
    private double totalPrice;

    public ShoppingCart() {
        this.items = new HashMap<>();
        this.totalPrice = 0;
    }

    public List<CartItem> getItems() {
        if (items == null) {
            items = new HashMap<>();
        }
        return new ArrayList<>(items.values());
    }

    public void setItems(HashMap<Long, CartItem> items) {
        this.items = items;
    }

    public void removeProduct(long productId) {
        if (items == null) {
            return;
        }
        if (items.containsKey(productId)) {
            items.remove(productId);
        }
    }

    public void addProduct(Product product, int quantity) {
        if (items == null) {
            items = new HashMap<>();
        }
        CartItem item = new CartItem(product, quantity);
        if (items.containsKey(product.getId())) {
            CartItem existItem = items.get(product.getId());
            item.addQuantity(existItem.getQuantity());
        }
        items.put(product.getId(), item);
    }

    public double getTotalPrice() {
        this.totalPrice = 0;
        for (CartItem item :
                items.values()) {
            this.totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
