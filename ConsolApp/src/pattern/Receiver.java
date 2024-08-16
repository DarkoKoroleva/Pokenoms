package pattern;

import commands.Command;
import data.*;
import tools.Response;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Map;

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

    public Response help(Invoker invoker) {
        StringBuilder result = new StringBuilder("available operations:\n");
        for (Map.Entry<String, Command> operation : invoker.getCommands().entrySet()){
            result.append(operation.getValue().getDescription());
        }
        return new Response(result.toString());
    }

    public Response info() {
        StringBuilder result = new StringBuilder("Elements: ");
        result.append("Date: ").append(creationDate).append("\n");
        result.append("Size: ").append(collection.size()).append("\n");
        result.append("Max Element: ").append(maxElement);
        return new Response(result.toString());
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
        String result = "Collection not contains element flat with id = " + id;
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                if (collection.remove(flat)) {
                    result = "Element was deleted successfully";
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

        return new Response(result);
    }

    public Response updateById (Long id){
        String result = "Collection not contains element flat with id = " + id;
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                 FlatReader.flatUpdate(flat);
                 result = "flat " + id + " was updated";
            }
            break;
        }
        return new Response(result);
    }

    public Response clear() {
        collection.clear();
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
        for (Flat flatsIter : collection) {
            if (flatsIter.compareTo(flat) > 0) {
                collection.remove(flatsIter);
                result = new Response("Elements was deleted");
            }
        }
        return result;
    }

    public Response removeLower(Flat flat) {
        StringBuilder deletingResult = new StringBuilder();
        for (Flat flatsIter : collection) {
            if (flatsIter.compareTo(flat) < 0) {
                deletingResult.append(flatsIter.getId()).append(" ");
                collection.remove(flatsIter);
            }
        }
        if (!deletingResult.isEmpty()){
            deletingResult.append("- flats with these id was deleted");
            return new Response(deletingResult.toString());
        }
        return new Response("Collection not contains element lower than " + flat);
    }

    public Response countGreaterThanHouse(House house) {
        int counter = 0;
        for (Flat flat : collection) {
            if (flat.getHouse().compareTo(house) > 0) {
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
