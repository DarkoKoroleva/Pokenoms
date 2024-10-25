package commands;

import pattern.Invoker;
import pattern.Receiver;
import tools.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExecuteScript extends Command {
    Invoker invoker;

    public ExecuteScript(Invoker invoker, Receiver receiver) {
        super(receiver);
        this.invoker = invoker;
    }

    @Override
    public Response execute(String arg) {
        if (arg != null) {
            try {
                return receiver.executeScript(invoker.getCommands(), new FileInputStream(arg));
            } catch (FileNotFoundException e) {
                return new Response(e.getMessage());
            }
        } else {
            return new Response("command " + getTitle() + " should have argument");
        }
    }

    public String getTitle(){
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute_script : read and execute the script from the specified file";
    }
}
