import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Flat flat1 = new Flat("Flat1", new Coordinates(25d, 50f), 1, 3L, 2_949_200, true, View.PARK, new House("Home1", 1988L, 4L));
        Invoker invoker = new Invoker();
        invoker.init();

        Scanner input = new Scanner(System.in);

        while (true){
            System.out.print("enter command: ");
            String[] text = input.nextLine().split(" ");
            if (text.length == 1) {
                invoker.executeCommand(text[0], null);
            } else {
                invoker.executeCommand(text[0], text[1]);
            }
        }

    }
}