package main.module_two;

import java.text.DecimalFormat;

public class Product {
    private String productID;
    private String description;
    private double price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if (productID.equals("")){
            productID = "XXXXXX";
        }
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            price = 0.0;
        }
        this.price = price;
    }

    public Product(){
        this.description = "";
        this.productID = "XXXXXX";
        this.price = 0.0;
    }

    public Product(String productID, String description, double price) {
        setProductID(productID);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0");
        String fprice = df.format(this.price) ;
        return String.format("%-10s | %-20s | %15s", getProductID(), getDescription(), fprice);
    }
}
