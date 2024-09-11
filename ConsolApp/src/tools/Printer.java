package tools;

import data.Flat;

import java.util.Deque;

public class Printer {
    private static Printer instance;

    private Printer() {};

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void printCollection(Deque<Flat> collection) {
        System.out.print("[ ");
        for (Flat flat : collection) {
            System.out.print(flat.getName() + ", ");
        }
        System.out.println(" ]");
    }

}
