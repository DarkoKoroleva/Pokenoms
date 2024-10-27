import data.Flat;
import json.Reader;
import pattern.*;
import tools.*;

import java.io.File;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Printer printer = Printer.getInstance();
        Invoker invoker;

        String mainFileForJob;

        try {
            if (args != null){
                StringBuilder mainFile = new StringBuilder(Arrays.toString(args));
                mainFile.delete(0,1);
                mainFile.delete(mainFile.lastIndexOf("]"), mainFile.lastIndexOf("]")+1);
                mainFileForJob = mainFile.toString();
                Deque<Flat> uploadCollection = Reader.readFlatsFromJson(new File(mainFileForJob));
                invoker = new Invoker(new Receiver(uploadCollection), args[0]);
            } else {
                invoker = new Invoker(new Receiver(), null);
            }
        } catch (NumberFormatException | WrongInputException e) {
            printer.println(e.getMessage());
            invoker = new Invoker(new Receiver(), null);
        }


        while (true) {
            try {
                System.out.print("enter command: ");
                String[] text = input.nextLine().split(" ");
                if (text.length == 1) {
                    Response s = invoker.executeCommand(text[0], null);
                    printer.println(s.getResult());
                } else if (text.length == 2) {
                    printer.println(invoker.executeCommand(text[0], text[1]).getResult());
                } else {
                    throw new WrongInputException("Enter command and argument");
                }
            } catch (WrongInputException | NumberFormatException e) {
                printer.println(e.getMessage());
            } catch (RuntimeException e) {
                printer.println(e.getMessage());
            }
        }
    }

}