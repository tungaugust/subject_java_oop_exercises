package main.module_four;

public class Laboratory extends UniversityRoom{
    private String major;
    private int capacity;
    private boolean sink;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0){
            capacity = 0;
        }
        this.capacity = capacity;
    }

    public boolean hasSink() {
        return sink;
    }

    public void setSink(boolean sink) {
        this.sink = sink;
    }

    public Laboratory(String roomCode, String buildingCode, double area, int lightCount, String major, int capacity, boolean sink) {
        super(roomCode, buildingCode, area, lightCount);
        this.setCapacity(capacity);
        this.setMajor(major);
        this.setSink(sink);
    }

    @Override
    public boolean isStandardRoom() {
        if (this.enoughLight() && this.hasSink()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String sinkStatus = this.hasSink() ? "Yes" : "No";
        return "Laboratory [" +
                "code=" + this.getRoomCode() +
                ", buidling=" + this.getBuildingCode() +
                ", area=" + this.getArea() +
                ", lightCount=" + this.getLightCount() +
                ", major=" + this.getMajor() +
                ", capacity=" + this.getCapacity() +
                ", sink=" + sinkStatus +
                "]";
    }
}
