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
        if (arg == null && workFile != null){
            receiver.save(workFile);
        } else if (arg != null) {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        } else {
            throw new RuntimeException("You can't save collection. Submit a file for the program to work on startup");
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
