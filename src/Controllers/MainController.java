package Controllers;
import Commons.FuncFileCSV_House;
import Commons.FuncFileCSV_Room;
import Commons.FuncFileCSV_Villa;
import Models.House;
import Models.Room;
import Models.Villa;
import Packge_check.Check;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Villa> listVilla=new ArrayList<>();
    private static ArrayList<House> listHouse=new ArrayList<>();
    private static ArrayList<Room> listRoom=new ArrayList<>();
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        System.out.println("1.\tAdd New Services.\n"
                + "2.\tShow Services.\n"
                + "3.\tAdd New Customer\n"
                + "4.\tShow Information of Customer\n"
                + "5.\tAdd New Booking\n"
                + "6.\tShow Information of Employee\n"
                + "7.\tExit");
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInformationofCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInformationofEmployee();
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!! Please choose again!");
                
        }
    }

    private static void addNewServices() {
        System.out.println("1.\tAdd New Villa.\n"
                + "1.\tAdd New House.\n"
                + "3.\tAdd New Room.\n"
                + "4.\tBack to menu.\n"
                + "5.\tExit");
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                displayMainMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!! Please choose again!");
        }


    }

    private static void addNewVilla() {
        listVilla=FuncFileCSV_Villa.getFileCSVtoListVilla();
        Villa villa=new Villa();
        villa.setId(Check.checkIdServices("^SVVL\\-\\d{4}$","SVLL"));
        villa.setServiceName(Check.CheckNameServices());
        villa.setAreaRoom(Check.checkAreaRoomAndPool("Room"));
        villa.setCost(Check.checkCost());
        villa.setMaxPerson(Check.checkMaxPerson());
        System.out.print("Enter RentalType: ");
        villa.setRentalType(scanner.nextLine());
        System.out.print("Enter StandardRoom: ");
        villa.setStandardRoom(scanner.nextLine());
        System.out.print("Enter ServicesOther: ");
        villa.setServiceOther(scanner.nextLine());
        villa.setPoolArea(Check.checkAreaRoomAndPool("Pool"));
        villa.setFloor(Check.checkFloor());
        listVilla.add(villa);
        FuncFileCSV_Villa.writeVillatoCSV(listVilla);
        System.out.println("Add new Villa success! Enter to continue..");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewRoom() {
        listRoom= FuncFileCSV_Room.getFileCSVtoListRoom();
        Room house=new Room();
        house.setId(Check.checkIdServices("^SVRO\\-\\d{4}$","SVRO"));
        house.setServiceName(Check.CheckNameServices());
        house.setAreaRoom(Check.checkAreaRoomAndPool("Room"));
        house.setCost(Check.checkCost());
        house.setMaxPerson(Check.checkMaxPerson());
        System.out.println("Enter RentalType!");
        house.setRentalType(scanner.nextLine());
        house.setServiceFree(Check.checkServiceFree());
        listRoom.add(house);
        FuncFileCSV_Room.writeRoomtoCSV(listRoom);
        System.out.println("Add new Room success! Enter to continue..");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewHouse() {
        listHouse= FuncFileCSV_House.getFileCSVtoListHouse();
        House house=new House();
        house.setId(Check.checkIdServices("^SVHO\\-\\d{4}$","SVHO"));
        house.setServiceName(Check.CheckNameServices());
        house.setAreaRoom(Check.checkAreaRoomAndPool("Room"));
        house.setCost(Check.checkCost());
        house.setMaxPerson(Check.checkMaxPerson());
        System.out.print("Enter RentalType: ");
        house.setRentalType(scanner.nextLine());
        System.out.print("Enter StandardRoom: ");
        house.setStandardRoom(scanner.nextLine());
        System.out.print("Enter ServicesOther: ");
        house.setServiceOther(scanner.nextLine());
        house.setFloor(Check.checkFloor());

        listHouse.add(house);
        FuncFileCSV_House.writeHousetoCSV(listHouse);
        System.out.println("Add new House success! Enter to continue..");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void showServices() {
        System.out.println("1.\tShow all Villa\n"
                + "2.\tShow all House\n"
                + "3.\tShow all Room\n"
                + "4.\tShow All Name Villa Not Duplicate\n"
                + "5.\tShow All Name House Not Duplicate\n"
                + "6.\tShow All Name Room Not Duplicate\n"
                + "7.\tBack to Menu\n"
                + "8.\tExit");
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                showVilla();
                break;
            case "2":
                showHouse();
                break;
            case "3":
                showRoom();
                break;
            case "4":
//                showAllNameVillaNotDuplicate();
                break;
            case "5":
//                showAllNameHouseNotDuplicate();
                break;
            case "6":
//                showAllNameRoomNotDuplicate();
                break;
            case "7":
                displayMainMenu();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("Fail!! Please choose again!");
        }
    }

    private static void showVilla() {
        listVilla=FuncFileCSV_Villa.getFileCSVtoListVilla();
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
        scanner.nextLine();
        displayMainMenu();
    }

    private static void showHouse() {
        listHouse=FuncFileCSV_House.getFileCSVtoListHouse();
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
        scanner.nextLine();
        displayMainMenu();
    }

    private static void showRoom() {
        listRoom=FuncFileCSV_Room.getFileCSVtoListRoom();
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
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewCustomer() {
    }

    private static void showInformationofCustomer() {
    }

    private static void addNewBooking() {
    }

    private static void showInformationofEmployee() {
    }



}
