package commands;
import data.Flat;
import data.FlatReader;
import pattern.Receiver;
import tools.Response;
import tools.WrongInputException;

import java.io.InputStream;

public class Add extends Command {

    public Add(Receiver receiver) {
        super(receiver);
    }

    public Response execute(String arg, InputStream source) {
        if (arg == null){
            FlatReader reader = new FlatReader(source);
            return receiver.add(reader.build());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "add";
    }

    public String getDescription(){
        return "add {element} : add new element to collection\n";
    }

}
