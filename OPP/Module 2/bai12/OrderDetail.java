package hoHoangVanAnh.bai12;

import java.text.DecimalFormat;

public class OrderDetail {
    private int quantity;
    private Product product;

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        if (quantity > 20)
            quantity = 20;
        this.quantity = quantity;
    }

    /**
     * @param quantity
     * @param product
     */
    public OrderDetail(Product product, int quantity) {
        setQuantity(quantity);
        this.product = product;
    }

    public double calcTotalPrice() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0 VND");
        return String.format("%s| %-10d| %-10s", product, quantity, df.format(calcTotalPrice()));
    }
}