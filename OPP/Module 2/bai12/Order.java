package hoHoangVanAnh.bai12;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private OrderDetail[] lineItem;
    private int count;

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param lineItem the lineItem to set
     */
    public void setLineItem(OrderDetail[] lineItem) {
        this.lineItem = lineItem;
    }

    /**
     * @return the orderDate
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @param orderID
     * @param orderDate
     */
    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        count = 0;
        lineItem = new OrderDetail[20];
    }

    public void Order(int orderID2, LocalDate of) {
	}

	public void addLineItem(Product p, int x) {
        if (count > 20) {
            System.out.println("Hóa đơn đã quá 20 mặt hàng");
            return;
        }
        lineItem[count] = new OrderDetail(p, x);
        count++;
    }

    public double calcTotalCharge() {
        double tien = 0;
        for (int i = 0; i < count; i++) {
            tien += lineItem[i].calcTotalPrice();
        }
        return tien;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0 VND");
        System.out.println("Mã HD: " + orderID);
        System.out.println("Ngày lập hóa đơn: " + dtf.format(orderDate));
        System.out.printf("%-4s| %-10s| %-20s| %10s| %-10s| %-10s\n", "STT", "Mã SP", "Mô tả", "Đơn Giá", "Số Lượng",
                "Thành Tiền");
        String dsItem = "";
        String temp;
        for (int i = 0; i < count; i++) {
            if (i < 10)
                temp = " ";
            else
                temp = "";
            dsItem += " " + temp + (i + 1) + " | " + lineItem[i] + "\n";
        }
        return String.format("%s\nTổng tiền thanh toán: %s", dsItem, df.format(calcTotalCharge()));
    }
}