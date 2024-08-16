package pattern;

import data.*;
import tools.Response;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class Receiver {
    private Deque<Flat> collection = new ArrayDeque<>();
    private Date creationDate = new Date();
    private Flat maxElement;

    public Receiver() {}

    public Response add(Flat flat) {
        collection.addLast(flat);
        if (maxElement == null || flat.compareTo(maxElement) > 0) {
            maxElement = flat;
        }
        return new Response("The element " + flat + " has been added");
    }

    public Response help() {
        return new Response("available operations:\n" +
                "help : info about available operations\n" +
                "info : information about collection\n" +
                "show : see all the items in the collection\n" +
                "add {element} : add new element to collection\n" +
                "update_id {element} : update the value of a collection item whose ID is equal to the specified one\n" +
                "remove_by_id id : remove an item from the collection by its id\n" +
                "clear : clear the collection\n" +
                "save : save the collection to a file\n" +
                "execute_script file_name : Read and execute the script from the specified file. The script contains commands in the same form as they are entered by the user interactively.\n" +
                "exit : end the program (without saving to a file)\n" +
                "add_if_max {element} : add a new element to the collection if its value exceeds the value of the largest element of this collection\n" +
                "remove_greater {element} : remove from the collection all elements exceeding the specified one\n" +
                "remove_lower {element} : remove from the collection all elements smaller than the specified\n" +
                "count_greater_than_house house : print the number of elements whose house field value is greater than the specified one\n" +
                "filter_by_furniture furniture : output elements whose value of the furniture field is equal to the specified\n" +
                "print_ascending : output the elements of the collection in ascending order"
        );
    }

    public Response info() {
        StringBuilder result = new StringBuilder("Elements: ");
        result.append("Date: ").append(creationDate).append("\n");
        result.append("Size: ").append(collection.size()).append("\n");
        result.append("Max Element: ").append(maxElement);
        return new Response(String.valueOf(result));
    }

    public Response show() {
        if (collection.isEmpty()) {
            return new Response("Collection is empty");
        } else {
            StringBuilder result = new StringBuilder("[ ");
            for (Flat flat : collection) {
                result.append(flat.toString()).append(", ");
            }
            result.deleteCharAt(result.length()-2);
            result.append("]");
            return new Response(String.valueOf(result));
        }
    }

    public Response removeById(Long id) {
        Response result = new Response("Collection not contains element flat" + id);;
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                if (collection.remove(flat)) {
                    result = new Response("Element was deleted successfully");
                }
                break;
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

        return result;
    }

    public Response updateById (Long id){
        Response result = new Response("Collection not contains element flat" + id);
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                 FlatReader.flatUpdate(flat);
                 result = new Response("flat " + id + " was updated");
            }
            break;
        }
        return result;
    }

    public Response clear() {
        while (!collection.isEmpty()) {
            collection.remove();
        }
        return new Response("The collection has been cleared");
    }

    public Response addIfMax(Flat flat) {
        if (flat.compareTo(maxElement) > 0) {
            maxElement = flat;
            return add(flat);
        }
        return new Response("The element is less than the maximum");
    }

    public Response removeGreater(Flat flat) {
        Response result = new Response("Collection not contains element greater than" + flat);
        for (Flat iter : collection) {
            if (iter.compareTo(flat) > 0) {
                collection.remove(iter);
                result = new Response("Elements was deleted");
            }
        }
        return result;
    }

    public Response removeLower(Flat flat) {
        Response result = new Response("Collection not contains element lower than" + flat);
        for (Flat iter : collection) {
            if (iter.compareTo(flat) < 0) {
                collection.remove(iter);
                result = new Response("Elements was deleted");
            }
        }
        return result;
    }

    public Response countGreaterThanHouse(House house) {
        int counter = 0;
        for (Flat iter : collection) {
            if (iter.getHouse().compareTo(house) > 0) {
                counter++;
            }
        }
        return new Response("Count greater than house '" + house + "' = " + counter);
    }

    public Response filterByFurniture(Boolean furniture) {
        StringBuilder result = new StringBuilder("Filter by furniture '" + furniture + "':");
        int counter = 1;
        for (Flat flat : collection) {
            if (flat.getFurniture() == furniture) {
                result.append(counter + ". " + flat + "\n");
                counter++;
            }
        }
        if (counter == 1) {
            result.append("There is no flats");
        }
        return new Response(String.valueOf(result));
    }

}
