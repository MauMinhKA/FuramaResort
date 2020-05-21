package Commons;

import Models.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV_Room {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNameRoom = "src/Data/Room.csv";

    public static void writeRoomtoCSV(ArrayList<Room> listService) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameRoom);
            for (Room room : listService) {
                fileWriter.append(room.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getServiceName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getAreaRoom()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getMaxPerson()) );
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getRentalType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getServiceFree());
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

    public static ArrayList<Room> getFileCSVtoListRoom() {
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<>();
        Path path= Paths.get(fileNameRoom);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameRoom);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameRoom));

            while ((line = br.readLine()) != null) {
                String[] spiltData = line.split(",");
                Room room=new Room();
                room.setId(spiltData[0]);
                room.setServiceName(spiltData[1]);
                room.setAreaRoom(Double.parseDouble(spiltData[2]));
                room.setCost(Double.parseDouble(spiltData[3]));
                room.setMaxPerson(Integer.parseInt(spiltData[4]));
                room.setRentalType(spiltData[5]);
                room.setServiceFree(spiltData[6]);

                listRoom.add(room);
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
        return listRoom;
    }
}
