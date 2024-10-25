package commands;

import data.*;
import pattern.*;
import tools.*;

public class Save extends Command{
    String workFile;
    public Save(Receiver receiver, String file) {
        super(receiver);
        workFile = file;
    }

    @Override
    public Response execute(String arg) {
        if (arg == null){
            receiver.save(workFile);
        } else {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        }
        return new Response("collection is saved");
    }

    public String getTitle(){
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : save collection to file";
    }

}
