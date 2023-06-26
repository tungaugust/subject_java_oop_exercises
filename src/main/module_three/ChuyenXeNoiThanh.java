package main.module_three;

public class ChuyenXeNoiThanh extends ChuyenXe {
    private int route;
    private int distance;

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ChuyenXeNoiThanh(String code, String driver, int vehicleNumber, double revenue, int route, int distance) {
        super(code, driver, vehicleNumber, revenue);
        this.route = route;
        this.distance = distance;
    }
}
