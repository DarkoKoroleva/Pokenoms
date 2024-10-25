package commands;

import data.FlatReader;
import pattern.Receiver;
import tools.Response;
import tools.WrongInputException;

import java.io.InputStream;

public class Add extends Command {

    public Add(Receiver receiver) {
        super(receiver);
    }

    public Response execute(String arg) {
        FlatReader reader = new FlatReader();
        if (arg == null) {
            return receiver.add(reader.build());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle() {
        return "add";
    }

    public String getDescription() {
        return "add {element} : add new element to collection\n";
    }

}
