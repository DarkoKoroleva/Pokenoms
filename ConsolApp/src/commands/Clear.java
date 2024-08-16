package commands;
import pattern.*;
import tools.*;

public class Clear extends Command {

    public Clear(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.clear();
        } else {
            throw new WrongInputException("Command Clear does not accept arguments");
        }
    }

    public String getTitle(){
        return getClass().getName();
    }

}
