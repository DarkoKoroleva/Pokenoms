package pattern;

import commands.Command;
import data.*;
import json.JsonWriter;
import tools.Response;

import java.io.InputStream;
import java.util.*;

public class Receiver {
    private Deque<Flat> collection = new ArrayDeque<>();
    private Date creationDate = new Date();
    private Flat maxElement;
    private Comparator<Flat> comparator = new Comparator<Flat>() {
        @Override
        public int compare(Flat o1, Flat o2) {
            return o1.compareTo(o2);
        }
    };

    public Receiver() {}

    public Response add(Flat flat) {
        collection.addLast(flat);
        sort();
        maxElement = collection.getLast();
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

        sort();
        maxElement = collection.getLast();

        return new Response(result);
    }

    public Response updateById (Long id, InputStream source){
        FlatReader reader = new FlatReader(source);
        String result = "Collection not contains element flat with id = " + id;
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                 reader.flatUpdate(flat);
                 result = "flat " + id + " was updated";
            }
            break;
        }
        sort();
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
        StringBuilder deletingResult = new StringBuilder();
        for (Flat flatsIter : collection) {
            if (flatsIter.compareTo(flat) > 0) {
                deletingResult.append(flatsIter.getId()).append(" ");
                collection.remove(flatsIter);
            }
        }

        maxElement=collection.getLast();

        if (!deletingResult.isEmpty()){
            deletingResult.append("- flats with these id was deleted");
            return new Response(deletingResult.toString());
        }

        return new Response("Collection not contains element lower than " + flat);
    }

    public Response removeLower(Flat flat) {
        StringBuilder deletingResult = new StringBuilder();
        for (Flat flatsIter : collection) {
            if (flatsIter.compareTo(flat) < 0) {
                deletingResult.append(flatsIter.getId()).append(" ");
                collection.remove(flatsIter);
            }
        }

        maxElement=collection.getLast();

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

    private void sort(){
        Flat[] flats = collection.toArray(new Flat[0]);
        Arrays.sort(flats);
        collection.clear();
        Collections.addAll(collection, flats);
    }

    public Response save(){
        return JsonWriter.writeCollection(collection);
    }

}
