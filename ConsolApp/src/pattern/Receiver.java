import data.Flat;
import data.House;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class Receiver {
    private Deque<Flat> collection = new ArrayDeque<>();
    private Date creationDate = new Date();
    private Flat maxElement;

    public Receiver() {
    }

    public void add(Flat flat) {
        collection.addLast(flat);
        if (maxElement == null || flat.compareTo(maxElement) > 0) {
            maxElement = flat;
        }
    }

    public void help() {
        Printer.print("available operations:" +
                "help : info about available operations\n" +
                "info : information about collection\n" +
                "show : see all the items in the collection\n" +
                "add {element} : add new element to collection\n" +
                "updateId {element} : update the value of a collection item whose ID is equal to the specified one\n" +
                "removeById id : remove an item from the collection by its id\n" +
                "clear : clear the collection\n" +
                "save : save the collection to a file\n" +
                "execute_script file_name : Read and execute the script from the specified file. The script contains commands in the same form as they are entered by the user interactively.\n" +
                "exit : end the program (without saving to a file)\n" +
                "addIfMax {element} : add a new element to the collection if its value exceeds the value of the largest element of this collection\n" +
                "removeGreater {element} : remove from the collection all elements exceeding the specified one\n" +
                "removeLower {element} : remove from the collection all elements smaller than the specified\n" +
                "countGreaterThanHouse house : print the number of elements whose house field value is greater than the specified one\n" +
                "filterByFurniture furniture : output elements whose value of the furniture field is equal to the specified\n" +
                "printAscending : output the elements of the collection in ascending order"
        );
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

        if (maxElement != null && id.equals(maxElement.getId())) {
            maxElement = collection.peekFirst();
            for (Flat flat : collection) {
                if (flat.compareTo(maxElement) > 0) {
                    maxElement = flat;
                }
            }
        }

    }

    public void updateById (Long id){
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                 flat = FlatBuilder.flatUpdate(flat);
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
