package commands;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class Help extends Command {
    Invoker invoker;

    public Help(Receiver receiver, Invoker invoker){
        super(receiver);
        this.invoker = invoker;
    }

    public Response execute(String arg, InputStream source){
        if (arg == null){
            return receiver.help(invoker);
        } else {
            throw new WrongInputException("Command " + getTitle() + " have no arguments");
        }
    }

    public String getTitle(){
        return "help";
    }

    public String getDescription(){
        return "help : info about available operations\n";
    }

}
