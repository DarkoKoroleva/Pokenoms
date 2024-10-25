package pattern;

import commands.Command;
import data.*;
import json.JsonWriter;
import tools.Printer;
import tools.Response;
import tools.WrongInputException;

import java.io.InputStream;
import java.util.*;

public class Receiver {
    private Deque<Flat> collection = new ArrayDeque<>();
    private final Date creationDate = new Date();
    private Flat maxElement;
    private final Comparator<Flat> comparator = new Comparator<Flat>() {
        @Override
        public int compare(Flat o1, Flat o2) {
            return o1.compareTo(o2);
        }
    };
    private final Printer printer = Printer.getInstance();

    public Receiver(){}

    public Receiver(Deque<Flat> collect){
        collection = sort(collect);
        maxElement = collection.getLast();
    }

    public Response add(Flat flat) {
        collection.addLast(flat);
        sort(collection);
        maxElement = collection.getLast();
        return new Response("The element " + flat + " has been added");
    }

    public Response help(Map<String, Command> commands) {
        StringBuilder result = new StringBuilder("available operations:\n");
        for (Map.Entry<String, Command> operation : commands.entrySet()) {
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
            result.deleteCharAt(result.length() - 2);
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

        sort(collection);
        maxElement = collection.getLast();

        return new Response(result);
    }

    public Response updateById(Long id) {
        FlatReader reader = new FlatReader();
        String result = "Collection not contains element flat with id = " + id;
        for (Flat flat : collection) {
            if (flat.getId().equals(id)) {
                reader.flatUpdate(flat);
                result = "flat " + id + " was updated";
            }
            break;
        }
        sort(collection);
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

        while (collection.getFirst().compareTo(flat) > 0){
            deletingResult.append(collection.getFirst().getId()).append(" ");
            collection.removeFirst();
        }

        while (collection.getLast().compareTo(flat) > 0){
            deletingResult.append(collection.getLast().getId()).append(" ");
            collection.removeLast();
        }

        maxElement = collection.getLast();

        if (!deletingResult.isEmpty()) {
            deletingResult.append("- flats with these id was deleted");
            return new Response(deletingResult.toString());
        }

        return new Response("Collection not contains element lower than " + flat);
    }

    public Response removeLower(Flat flat) {
        StringBuilder deletingResult = new StringBuilder();
        while (collection.getFirst().compareTo(flat) < 0){
            deletingResult.append(collection.getFirst().getId()).append(" ");
            collection.removeFirst();
        }

        while (collection.getLast().compareTo(flat) < 0){
            deletingResult.append(collection.getLast().getId()).append(" ");
            collection.removeLast();
        }

        maxElement = collection.getLast();

        if (!deletingResult.isEmpty()) {
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
                result.append(counter).append(". ").append(flat).append("\n");
                counter++;
            }
        }
        if (counter == 1) {
            result.append("There is no flats");
        }
        return new Response(String.valueOf(result));
    }

    private Deque<Flat> sort(Deque<Flat> collection) {
        Flat[] flats = collection.toArray(new Flat[0]);
        Arrays.sort(flats);
        collection.clear();
        Collections.addAll(collection, flats);
        return collection;
    }

    public Response save(String file) {
        return JsonWriter.writeCollection(collection, file);
    }

    public Response executeScript(Map<String, Command> commands, InputStream source) {
        try (Scanner input = new Scanner(source)) {
            while (input.hasNext()){
                String s = input.nextLine();
                String[] text = s.split(" ");
                if (text.length == 1) {
                    try {
                        printer.println(commands.get(text[0]).execute(null).getResult());
                    } catch (NullPointerException e) {
                        return new Response(e.getMessage());
                    }
                } else if (text.length == 2) {
                    try {
                        return commands.get(text[0]).execute(text[1]);
                    } catch (NullPointerException e) {
                        return new Response(e.getMessage());
                    }
                } else {
                    throw new WrongInputException("Enter command and argument");
                }
            }
            return new Response("script executed");
        } catch (WrongInputException | NumberFormatException e) {
            return new Response(e.getMessage());
        }
    }

}
