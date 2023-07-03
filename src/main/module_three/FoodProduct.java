package main.module_three;

import java.time.LocalDate;

public class FoodProduct extends Product {
    // Hang thuc pham
    private String supplier;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        if (manufactureDate.isBefore(LocalDate.now())){
            manufactureDate = LocalDate.now();
        }
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(getManufactureDate())){
            expirationDate = getManufactureDate();
        }
        this.expirationDate = expirationDate;
    }

    public FoodProduct(String code, String name, double price, int storedQuantity, String supplier, LocalDate manufactureDate, LocalDate expirationDate) {
        super(code, name, price, storedQuantity);
        setSupplier(supplier);
        setManufactureDate(manufactureDate);
        setExpirationDate(expirationDate);
    }

    @Override
    public double vatTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String salesRating() {
        if (getExpirationDate().isAfter(LocalDate.now()) && getStoredQuantity() > 0) {
            return DIFF_SALE;
        }
        return NO_RATING;
    }


}
