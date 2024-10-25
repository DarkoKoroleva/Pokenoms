package pattern;

import commands.*;
import tools.Response;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commands = new HashMap<>();
    protected Receiver receiver = new Receiver();
    String workFile;

    public Invoker(Receiver receiver, String file) {
        workFile = file;
        this.receiver = receiver;
        setCommand("help", new Help(receiver, this));
        setCommand("info", new Info(receiver));
        setCommand("show", new Show(receiver));
        setCommand("add", new Add(receiver));
        setCommand("update_id", new UpdateById(receiver));
        setCommand("remove_by_id", new RemoveById(receiver));
        setCommand("clear", new Clear(receiver));
        setCommand("save", new Save(receiver, workFile));
        setCommand("add_if_max", new AddIfMax(receiver));
        setCommand("remove_greater", new RemoveGreater(receiver));
        setCommand("remove_lower", new RemoveLower(receiver));
        setCommand("count_greater_than_house", new CountGreaterThanHouse(receiver));
        setCommand("filter_by_furniture", new FilterByFurniture(receiver));
        setCommand("exit", new Exit(receiver));
        setCommand("execute_script", new ExecuteScript(this, receiver));
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

    public Map<String, Command> getCommands(){
        return commands;
    }

}
