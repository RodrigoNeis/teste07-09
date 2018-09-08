package vo;

/**
 * Created by rneis on 07/09/2018.
 */
public class SaleItem {
    private String itemId;
    private int quantity;
    private double price;

    public SaleItem(String itemId, int quantity, double price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SaleItem=[");
        sb.append("itemId=[").append(itemId).append("]");
        sb.append(", quantity=[").append(quantity).append("]");
        sb.append(", price=[").append(price).append("]");
        sb.append("]");
        return sb.toString();
    }
}
