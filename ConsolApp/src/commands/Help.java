package commands;
import pattern.*;
import tools.*;

public class Help extends Command {
    Invoker invoker;

    public Help(Receiver receiver, Invoker invoker){
        super(receiver);
        this.invoker = invoker;
    }

    public Response execute(String arg){
        if (arg == null){
            return receiver.help(invoker.getCommands());
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
