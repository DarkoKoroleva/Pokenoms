package data;

import tools.Printer;
import tools.WrongInputException;

import java.util.Arrays;
import java.util.Scanner;

public class FlatBuilder {
    public static final int MIN_AREA = 0;
    public static final int MAX_AREA = 858;

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
                Printer.print("Enter name:");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException("Name couldn't be null");
                }
                return input;
            } catch (WrongInputException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static Coordinates readCoordinates() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Printer.print("Enter coordinates x and y:");
                String input = scanner.nextLine();
                String[] args = input.split(" ");
                if (args.length != 2) {
                    throw new WrongInputException("data.Coordinates consists of 2 numbers");
                }
                return new Coordinates(Double.valueOf(args[0]), Float.valueOf(args[1]));
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static int readArea() {
        while (true) {
            try {
                Printer.print("Enter area:");
                int input = Integer.valueOf(scanner.nextLine());
                if (input <= MAX_AREA && input > MIN_AREA) {
                    return input;
                } else {
                    throw new WrongInputException("Area must be in diapason (" + MIN_AREA + ", " + MAX_AREA + "]");
                }
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static Long readNumberOfRooms() {
        while (true) {
            try {
                Printer.print("Enter number of rooms:");
                Long numberOfRooms = Long.valueOf(scanner.nextLine());
                return numberOfRooms;
            } catch (NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static Double readPrice() {
        while (true) {
            try {
                Printer.print("Enter price:");
                Double price = Double.parseDouble(scanner.nextLine());
                return price;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static Boolean readFurniture() {
        while (true) {
            try {
                Printer.print("Enter furniture:");
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
                Printer.println(e.getMessage());
            }
        }
    }

    public static View readView() {
        while (true) {
            try {
                Printer.print("Enter view:" + Arrays.toString(View.values()));
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new WrongInputException("Enter a number of view");
                }
                int number = Integer.valueOf(input);
                for (View i : View.values()) {
                    if (i.ordinal() == number) {
                        return i;
                    }
                }
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static House readHouse(){
        boolean flag = false;
        String name = "";
        Long year = 0L;
        Long numberOfFlatsOnFloor = 0L;
        while (!flag) {
            try {
                Printer.print("Enter house - [name]:");
                String input = scanner.nextLine();
                if (!input.isEmpty()){
                    throw new WrongInputException("Name can not be null");
                }
                name = input;
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }

        flag = false;
        while (!flag) {
            try {
                Printer.print("Enter house - [year]:");
                String input = scanner.nextLine();
                year = Long.valueOf(input);
                if (year <= 0){
                    throw new WrongInputException("Year must be positive");
                }
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }

        flag = false;
        while (!flag) {
            try {
                Printer.print("Enter house - [Number of flats on floor]:");
                String input = scanner.nextLine();
                numberOfFlatsOnFloor = Long.valueOf(input);
                if (numberOfFlatsOnFloor <= 0){
                    throw new WrongInputException("Number of flats on floor must be positive");
                }
                flag = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }

        return new House(name, year, numberOfFlatsOnFloor);
    }


}
