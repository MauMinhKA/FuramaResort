package Models;

public class Room extends Services {
    private String ServiceFree;

    public Room(String id,String serviceName,  double areaRoom, double cost, int maxPersion, String rentalType, String serviceFree) {
        super(serviceName, id, areaRoom, cost, maxPersion, rentalType);
        ServiceFree = serviceFree;
    }

    public Room() {
        super();
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
