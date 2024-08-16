package commands;
import pattern.*;
import tools.*;

public class Info extends Command {

    public Info(Receiver receiver){
        super(receiver);
    }

    @Override
    public Response execute(String args) {
        if (args == null) {
            return receiver.info();
        } else {
            throw new WrongInputException("Command Info have no arguments");
        }
    }

    public String getTitle(){
        return getClass().getName();
    }

}
