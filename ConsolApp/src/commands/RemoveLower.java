package commands;
import data.*;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class RemoveLower extends Command {
    public RemoveLower(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg, InputStream source) {
        if (arg == null) {
            FlatReader reader = new FlatReader(source);
            return receiver.removeLower(reader.build());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "remove_lower";
    }

    public String getDescription(){
        return "remove_lower {element} : remove from the collection all elements smaller than the specified\n";
    }

}
