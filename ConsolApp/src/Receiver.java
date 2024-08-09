import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class Receiver {
    private Deque<Flat> collection = new ArrayDeque<>();
    private Date creationDate = new Date();
    private Flat maxElement;

    public Receiver() {}

    public void add(Flat flat) {
        collection.addLast(flat);
        if (maxElement == null || flat.compareTo(maxElement) > 0) {
            maxElement = flat;
        }
    }

    public void help() {
    }

    public void info() {
        Printer.print("Elements: ");
        Printer.printCollection(collection);
        Printer.println(
                "Date: " + creationDate + "\n" +
                        "Size: " + collection.size() + "\n" +
                        "Max Element: " + maxElement
        );
    }

    public void show() {
        if (collection.isEmpty()) {
            Printer.println("Collection is empty");
        } else {
            Printer.print("[");
            for (Flat flat : collection) {
                Printer.print(flat + ", ");
            }
            Printer.print("]");
        }
    }

    public void removeById(Long id) {
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                collection.remove(flat);
            }
        }

        if (id.equals(maxElement.getId())) {
            Flat maxElement = collection.peekFirst();
            for (Flat flat : collection) {
                if (flat.compareTo(maxElement) > 0) {
                    maxElement = flat;
                }
            }
        }

    }

    public void clear() {
        for (Flat flat : collection) {
            collection.remove(flat);
        }
    }

    public void addIfMax(Flat flat) {
        if (flat.compareTo(maxElement) > 0) {
            collection.add(flat);
            maxElement = flat;
        }
    }

    public void removeGreater(Flat flat) {
        for (Flat iter : collection) {
            if (iter.compareTo(flat) > 0) {
                collection.remove(iter);
            }
        }
    }

    public void removeLower(Flat flat) {
        for (Flat iter : collection) {
            if (iter.compareTo(flat) < 0) {
                collection.remove(iter);
            }
        }
    }

    public void countGreaterThanHouse(House house) {
        int counter = 0;
        for (Flat iter : collection) {
            if (iter.getHouse().compareTo(house) > 0) {
                counter++;
            }
        }
        Printer.println("Count greater than house '" + house + "' = " + counter);
    }

    public void filterByFurniture(Boolean furniture) {
        Printer.println("Filter by furniture '" + furniture + "':");
        int counter = 1;
        for (Flat flat : collection) {
            if (flat.getFurniture() == furniture) {
                Printer.println(counter + ". " + flat);
                counter++;
            }
        }
        if (counter == 1) {
            Printer.println("There is no flats");
        }
    }

}
