package commands;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class Info extends Command {

    public Info(Receiver receiver){
        super(receiver);
    }

    @Override
    public Response execute(String args, InputStream source) {
        if (args == null) {
            return receiver.info();
        } else {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        }
    }

    public String getTitle(){
        return "info";
    }

    public String getDescription(){
        return "info : information about collection\n";
    }

}
