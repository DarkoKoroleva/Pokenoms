package commands;
import data.*;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class RemoveGreater extends Command {
    public RemoveGreater(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg, InputStream source) {
        if (arg == null) {
            FlatReader reader = new FlatReader(source);
            return receiver.removeGreater(reader.build());
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
