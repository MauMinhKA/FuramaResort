package Commons;

import Models.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV_Customer {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNameCustomer = "src/Data/Customer.csv";

    public static void writeCustomertoCSV(ArrayList<Customer> listService) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameCustomer);

            for (Customer customer : listService) {
                fileWriter.append(customer.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getBirthdayCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getCmnd()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getTypeCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getNumberPhone());
                fileWriter.append(NEW_LINE_SEPARATOR);

            }
        } catch (Exception e) {
            System.out.println("Error in csvFileWriter!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error when flush or close");
            }
        }
    }

    public static ArrayList<Customer> getFileCSVtoListCustomer() {
        BufferedReader br = null;
        ArrayList<Customer> customers = new ArrayList<>();
        Path path= Paths.get(fileNameCustomer);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameCustomer);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameCustomer));

            while ((line = br.readLine()) != null) {
                String[] spiltData = line.split(",");
//                if (spiltData[0].equals("name")) {
//                    continue;
//                }
                Customer customer=new Customer();
                customer.setNameCustomer(spiltData[0]);
                customer.setGender(spiltData[1]);
                customer.setBirthdayCustomer(spiltData[2]);
                customer.setAddress(spiltData[3]);
                customer.setCmnd(Integer.parseInt(spiltData[4]));
                customer.setEmail(spiltData[5]);
                customer.setTypeCustomer(spiltData[6]);
                customer.setNumberPhone(spiltData[7]);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customers;
    }
}
