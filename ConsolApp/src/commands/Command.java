package commands;
import pattern.Receiver;
import tools.Response;

import java.io.InputStream;

public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver=receiver;
    }

    public abstract Response execute(String arg, InputStream source);

    public abstract String getDescription();
}