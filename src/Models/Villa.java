package Models;

public class Villa extends Services {
    private String standardRoom, ServiceOther;
    private double poolArea;
    private int Floor;

    public Villa() {
        super();

    }

    public Villa(String id,String serviceName, double areaRoom, double cost, int maxPersion, String rentalType, String standardRoom, String serviceOther, double poolArea, int floor) {
        super(serviceName, id, areaRoom, cost, maxPersion, rentalType);
        this.standardRoom = standardRoom;
        ServiceOther = serviceOther;
        this.poolArea = poolArea;
        Floor = floor;
    }


    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getServiceOther() {
        return ServiceOther;
    }

    public void setServiceOther(String serviceOther) {
        ServiceOther = serviceOther;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    @Override
    void showInfor() {

    }
}
