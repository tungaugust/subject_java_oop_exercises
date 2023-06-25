package main.module_two;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private ArrayList<OrderDetail> lineItems;
    private int count;

    public int getOrderID() {
        return orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public ArrayList<OrderDetail> getLineItems() {
        return lineItems;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.lineItems = new ArrayList<OrderDetail>();
        this.count = 0;
    }
    public void addLineItem(Product p, int q){
        this.lineItems.add(new OrderDetail(p, q));
        this.count += 1;
    }
    public double calcTotalCharge(){
        double charge = 0.0;
        for (OrderDetail od: getLineItems()){
            charge += od.calcTotalPrice();
        }
        return charge;
    }

    public static String headerLine(){
        return String.format("%-5s | %-10s | %-20s | %15s | %15s | %20s"
                , "STT", "MA SP", "MO TA", "DON GIA", "SO LUONG", "THANH TIEN"
        );
    }

    @Override
    public String toString() {
        String result = "";
        String order = "";
        ArrayList<OrderDetail> lineItems = getLineItems();
        for(int i = 0; i < this.count - 1; i++){
            order = String.format("%-5d | ", i + 1);
            result += (order + lineItems.get(i) + "\n");
        }
        order = String.format("%-5d | ", this.count);
        result += (order + lineItems.get(this.count - 1));
        return result;

//        return "Order{" +
//                "orderID=" + orderID +
//                ", orderDate=" + orderDate +
//                ", lineItems=" + lineItems +
//                ", count=" + count +
//                '}';
    }
}
