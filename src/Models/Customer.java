package Models;

import Commons.FuncFileCSV_Customer;
import Commons.FuncFileCSV_House;
import Commons.FuncFileCSV_Room;
import Commons.FuncFileCSV_Villa;
import Packge_check.Check_Customer;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static Packge_check.Check_Customer.CheckDataInputGender;
import static Packge_check.Check_Customer.CheckTrueData;

public class Customer {
    private static ArrayList<Villa> listVilla=new ArrayList<>();
    private static ArrayList<House> listHouse=new ArrayList<>();
    private static ArrayList<Room> listRoom=new ArrayList<>();
    private  static Scanner scanner=new Scanner(System.in);
    private String nameCustomer, gender, birthdayCustomer, email, typeCustomer, address, numberPhone;
    private int cmnd;
    private Services services;

    public Customer() {
    }

    public Customer(String nameCustomer, String gender, String birthdayCustomer, String email, String typeCustomer, String address, String numberPhone, int cmnd, Services services) {
        this.nameCustomer = nameCustomer;
        this.gender = gender;
        this.birthdayCustomer = birthdayCustomer;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.numberPhone = numberPhone;
        this.cmnd = cmnd;
        this.services = services;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void showInfo() {
    }

    public static void addNewCustomer() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        listCustomer = FuncFileCSV_Customer.getFileCSVtoListCustomer();
        Customer customer = new Customer();
        customer.setNameCustomer(Check_Customer.CheckNameCustomer());
        customer.setGender(Check_Customer.CheckGenderCustomer(CheckTrueData(CheckDataInputGender())));
        customer.setBirthdayCustomer(Check_Customer.CheckBirthDay());
        System.out.print("Enter AddressCustomer: ");
        customer.setAddress(scanner.nextLine());
        customer.setCmnd(Check_Customer.CheckIdCard());
        customer.setEmail(Check_Customer.CheckEmailCustomer());
        System.out.print("Enter TypeCustomer: ");
        customer.setTypeCustomer(scanner.nextLine());
        customer.setNumberPhone(Check_Customer.CheckNumberPhone());

        listCustomer.add(customer);
        FuncFileCSV_Customer.writeCustomertoCSV(listCustomer);
    }

    public static void showInformationCustomer() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        listCustomer = FuncFileCSV_Customer.getFileCSVtoListCustomer();
        listCustomer.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer customer, Customer t1) {
                if (customer.getNameCustomer().equals(t1.getNameCustomer())) {
                    return customer.getBirthdayYear() - t1.getBirthdayYear();
                } else {
                    return customer.getNameCustomer().compareTo(t1.getNameCustomer());
                }
            }
        });
        for (Customer customer : listCustomer) {
            System.out.println("------------***------------");
            System.out.println("Name: " + customer.getNameCustomer());
            System.out.println("Gender: " + customer.getGender());
            System.out.println("BirthDay: " + customer.getBirthdayCustomer());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("CMND: " + customer.getCmnd());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("TypeCustomer: " + customer.getTypeCustomer());
            System.out.println("NumberPhone: " + customer.getNumberPhone());

        }
    }

    private int getBirthdayYear() {
        String temp = "";
        for (int i = getBirthdayCustomer().length() - 4; i < getBirthdayCustomer().length(); i++) {
            temp += getBirthdayCustomer().charAt(i);
        }
        int YearBirthday = Integer.parseInt(temp);
        return YearBirthday;
    }

    private static void addNewBooking() {
        System.out.println("t1.\tBooking Villa.\n"
                + "2.\tBooking House.\n"
                + "3.\tBooking Room.\n"
                + "4.\tBack to menu.\n"
        );
        String choose=scanner.nextLine();
        switch (choose){
            case "1":
                bookingVilla();
                break;
            case "2":
                bookingRoom();
                break;
            case "3":
                bookingHouse();
                break;
            case "4":
                addNewBooking();
                break;
            default:
                System.out.println("fail!!!!!!!!");
        }
    }

    private static void bookingHouse() {
        listHouse= FuncFileCSV_House.getFileCSVtoListHouse();
        for (House house:listHouse){
            System.out.println("------------***------------");
            System.out.println("id: "+house.getId());
            System.out.println("name: "+house.getServiceName());
            System.out.println("AreaRoom: "+house.getAreaRoom());
            System.out.println("Cost: "+house.getCost());
            System.out.println("MaxPerson: "+house.getMaxPerson());
            System.out.println("RentalType: "+house.getRentalType());
            System.out.println("StandardRoom: "+house.getStandardRoom());
            System.out.println("ServicesOther: "+house.getServiceOther());
            System.out.println("Floor: "+house.getFloor());
        }
    }

    private static void bookingRoom() {
        listRoom= FuncFileCSV_Room.getFileCSVtoListRoom();
        for (Room room:listRoom){
            System.out.println("------------***------------");
            System.out.println("id: "+room.getId());
            System.out.println("name: "+room.getServiceName());
            System.out.println("AreaRoom: "+room.getAreaRoom());
            System.out.println("Cost: "+room.getCost());
            System.out.println("MaxPerson: "+room.getMaxPerson());
            System.out.println("RentalType: "+room.getRentalType());
            System.out.println("ServiceFree: "+room.getServiceFree());
        }
    }

    private static void bookingVilla() {
        listVilla= FuncFileCSV_Villa.getFileCSVtoListVilla();
        for (Villa villa:listVilla){
            System.out.println("------------***------------");
            System.out.println("id: "+villa.getId());
            System.out.println("name: "+villa.getServiceName());
            System.out.println("AreaRoom: "+villa.getAreaRoom());
            System.out.println("Cost: "+villa.getCost());
            System.out.println("MaxPerson: "+villa.getMaxPerson());
            System.out.println("RentalType: "+villa.getRentalType());
            System.out.println("StandardRoom: "+villa.getStandardRoom());
            System.out.println("ServicesOther: "+villa.getServiceOther());
            System.out.println("PoolArea: "+villa.getPoolArea());
            System.out.println("Floor: "+villa.getFloor());
        }
    }

    public static void main(String[] args) {
//        showInformationCustomer();
//        addNewCustomer();
        addNewBooking();
    }


}
