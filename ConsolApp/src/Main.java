import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Flat flat1 = new Flat("Flat1", new Coordinates(25d, 50f), 1, 3L, 2_949_200, true, View.PARK, new House("Home1", 1988L, 4L));
        Invoker invoker = new Invoker();

        invoker.executeCommand("add");
        receiver.info();
        receiver.filterByFurniture(true);
    }
}