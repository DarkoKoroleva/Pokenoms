package commands;

import data.*;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class Save extends Command{
    public Save(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg, InputStream source) {
        if (arg == null){
            receiver.save();
        } else {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        }
        return null;
    }

    public String getTitle(){
        return "save";
    }

    @Override
    public String getDescription() {
        return "save collection to file";
    }

}
