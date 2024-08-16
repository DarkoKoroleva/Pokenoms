package commands;
import pattern.Receiver;
import tools.Response;

public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver=receiver;
    }

    public abstract Response execute(String arg);

    public abstract String getDescription();
}