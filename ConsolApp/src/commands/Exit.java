package commands;

import pattern.Receiver;
import tools.Response;

import javax.print.DocFlavor;
import java.io.InputStream;

public class Exit extends Command{
    public Exit(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null){
            System.exit(0);
        } else {
            return new Response("Command " + getTitle() + " does not accept arguments");
        }

        return null;
    }

    public String getTitle() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit : end the program (without saving to a file)";
    }
}
