package commands;
import data.*;
import pattern.*;
import tools.*;

public class CountGreaterThanHouse extends Command {

    public CountGreaterThanHouse(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.countGreaterThanHouse(FlatReader.readHouse());
        } else {
            throw new WrongInputException("Command countGreaterThanHouse does not accept arguments");
        }
    }

    public String getTitle(){
        return getClass().getName();
    }

}
