package commands;
import data.*;
import pattern.*;
import tools.*;

public class RemoveGreater extends Command {
    public RemoveGreater(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.removeGreater(FlatReader.build());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "remove_greater";
    }

    public String getDescription(){
        return "remove_greater {element} : remove from the collection all elements exceeding the specified one\n";
    }

}
