package Controllers;

import Commons.FuncFileCSV_House;
import Commons.FuncFileCSV_Villa;
import Models.House;
import Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Villa> listVilla=new ArrayList<Villa>();
    private static ArrayList<House> listHouse=new ArrayList<House>();
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
        System.out.println("Enter ID!");
        villa.setId(scanner.nextLine());
        System.out.println("Enter Name!");
        villa.setServiceName(scanner.nextLine());
        System.out.println("Enter Area1Room!");
        villa.setAreaRoom(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Cost!");
        villa.setCost(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter MaxPerson!");
        villa.setMaxPerson(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter RentalType!");
        villa.setRentalType(scanner.nextLine());
        System.out.println("Enter StandardRoom!");
        villa.setStandardRoom(scanner.nextLine());
        System.out.println("Enter ServicesOther!");
        villa.setServiceOther(scanner.nextLine());
        System.out.println("Enter PoolArea!");
        villa.setPoolArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Floor!");
        villa.setFloor(Integer.parseInt(scanner.nextLine()));
        listVilla.add(villa);
        FuncFileCSV_Villa.writeVillatoCSV(listVilla);
        System.out.println("Add new Villa success! Enter to continue..");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewRoom() {
        listHouse= FuncFileCSV_House.getFileCSVtoListHouse();
        House house=new House();
        System.out.println("Enter ID!");
        house.setId(scanner.nextLine());
        System.out.println("Enter Name!");
        house.setServiceName(scanner.nextLine());
        System.out.println("Enter AreaRoom!");
        house.setAreaRoom(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Cost!");
        house.setCost(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter MaxPerson!");
        house.setMaxPerson(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter RentalType!");
        house.setRentalType(scanner.nextLine());
        System.out.println("Enter StandardRoom!");
        house.setStandardRoom(scanner.nextLine());
        System.out.println("Enter ServicesOther!");
        house.setServiceOther(scanner.nextLine());
        System.out.println("Enter Floor!");
        house.setFloor(Integer.parseInt(scanner.nextLine()));

        listHouse.add(house);
        FuncFileCSV_House.writeHousetoCSV(listHouse);
        System.out.println("Add new House success! Enter to continue..");
        scanner.nextLine();
        displayMainMenu();
    }

    private static void addNewHouse() {
    }

    private static void showServices() {
        listVilla=FuncFileCSV_Villa.getFileCSVtoListVilla();
        for (Villa villa:listVilla){
            System.out.println("id: "+villa.getId());
            System.out.println("name: "+villa.getServiceName());
            System.out.println("grade: "+villa.getServiceOther());
        }
        System.out.println("Show Information Service!");
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
