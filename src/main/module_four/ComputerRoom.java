package main.module_four;

public class ComputerRoom extends UniversityRoom{
    private int computerCount;

    public int getComputerCount() {
        return computerCount;
    }

    public void setComputerCount(int computerCount) {
        this.computerCount = computerCount;
    }

    public ComputerRoom(String roomCode, String buildingCode, double area, int lightCount, int computerCount) {
        super(roomCode, buildingCode, area, lightCount);
        this.setComputerCount(computerCount);
    }

    @Override
    public boolean isStandardRoom() {
        // 1.5 m^2 dat mot may tinh
        int enoughComputerCount = (int) Math.ceil(this.getArea()/ 1.5);
        if (this.enoughLight() && enoughComputerCount <= this.getComputerCount()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ComputerRoom [" +
                "code=" + this.getRoomCode() +
                ", buidling=" + this.getBuildingCode() +
                ", area=" + this.getArea() +
                ", lightCount=" + this.getLightCount() +
                ", computerCount=" + this.getComputerCount() +
                "]";
    }
}
