package pattern;

import commands.*;
import tools.Response;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commands = new HashMap<>();
    Receiver receiver = new Receiver();

    public Invoker() {
        setCommand("help", new Help(receiver));
        setCommand("info", new Info(receiver));
        setCommand("show", new Show(receiver));
        setCommand("add", new Add(receiver));
        setCommand("update_by_id", new UpdateById(receiver));
        setCommand("remove_by_id", new RemoveById(receiver));
        setCommand("clear", new Clear(receiver));
        setCommand("add_if_max", new AddIfMax(receiver));
        setCommand("remove_greater", new RemoveGreater(receiver));
        setCommand("remove_lower", new RemoveLower(receiver));
        setCommand("count_greater_than_house", new CountGreaterThanHouse(receiver));
        setCommand("filter_by_furniture", new FilterByFurniture(receiver));
    }

    public void setCommand(String key, Command command) {
        commands.put(key, command);
    }

    public Response executeCommand(String key, String arg) {
        try {
            return commands.get(key).execute(arg);
        } catch (NullPointerException e) {
            return new Response(e.getMessage());
        }
    }

}
