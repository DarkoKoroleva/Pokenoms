package json;

import data.Flat;

public class JsonWriter {

    public static void writeFlatToJson(Flat flat){
        System.out.println("{");
        if (flat == null){
            System.out.println(" ");
        } else {
            System.out.println("\t\"id\": " + flat.getId() + ", ");
            System.out.println("\t\"name\": \"" + flat.getName() + "\"" + ", ");

            System.out.println("\t\"coordinates\": {");
            if (flat.getCoordinates() == null){
                System.out.println(" ");
            } else {
                System.out.println("\t\t\"x\": " + flat.getCoordinates() .getX()  + ", ");
                System.out.println("\t\t\"y\": " + flat.getCoordinates() .getY());
            }
            System.out.println("\t},");

            System.out.println("\t\"creationDate\": \"" + flat.getCreationDate() + "\", ");
            System.out.println("\t\"area\": " + flat.getArea() + ", ");
            System.out.println("\t\"numberOfRooms\": " + flat.getNumberOfRooms() + ", ");
            System.out.println("\t\"price\": " + flat.getPrice() + ", ");
            System.out.println("\t\"furniture\": " + flat.getFurniture() + ", ");
            System.out.println("\t\"view\": \"" + flat.getView() + "\", ");

            System.out.println("\t\"house\": {");
            if (flat.getHouse() == null){
                System.out.println(" ");
            } else {
                System.out.println("\t\t\"name\": \"" + flat.getHouse().getName() + "\", ");
                System.out.println("\t\t\"year\": " + flat.getHouse().getYear() + ", ");
                System.out.println("\t\t\"numberOfFlatsOnFloor\": " + flat.getHouse().getNumberOfFlatsOnFloor());
            }
            System.out.println("\t}");
            System.out.println("}");
        }
    }

}
