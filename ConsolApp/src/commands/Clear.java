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
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "clear";
    }

    public String getDescription(){
        return "clear : clear the collection\n";
    }

}
