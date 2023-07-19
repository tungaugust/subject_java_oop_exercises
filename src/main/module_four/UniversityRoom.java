package main.module_four;

public abstract class UniversityRoom {
    private String roomCode;
    private String buildingCode;
    private double area;
    private int lightCount;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getLightCount() {
        return lightCount;
    }

    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
    }

    public UniversityRoom(String roomCode, String buildingCode, double area, int lightCount) {
        this.setRoomCode(roomCode);
        this.setBuildingCode(buildingCode);
        this.setArea(area);
        this.setLightCount(lightCount);
    }

    public abstract boolean isStandardRoom();
    protected boolean enoughLight(){
        // 1 bong den cho 10 m^2
        int enoughLightCount = (int) Math.ceil(this.getArea()/ 10);
        if (enoughLightCount <= this.getLightCount()){
            return true;
        }
        return false;
    }
}
