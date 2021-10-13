package hoHoangVanAnh.bai12;

import java.text.DecimalFormat;

public class Product {
    private String description;
    private String productID;
    private double price;

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param description
     * @param productID
     * @param price
     */
    public Product(String description, String productID, double price) {
        this.description = description;
        this.productID = productID;
        this.price = price;
    }

    /**
     * 
     */
    public Product() {
        this("", "", 0);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        return String.format("%-10s| %-20s| %10s", productID, description, df.format(price));
    }
}
