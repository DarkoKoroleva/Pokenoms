import commands.*;
import pattern.Receiver;

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
        setCommand("updateById", new UpdateById(receiver));
        setCommand("removeById", new RemoveById(receiver));
        setCommand("clear", new Clear(receiver));
        setCommand("addIfMax", new AddIfMax(receiver));
    }

    public void setCommand(String key, Command command) {
        commands.put(key, command);
    }

    public void executeCommand(String key, String arg) {
        commands.get(key).execute(arg);
    }

}
