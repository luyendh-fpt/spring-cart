package aptech.fpt.springcart.entity;

public class CartItem {

    private long productId;
    private String productName;
    private int quantity;
    private double unitPrice;

    public CartItem(Product product) {
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = 1;
        this.unitPrice = product.getPrice();
    }

    public CartItem(Product product, int quantity) {
        this.productId = product.getId();
        this.productName = product.getName();
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public CartItem() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}
