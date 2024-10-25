package commands;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class Show extends Command {

    public Show(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.show();
        } else {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        }
    }

    public String getTitle(){
        return "show";
    }

    public String getDescription(){
        return "show : see all the items in the collection\n";
    }

}
