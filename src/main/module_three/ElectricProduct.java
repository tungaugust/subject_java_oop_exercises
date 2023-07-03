package main.module_three;

import java.time.LocalDate;

public class ElectricProduct extends Product{
    // Hang dien may
    private int warrantyTime; // Thoi gian bao hanh (thang)
    private int activePower; // Cong suat dien

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        if (warrantyTime < 0){
            warrantyTime = 0;
        }
        this.warrantyTime = warrantyTime;
    }

    public int getActivePower() {
        return activePower;
    }

    public void setActivePower(int activePower) {
        if (activePower < 0){
            activePower = 0;
        }
        this.activePower = activePower;
    }

    public ElectricProduct(String code, String name, double price, int storedQuantity, int warrantyTime, int activePower) {
        super(code, name, price, storedQuantity);
        setWarrantyTime(warrantyTime);
        setActivePower(activePower);
    }

    @Override
    public double vatTax() {
        return getPrice() * 0.1;
    }

    @Override
    public String salesRating() {
        if (getStoredQuantity() < 3) {
            return GOOD_SALE;
        }
        return NO_RATING;
    }
}
