package main.module_two;

import java.text.DecimalFormat;

public class OrderDetail {
    private int quatity;
    private Product product;

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public OrderDetail(Product product, int quatity) {
        this.quatity = quatity;
        this.product = product;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        String fprice = df.format(calcTotalPrice()) + " VND" ;
        return String.format("%s | %15d | %20s", this.product, getQuatity(), fprice);
    }

    public double calcTotalPrice(){
        return getQuatity() * this.product.getPrice();
    }

}
