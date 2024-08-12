import java.util.Arrays;
import java.util.Scanner;

public class FlatBuilder {
    public static final int MIN_AREA = 0;
    public static final int MAX_AREA = 858;

    public static Flat build() {
        return new Flat(readName(), readCoordinates(), readArea(), readNumberOfRooms(), readPrice(), readFurniture(), readView(), readHouse();
    }


    public static Flat flatUpdate(Flat flat) {
        flat.setName(readName());
        flat.setCoordinates(readCoordinates());
        flat.setArea(readArea());
        flat.setNumberOfRooms(readNumberOfRooms());
        flat.setPrice(readPrice());
        flat.setFurniture(readFurniture());
        flat.setView(readView());
        flat.setHouse(readHouse());

        return flat;
    }

    public static String readName() {
        Scanner scanner = new Scanner(System.in);
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
                    throw new WrongInputException("Coordinates consists of 2 numbers");
                }
                return new Coordinates(Double.valueOf(args[0]), Float.valueOf(args[1]));
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static int readArea() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Printer.print("Enter area:");
                int input = Integer.valueOf(scanner.nextLine());
                if (input <= MAX_AREA && input > MIN_AREA) {
                    return input;
                } else {
                    throw new WrongInputException("Area must be in diapason (0, 858]");
                }
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }

    public static Long readNumberOfRooms() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Printer.print("Enter house - [name, year, number of flats on floor]:");
                String input = scanner.nextLine();
                String[] args = input.split(" ");
                if (args.length != 3) {
                    throw new WrongInputException("[name, year, number of flats on floor]");
                }
                return new House(args[0], Long.valueOf(args[1]), Long.valueOf(args[2]));
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        }
    }


}
