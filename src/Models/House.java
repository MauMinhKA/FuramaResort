package Models;

public class House extends Services {
    private String standardRoom, ServiceOther;
    private int Floor;

    public House() {
        super();
    }

    public House(String id,String serviceName,  double areaRoom, double cost, int maxPersion, String rentalType, String standardRoom, String serviceOther, int floor) {
        super(serviceName, id, areaRoom, cost, maxPersion, rentalType);
        this.standardRoom = standardRoom;
        ServiceOther = serviceOther;
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
