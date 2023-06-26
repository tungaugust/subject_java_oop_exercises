package main.module_three;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
    private String destination;
    private int days;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public ChuyenXeNgoaiThanh(String code, String driver, int vehicleNumber, double revenue, String destination, int days) {
        super(code, driver, vehicleNumber, revenue);
        this.destination = destination;
        this.days = days;
    }
}
