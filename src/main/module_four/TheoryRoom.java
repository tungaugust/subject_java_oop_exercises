package main.module_four;

public class TheoryRoom extends UniversityRoom{
    private boolean projector;

    public boolean hasProjector() {
        return projector;
    }

    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    public TheoryRoom(String roomCode, String buildingCode, double area, int lightCount, boolean projector) {
        super(roomCode, buildingCode, area, lightCount);
        this.setProjector(projector);
    }

    @Override
    public boolean isStandardRoom() {
        if (this.enoughLight() && this.hasProjector()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String projectorStatus = this.hasProjector() ? "Yes" : "No";
        return "TheoryRoom [" +
                "code=" + this.getRoomCode() +
                ", buidling=" + this.getBuildingCode() +
                ", area=" + this.getArea() +
                ", lightCount=" + this.getLightCount() +
                ", projector=" + projectorStatus +
                "]";
    }
}
