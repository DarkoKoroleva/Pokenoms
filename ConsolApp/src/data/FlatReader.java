package data;

import tools.Printer;
import tools.WrongInputException;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FlatReader {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = Printer.getInstance();

    public Flat build() {
        return new Flat(readName(), readCoordinates(), readArea(), readNumberOfRooms(), readPrice(), readFurniture(), readView(), readHouse());
    }

    public void flatUpdate(Flat flat) {
        flat.setName(readName());
        flat.setCoordinates(readCoordinates());
        flat.setArea(readArea());
        flat.setNumberOfRooms(readNumberOfRooms());
        flat.setPrice(readPrice());
        flat.setFurniture(readFurniture());
        flat.setView(readView());
        flat.setHouse(readHouse());
    }

    public String readName() {
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

    public Coordinates readCoordinates() {
        Scanner scanner = new Scanner(System.in);
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

    public int readArea() {
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

    public Long readNumberOfRooms() {
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

    public Double readPrice() {
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

    public Boolean readFurniture() {
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

    public View readView() {
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

    public House readHouse() {
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
