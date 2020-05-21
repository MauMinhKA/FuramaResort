package Models;

public class Room extends Services {
    private String ServiceFree;

    public Room(String serviceName, String id, double areaRoom, double cost, int maxPersion, String rentalType, String serviceFree) {
        super(serviceName, id, areaRoom, cost, maxPersion, rentalType);
        ServiceFree = serviceFree;
    }

    public String getServiceFree() {
        return ServiceFree;
    }

    public void setServiceFree(String serviceFree) {
        ServiceFree = serviceFree;
    }

    @Override
    void showInfor() {

    }
}
