package Packge_check;


import java.util.Scanner;

public class Check {
    private static String regex = "";
    private static Scanner scanner;

    public static String checkIdServices(String regex,String ex) {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter ID (Ex: "+ex+"-1234): ");
            String id = scanner.nextLine();
            if (id.matches(regex)) {
                return id;
            } else {
                System.out.println("ID nhập sai định dạng, vui lòng nhập lại!");
            }
        }
    }

    public static String CheckNameServices() {
        regex = "^([A-Z][a-z]+\\s?)+$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter name (Ex: Du Lịch): ");
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên nhập sai định dạng, vui lòng nhập lại!");
            }
        }
    }

    public static Double checkAreaRoomAndPool(String RoomOrPool) {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter Area" + RoomOrPool + " (30m2<Area): ");
            double area = scanner.nextDouble();
            if (31 <= area) {
                return area;
            } else {
                System.out.println("Diện tích phải lớn hơn 30m2 , vui lòng nhập lại!");
            }
        }
    }

    public static Double checkCost() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter Cost ($): ");
            double cost = scanner.nextDouble();
            if (1 <= cost) {
                return cost;
            } else {
                System.out.println("Giá cho thuê phải lớn hơn 0 , vui lòng nhập lại!");
            }
        }
    }

    public static Integer checkFloor() {


        regex = "^[1-9]+$";
        int floor1;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter Floor: ");
            String floor = scanner.nextLine();
            if (floor.matches(regex)) {
                 floor1=Integer.parseInt(floor);
                return floor1;
            } else {
                System.out.println("Tên nhập sai định dạng, vui lòng nhập lại!");
            }
        }

    }

    public static int checkMaxPerson() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter MaxPerson: ");
            int maxPerson = scanner.nextInt();
            if (maxPerson <= 0) {
                System.out.println("Số người tối đa phải lớn hơn 0\nVui lòng nhập lại!");
            } else if (20 <= maxPerson) {
                System.out.println("Số người tối đa phải nhỏ hơn 20\nVui lòng nhập lại!");
            } else {
                return maxPerson;
            }
        }
    }

    public static String checkServiceFree() {
        regex = "^massage|karaoke|food|drink|car|Massage|Karaoke|Food|Drink|Car$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter ServiceFree (Ex: Karaoke): ");
            String serviceFree = scanner.nextLine();
            if (serviceFree.matches(regex)) {
                return serviceFree;
            } else {
                System.out.println("Dich Vụ đi kèm không đúng\nVui lòng nhập lại!");
            }
        }
    }

}
