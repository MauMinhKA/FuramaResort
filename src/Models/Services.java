package Models;

public abstract class Services {
    private String id;
   private String serviceName;
   private double areaRoom,cost;
    private int maxPerson;
   private String rentalType;

    public Services() {
    }

    public Services(String id, String serviceName, double areaRoom, double cost, int maxPersion, String rentalType) {
        this.serviceName = serviceName;
        this.id = id;
        this.areaRoom = areaRoom;
        this.cost = cost;
        this.maxPerson = maxPersion;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAreaRoom() {
        return areaRoom;
    }

    public void setAreaRoom(double areaRoom) {
        this.areaRoom = areaRoom;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    abstract void showInfor();
}
