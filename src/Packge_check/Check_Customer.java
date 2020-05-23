package Packge_check;

import java.time.LocalDate;
import java.util.Scanner;

public class Check_Customer {
    private static String regex = "";
    private static Scanner scanner = new Scanner(System.in);

    public static String CheckNameCustomer() {
        regex = "^([A-Z][a-z]+\\s?)+$";
        while (true) {

            System.out.print("Enter name (Ex:Trương Khánh Mậu): ");
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Tên nhập sai! Chữ cái đầu viết hoa \nVui lòng nhập lại!");
            }
        }
    }

    public static String CheckEmailCustomer() {
        regex = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        while (true) {
            System.out.print("Enter Email (Ex:mauminh@gmail.com): ");
            String email = scanner.nextLine();
            if (email.matches(regex)) {
                return email;
            } else {
                System.out.println("Email không đúng định dạng!\nVui lòng nhập lại!");
            }
        }
    }

    public static String CheckDataInputGender() {
        regex = "^([A-Za-z]+\\s?)+$";
        while (true) {
            System.out.print("Enter Gender : ");
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            } else {
                System.out.println("Nhập giới tính không đúng\nVui lòng nhập lại!");
            }
        }
    }

    public static String CheckTrueData(String str) {
        str = str.trim().toLowerCase();
        String data[] = str.split("\\s");
        str = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() > 1)
                str = str + data[i].substring(0, 1).toUpperCase() + data[i].substring(1) + " ";
            else
                str = str + data[i].toUpperCase();
        }
        return str.trim();

    }

    public static String CheckGenderCustomer(String Gender) {
        regex = "^Male|Female|Unknow$";
        while (true) {
            if (Gender.matches(regex)) {
                return Gender;
            } else {
                CheckDataInputGender();
            }
        }
    }

    public static int CheckIdCard() {
        regex = "^\\d{9}$";
        while (true) {
            System.out.print("Enter Id Card (ex:123456789): ");
            String temp = scanner.nextLine();
            if (temp.matches(regex)) {
                int idcard = Integer.parseInt(temp);
                return idcard;
            } else {
                System.out.println("nhâp sai CMND! vui lòng nhập lại ");
            }
        }

    }

    public static String CheckBirthDay() {
        regex = "^((3[01]|[12][0-9]|0[1-9])[\\/](1[02]|0[13578])[\\/][0-9]{4})|(([12][0-9]|0[1-9])[\\/](0[2])[\\/][0-9]{4})|((30)|[12][0-9]|0[1-9])[\\/](1[1]|0[469])[\\/][0-9]{4}$";
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter birthday (ex: 30/04/2020): ");
            String birthday = scanner.nextLine();
            LocalDate date = LocalDate.now();
            if (birthday.matches(regex)) {
                String temp = "";
                for (int i = birthday.length() - 4; i < birthday.length(); i++) {
                    temp += birthday.charAt(i);
                }
                if (date.getYear() - new Integer(temp) >= 18) {
                    return birthday;
                } else {
                    System.out.println("Birthday bạn nhập phải lớn hơn 18 tuổi.");
                }

            } else {
                System.out.println("Birthday không đúng định dạng");
            }
        }
    }

    public static String CheckNumberPhone() {
        regex = "^((\\+84)[1-9]{8,9})|(0[89]\\d{8})$";
        while (true) {
            System.out.println("Enter NumberPhone (ex:091234567 or +84961234567: ");
            String numberPhone = scanner.nextLine();
            if (numberPhone.matches(regex)) {
                return numberPhone;
            } else {
                System.out.println("nhâp sai SDT! vui lòng nhập lại ");
            }
        }

    }

}


