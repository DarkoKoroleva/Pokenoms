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


            while (reader.hasNextLine()) {
                line = reader.nextLine();

                if (line != null && !line.equals("}")) {
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
                                }
                            }
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

    private static final Scanner scanner = new Scanner(System.in);

    public static Flat build() {
        return new Flat(readName(), readCoordinates(), readArea(), readNumberOfRooms(), readPrice(), readFurniture(), readView(), readHouse());
    }


    public static void flatUpdate(Flat flat) {
        flat.setName(readName());
        flat.setCoordinates(readCoordinates());
        flat.setArea(readArea());
        flat.setNumberOfRooms(readNumberOfRooms());
        flat.setPrice(readPrice());
        flat.setFurniture(readFurniture());
        flat.setView(readView());
        flat.setHouse(readHouse());
    }

    public static String readName() {
        while (true) {
            try {
                printer.print("Enter name:");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException("Name couldn't be null");
                }
                return input;
            } catch (WrongInputException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static Coordinates readCoordinates() {
        while (true) {
            try {
                printer.print("Enter coordinates x and y:");
                String input = scanner.nextLine();
                String[] args = input.split(" ");
                if (args.length != 2) {
                    throw new WrongInputException("Coordinates consists of 2 numbers");
                }
                return new Coordinates(Double.valueOf(args[0]), Float.valueOf(args[1]));
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static int readArea() {
        while (true) {
            try {
                printer.print("Enter area:");
                int input = Integer.parseInt(scanner.nextLine());
                if (input <= Flat.MAX_AREA && input > Flat.MIN_AREA) {
                    return input;
                } else {
                    throw new WrongInputException("Area must be in diapason (" + Flat.MIN_AREA + ", " + Flat.MAX_AREA + "]");
                }
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static Long readNumberOfRooms() {
        while (true) {
            try {
                printer.print("Enter number of rooms:");
                Long numberOfRooms = Long.valueOf(scanner.nextLine());
                if (numberOfRooms > 0) {
                    return numberOfRooms;
                } else {
                    throw new WrongInputException("numberOfRooms should be positive");
                }
            } catch (NumberFormatException | WrongInputException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static Double readPrice() {
        while (true) {
            try {
                printer.print("Enter price:");
                Double price = Double.valueOf(scanner.nextLine());
                if (price > 0) {
                    return price;
                } else {
                    throw new WrongInputException("price should be positive");
                }
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static Boolean readFurniture() {
        while (true) {
            try {
                printer.print("Enter furniture:");
                String input = scanner.nextLine();
                if (input.equals("yes") || input.equals("да")) {
                    return (true);
                } else {
                    if (input.equals("no") || input.equals("нет")) {
                        return (false);
                    } else {
                        throw new WrongInputException("Enter [yes/no/да/нет]");
                    }
                }
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static View readView() {
        while (true) {
            try {
                printer.print("Enter view:" + Arrays.toString(View.values()));
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException("Enter a number of view");
                }
                int number = Integer.parseInt(input);
                for (View i : View.values()) {
                    if (i.ordinal() == number) {
                        return i;
                    }
                }
                throw new WrongInputException("Enter a number of view from enum");
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
    }

    public static House readHouse() {
        boolean flag = false;
        String name = "";
        Long year = 0L;
        Long numberOfFlatsOnFloor = 0L;
        while (!flag) {
            try {
                printer.print("Enter house - [name]:");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException("Name can not be null");
                }
                name = input;
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }

        flag = false;
        while (!flag) {
            try {
                printer.print("Enter house - [year]:");
                String input = scanner.nextLine();
                year = Long.valueOf(input);
                if (year <= 0) {
                    throw new WrongInputException("Year must be positive");
                }
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }

        flag = false;
        while (!flag) {
            try {
                printer.print("Enter house - [Number of flats on floor]:");
                String input = scanner.nextLine();
                numberOfFlatsOnFloor = Long.valueOf(input);
                if (numberOfFlatsOnFloor <= 0) {
                    throw new WrongInputException("Number of flats on floor must be positive");
                }
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            }
        }
        return new House(name, year, numberOfFlatsOnFloor);
    }

}
