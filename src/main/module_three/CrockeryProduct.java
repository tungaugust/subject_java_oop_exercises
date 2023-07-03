package main.module_three;

import java.time.LocalDate;

public class CrockeryProduct extends Product{
    // Hang sanh su
    private String manufacturer;
    private LocalDate warehouseDate;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(LocalDate warehouseDate) {
        if (warehouseDate.isAfter(LocalDate.now())){
            warehouseDate = LocalDate.now();
        }
        this.warehouseDate = warehouseDate;
    }

    public CrockeryProduct(String code, String name, double price, int storedQuantity, String manufacturer, LocalDate warehouseDate) {
        super(code, name, price, storedQuantity);
        setManufacturer(manufacturer);
        setWarehouseDate(warehouseDate);
    }

    @Override
    public double vatTax() {
        return getPrice() * 0.1;
    }

    @Override
    public String salesRating() {
        if (getWarehouseDate().plusDays(10).isAfter(LocalDate.now()) && getStoredQuantity() > 50) {
            return SLOW_SALE;
        }
        return NO_RATING;
    }
}
