package Commons;

import Models.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV_Villa {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNameVilla = "src/Data/Villa.csv";

    public static void writeVillatoCSV(ArrayList<Villa> listVilla) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameVilla);

            for (Villa villa : listVilla) {
                fileWriter.append(villa.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaRoom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getMaxPerson()) );
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getRentalType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getStandardRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getServiceOther());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getPoolArea()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getFloor()) );
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

    public static ArrayList<Villa> getFileCSVtoListVilla() {
        BufferedReader br = null;
        ArrayList<Villa> listVilla = new ArrayList<>();
        Path path= Paths.get(fileNameVilla);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameVilla);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameVilla));
            while ((line = br.readLine()) != null) {
                String[] spiltData = line.split(COMMA_DELIMITER);
                Villa villa=new Villa();
                villa.setId(spiltData[0]);
                villa.setServiceName(spiltData[1]);
                villa.setAreaRoom(Double.parseDouble(spiltData[2]));
                villa.setCost(Double.parseDouble(spiltData[3]));
                villa.setMaxPerson(Integer.parseInt(spiltData[4]));
                villa.setRentalType(spiltData[5]);
                villa.setStandardRoom(spiltData[6]);
                villa.setServiceOther(spiltData[7]);
                villa.setPoolArea(Double.parseDouble(spiltData[8]));
                villa.setFloor(Integer.parseInt(spiltData[9]));

                listVilla.add(villa);
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
        return listVilla;
    }
}
