package commands;
import pattern.*;
import tools.*;

public class Help extends Command {

    public Help(Receiver receiver){
        super(receiver);
    }

    public Response execute(String arg){
        if (arg == null){
            return receiver.help();
        } else {
            throw new WrongInputException("Command Help have no arguments");
        }
    }

    public String getTitle(){
        return getClass().getName();
    }

}
