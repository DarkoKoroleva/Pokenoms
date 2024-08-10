import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commands = new HashMap<>();
    Receiver receiver = new Receiver();

    public Invoker() {}

    public void setCommand(String key, Command command) {
        commands.put(key, command);
    }

    public void executeCommand(String key, String args) {
        commands.get(key).execute(args);
    }

    public void init() {
        setCommand("add", new Add(receiver));
        setCommand("removeById", new RemoveById(receiver));
        setCommand("info", new Info(receiver));
    }

}
