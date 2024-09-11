package json;

import data.Flat;
import tools.Response;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

public class JsonWriter {

    public static String FlatToJson(Flat flat) {
        StringBuilder s = new StringBuilder();

        s.append("{\n");
        if (flat == null) {
            s.append(" \n");
        } else {
            s.append("\t\t\"id\": ").append(flat.getId()).append(", \n");
            s.append("\t\t\"name\": \"").append(flat.getName()).append("\"").append(", \n");

            s.append("\t\t\"coordinates\": {\n");
            if (flat.getCoordinates() == null) {
                s.append(" \n");
            } else {
                s.append("\t\t\t\"x\": ").append(flat.getCoordinates().getX()).append(", \n");
                s.append("\t\t\t\"y\": ").append(flat.getCoordinates().getY()).append("\n");
            }
            s.append("\t\t},\n");

            s.append("\t\t\"creationDate\": \"").append(flat.getCreationDate()).append("\", \n");
            s.append("\t\t\"area\": ").append(flat.getArea()).append(", \n");
            s.append("\t\t\"numberOfRooms\": ").append(flat.getNumberOfRooms()).append(", \n");
            s.append("\t\t\"price\": ").append(flat.getPrice()).append(", \n");
            s.append("\t\t\"furniture\": ").append(flat.getFurniture()).append(", \n");
            s.append("\t\t\"view\": \"").append(flat.getView()).append("\", \n");

            s.append("\t\t\"house\": {\n");
            if (flat.getHouse() == null) {
                s.append(" \n");
            } else {
                s.append("\t\t\t\"name\": \"").append(flat.getHouse().getName()).append("\", \n");
                s.append("\t\t\t\"year\": ").append(flat.getHouse().getYear()).append(", \n");
                s.append("\t\t\t\"numberOfFlatsOnFloor\": ").append(flat.getHouse().getNumberOfFlatsOnFloor()).append("\n");
            }
            s.append("\t\t}\n");
        }
        s.append("\t}");
        return s.toString();
    }

    public static Response writeCollection(Collection collection) {
        boolean flag = false;
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("file"))) {
            writter.write("[\n");
            for (Object flat : collection) {
                if (flag) {
                    writter.write(",\n ");
                }
                Flat newFlat = (Flat) flat;
                writter.write("\t" + FlatToJson(newFlat));
                flag = true;
            }
            writter.write("\n]");
            return new Response("the collection is recorded");
        } catch (IOException e) {
            return new Response("access error");
        }
    }

}
