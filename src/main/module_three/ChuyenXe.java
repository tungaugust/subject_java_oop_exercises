package main.module_three;

public class ChuyenXe {
    protected String code;
    protected String driver;
    protected int vehicleNumber;
    protected double revenue;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public ChuyenXe(String code, String driver, int vehicleNumber, double revenue) {
        this.code = code;
        this.driver = driver;
        this.vehicleNumber = vehicleNumber;
        this.revenue = revenue;
    }
}

