package Packge_check;


import java.util.Scanner;

public class Check_Service {
    private static String regex = "";
    private static Scanner scanner;

    public static String checkIdServices(String regex, String ex) {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter ID (Ex: " + ex + "-1234): ");
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
        String regex = "\\d+(\\.\\d+)?";
        double kq;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Area" + RoomOrPool + " (30m2<Area): ");
            String floor = scanner.nextLine();
            if (floor.matches(regex) && Double.parseDouble(floor) >= 31) {
                kq = Double.parseDouble(floor);
                return kq;
            } else {
                System.out.println("Diện tích phải là số và lớn hơn không\nVui lòng nhập lại!");
            }
        }
    }

    public static Double checkCost() {
        String regex = "\\d+(\\.\\d+)?";
        double kq;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Cost: ");
            String floor = scanner.nextLine();
            if (floor.matches(regex) && Double.parseDouble(floor) >= 1) {
                kq = Double.parseDouble(floor);
                return kq;
            } else {
                System.out.println("Giá cho thuê phải Là số và lớn hơn 1.\nVui lòng nhập lại!");
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
                floor1 = Integer.parseInt(floor);
                return floor1;
            } else {
                System.out.println("Số tầng nhập sai định dạng.\nVui lòng nhập lại!");
            }
        }

    }

    public static int checkMaxPerson() {
        regex = "^[1-9]+$";
        int maxperson;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter MaxPerson: ");
            String test = scanner.nextLine();
            if (test.matches(regex) && Integer.parseInt(test) < 20) {
                maxperson = Integer.parseInt(test);
                return maxperson;
            } else {
                System.out.println("Số Người tôi đa sai.\nVui lòng nhập lại!");
            }
        }
    }

    public static String checkServiceOther(String serviceother) {
        regex = "^Massage|Karaoke|Food|Drink|Car$";
        while (true) {
            if (serviceother.matches(regex)) {
                return serviceother;
            } else {
                CheckNameData("ServiceOther");
            }
        }
    }

    public static String CheckNameData(String type) {
        regex = "^([A-Za-z]+\\s?)+$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter " + type + ": ");
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên nhập Không đúng, vui lòng nhập lại!");
            }
        }
    }

    public static String TrueData(String line) {
        line = line.trim().toLowerCase();
        String data[] = line.split("\\s");
        line = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() > 1)
                line = line + data[i].substring(0, 1).toUpperCase() + data[i].substring(1) + " ";
            else
                line = line + data[i].toUpperCase();
        }
        return line.trim();
    }

}
