package Models;

import Commons.FuncFileCSV_Customer;
import Packge_check.Check_Customer;


import java.util.ArrayList;
import java.util.Scanner;

import static Packge_check.Check_Customer.CheckDataInputGender;
import static Packge_check.Check_Customer.CheckTrueData;

public class Customer {
    private String nameCustomer, gender, birthdayCustomer, email, typeCustomer, address,numberPhone;
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
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
//        customer.setNameCustomer(Check_Customer.CheckNameCustomer());
//        customer.setGender(Check_Customer.CheckGenderCustomer(CheckTrueData(CheckDataInputGender())));
//        customer.setBirthdayCustomer(Check_Customer.CheckBirthDay());
//        System.out.print("Enter AddressCustomer: ");
//        customer.setAddress(scanner.nextLine());
//        customer.setCmnd(Check_Customer.CheckIdCard());
        customer.setEmail(Check_Customer.CheckEmailCustomer());
        System.out.print("Enter TypeCustomer: ");
        customer.setTypeCustomer(scanner.nextLine());
        customer.setNumberPhone(Check_Customer.CheckNumberPhone());

        listCustomer.add(customer);
        FuncFileCSV_Customer.writeCustomertoCSV(listCustomer);
    }

    public static void showInfoCustomer() {
        ArrayList<Customer> listCustomer = new ArrayList<>();
        listCustomer = FuncFileCSV_Customer.getFileCSVtoListCustomer();
        for (Customer villa : listCustomer) {
            System.out.println("------------***------------");
            System.out.println("Name: " + villa.getNameCustomer());
            System.out.println("Gender: " + villa.getGender());
            System.out.println("BirthDay: " + villa.getBirthdayCustomer());
            System.out.println("Address: " + villa.getAddress());
            System.out.println("CMND: " + villa.getCmnd());
            System.out.println("Email: " + villa.getEmail());
            System.out.println("TypeCustomer: " + villa.getTypeCustomer());
            System.out.println("NumberPhone: " + villa.getNumberPhone());

        }
    }

    public static void main(String[] args) {
//        showInfoCustomer();
        addNewCustomer();
    }
}
