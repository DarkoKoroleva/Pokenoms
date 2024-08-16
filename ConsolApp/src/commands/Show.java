package commands;
import pattern.*;
import tools.*;

public class Show extends Command {

    public Show(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.show();
        } else {
            throw new WrongInputException("Command Show have no arguments");
        }
    }

    public String getTitle(){
        return getClass().getName();
    }
}
