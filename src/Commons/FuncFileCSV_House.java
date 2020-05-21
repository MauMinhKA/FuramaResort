package Commons;

import Models.House;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV_House {
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNameHouse = "src/Data/House.csv";
    private static final String FILE_HEADER_HOUSE = "id,serviceName,areaRoom,cost," +
            "maxPersion,rental,standardRoom,serviceOther,floor";

    public static void writeHousetoCSV(ArrayList<House> listService) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameHouse);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (House house : listService) {
                fileWriter.append(house.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getAreaRoom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getMaxPerson()) );
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getRentalType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getServiceOther());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getFloor()) );
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

    public static ArrayList<House> getFileCSVtoListHouse() {
        BufferedReader br = null;
        ArrayList<House> listHouse = new ArrayList<House>();
        Path path= Paths.get(fileNameHouse);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameHouse);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameHouse));

            while ((line = br.readLine()) != null) {
                String[] spiltData = line.split(",");
                if (spiltData[0].equals("name")) {
                    continue;
                }
                House house=new House();
                house.setId(spiltData[0]);
                house.setServiceName(spiltData[1]);
                house.setAreaRoom(Double.parseDouble(spiltData[2]));
                house.setCost(Double.parseDouble(spiltData[3]));
                house.setMaxPerson(Integer.parseInt(spiltData[4]));
                house.setRentalType(spiltData[5]);
                house.setStandardRoom(spiltData[6]);
                house.setServiceOther(spiltData[7]);
                house.setFloor(Integer.parseInt(spiltData[8]));

                listHouse.add(house);
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
        return listHouse;
    }
}
