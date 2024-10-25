package commands;
import data.*;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class AddIfMax extends Command {
    public AddIfMax(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            FlatReader reader = new FlatReader();
            return receiver.addIfMax(reader.build());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "add_if_max";
    }

    public String getDescription(){
        return "add_if_max {element} : add a new element to the collection if its value exceeds the value of the largest element of this collection\n";
    }

}
