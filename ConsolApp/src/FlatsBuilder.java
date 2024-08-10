import java.util.Arrays;
import java.util.Scanner;

public class FlatsBuilder {

    public static Flat build() {
        Flat flat = new Flat();
        boolean f = false;
        Scanner scanner = new Scanner(System.in);
        flat.setId();
        flat.setCreationDate();


        do {
            try {
                Printer.print("Enter name:");
                String input = scanner.nextLine();
                flat.setName(input);
                f = true;
            } catch (WrongInputException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {
            try {
                Printer.print("Enter coordinates x and y:");
                String input = scanner.nextLine();
                String[] args = input.split(" ");
                if (args.length != 2){
                    throw new WrongInputException("Coordinates consists of 2 numbers");
                }
                Coordinates coordinates = new Coordinates(Double.valueOf(args[0]), Float.valueOf(args[1]));
                flat.setCoordinates(coordinates);
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {
            try {
                Printer.print("Enter area:");
                String input = scanner.nextLine();
                flat.setArea(Integer.parseInt(input));
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {
            try {
                Printer.print("Enter number of rooms:");
                String input = scanner.nextLine();
                flat.setNumberOfRooms(Long.valueOf(input));
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {
            try {
                Printer.print("Enter price:");
                String input = scanner.nextLine();
                flat.setPrice(Double.parseDouble(input));
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do { //FIXME
            try {
                Printer.print("Enter furniture:");
                String input = scanner.nextLine();
                flat.setFurniture(Boolean.valueOf(input));
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {//FIXME
            try {
                Printer.print("Enter view:" + Arrays.toString(View.values()));

                String input = scanner.nextLine();
                flat.setView(View.valueOf(input));
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        f = false;
        do {
            try {
                Printer.print("Enter house - [name, year, number of flats on floor]:");
                String input = scanner.nextLine();
                String[] args = input.split(" ");
                if (args.length != 3){
                    throw new WrongInputException("[name, year, number of flats on floor]");
                }
                House house = new House(args[0], Long.valueOf(args[1]), Long.valueOf(args[2]));
                flat.setHouse(house);
                f = true;
            } catch (WrongInputException | NumberFormatException e) {
                Printer.println(e.getMessage());
            }
        } while (!f);

        return flat;
    }
}
