package json;

import data.*;
import tools.Printer;
import tools.WrongInputException;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Reader {
    static Printer printer = Printer.getInstance();

    public static Deque<Flat> readFlatsFromJson(File inputFileName) {
        Long id = null;
        String name = null;
        Coordinates coordinates = null;
        ZonedDateTime creationDate = null;
        int area = 0;
        Long numberOfRooms = null;
        double price = 0;
        Boolean furniture = null;
        View view = null;
        House house = null;
        Deque<Flat> collection = new ArrayDeque<>();

        try (Scanner reader = new Scanner(inputFileName)) {
            String line;
            HashMap<String, Boolean> valid = new HashMap<>();
            valid.put("id", false);
            valid.put("name", false);
            valid.put("coordinates", false);
            valid.put("creationDate", false);
            valid.put("area", false);
            valid.put("numberOfRooms", false);
            valid.put("price", false);
            valid.put("furniture", false);
            valid.put("view", false);
            valid.put("house", false);
            int counter = 0;

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (line.contains("{")) {
                    counter++;
                } else if (line.contains("}")) {
                    counter--;
                }

                if (!(stringConversion(line).equals("}") && (counter == 0))) {
                    line = stringConversion(line);
                    String[] arg = line.split(" ", 2);

                    switch (arg[0]) {
                        case "id":
                            if (valid.get("id")) {
                                throw new WrongInputException("Incorrect JSON file: id has already been recorded");
                            }
                            id = Long.valueOf(arg[1]);
                            valid.put("id", true);
                            break;
                        case "name":
                            if (valid.get("name")) {
                                throw new WrongInputException("Incorrect JSON file: name has already been recorded");
                            }
                            name = arg[1];
                            valid.put("name", true);
                            break;
                        case "creationDate":
                            if (valid.get("creationDate")) {
                                throw new WrongInputException("Incorrect JSON file: creationDate has already been recorded");
                            }
                            creationDate = java.time.ZonedDateTime.parse(arg[1]);
                            valid.put("creationDate", true);
                            break;
                        case "area":
                            if (valid.get("area")) {
                                throw new WrongInputException("Incorrect JSON file: area has already been recorded");
                            }
                            area = Integer.parseInt(arg[1]);
                            valid.put("area", true);
                            break;
                        case "numberOfRooms":
                            if (valid.get("numberOfRooms")) {
                                throw new WrongInputException("Incorrect JSON file: numbers of rooms has already been recorded");
                            }
                            numberOfRooms = Long.valueOf(arg[1]);
                            valid.put("numberOfRooms", true);
                            break;
                        case "price":
                            if (valid.get("price")) {
                                throw new WrongInputException("Incorrect JSON file: price has already been recorded");
                            }
                            price = Double.parseDouble(arg[1]);
                            valid.put("price", true);
                            break;
                        case "furniture":
                            if (valid.get("furniture")) {
                                throw new WrongInputException("Incorrect JSON file: furniture has already been recorded");
                            }
                            furniture = Boolean.parseBoolean(arg[1]);
                            valid.put("furniture", true);
                            break;
                        case "view":
                            if (valid.get("view")) {
                                throw new WrongInputException("Incorrect JSON file: view has already been recorded");
                            }
                            int number = Integer.parseInt(arg[1]);
                            for (View i : View.values()) {
                                if (i.ordinal() == number) {
                                    view = i;
                                    valid.put("view", true);
                                    break;
                                }
                            }
                            if (!valid.get("view")) {
                                throw new WrongInputException("There is no such view");
                            }
                            break;
                        case "coordinates":
                            if (valid.get("coordinates")) {
                                throw new WrongInputException("Incorrect JSON file: coordinates have already been recorded");
                            }
                            Double x = null;
                            Float y = null;
                            while (!Objects.equals(line = stringConversion(reader.nextLine()), "}")) {
                                arg = line.split(" ", 2);
                                switch (arg[0]) {
                                    case "x":
                                        x = Double.valueOf(arg[1]);
                                        break;
                                    case "y":
                                        y = Float.valueOf(arg[1]);
                                        break;
                                    default:
                                        throw new WrongInputException("Coordinates consist extra fields");
                                }
                            }
                            counter--;
                            if (x != null && y != null) {
                                coordinates = new Coordinates(x, y);
                                valid.put("coordinates", true);
                            } else {
                                throw new WrongInputException("Coordinates are recorded incorrectly");
                            }
                            break;
                        case "house":
                            if (valid.get("house")) {
                                throw new WrongInputException("Incorrect JSON file: house has already been recorded");
                            }
                            String nameHouse = "";
                            Long year = null;
                            Long numberOfFlatsOnFloor = null;
                            while (!(line = stringConversion(reader.nextLine())).equals("}")) {
                                arg = line.split(" ", 2);
                                switch (arg[0]) {
                                    case "name":
                                        nameHouse = arg[1];
                                        break;
                                    case "year":
                                        year = Long.valueOf(arg[1]);
                                        break;
                                    case "numberOfFlatsOnFloor":
                                        numberOfFlatsOnFloor = Long.valueOf(arg[1]);
                                        break;
                                }
                            }
                            counter--;
                            house = new House(nameHouse, year, numberOfFlatsOnFloor);
                            valid.put("house", true);
                            break;
                        default:
                            break;
                    }
                } else {
                    if (!valid.containsValue(false)) {
                        collection.add(new Flat(id, name, coordinates, creationDate, area, numberOfRooms, price, furniture, view, house));
                    }
                    valid.put("id", false);
                    valid.put("name", false);
                    valid.put("coordinates", false);
                    valid.put("creationDate", false);
                    valid.put("area", false);
                    valid.put("numberOfRooms", false);
                    valid.put("price", false);
                    valid.put("furniture", false);
                    valid.put("view", false);
                    valid.put("house", false);
                }
            }
        } catch (FileNotFoundException e) {
            throw new WrongInputException("you continue to work without being able to save the result");
        }

        return collection;
    }

    public static String stringConversion(String line) {
        StringBuilder s = new StringBuilder(line);
        if (line.contains(":")) {
            s.delete(s.indexOf(":"), s.indexOf(":") + 1);
        }
        while (s.indexOf("\t") != -1) {
            s.delete(s.indexOf("\t"), s.indexOf("\t") + 1);
        }
        while (s.indexOf("\"") != -1) {
            s.delete(s.indexOf("\""), s.indexOf("\"") + 1);
        }
        if (line.contains(",")) {
            s.delete(s.lastIndexOf(","), s.lastIndexOf(",") + 1);
        }
        return s.toString();
    }

}
