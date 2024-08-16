import data.Flat;

import java.util.Deque;

public class Printer {
    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void printCollection(Deque<Flat> collection) {
        System.out.print("[ ");
        for (Flat flat : collection) {
            System.out.print(flat.getName() + ", ");
        }
        System.out.println(" ]");
    }

}
