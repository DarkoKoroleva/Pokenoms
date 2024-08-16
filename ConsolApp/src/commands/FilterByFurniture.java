package commands;
import pattern.*;
import tools.*;

public class FilterByFurniture extends Command {

    public FilterByFurniture(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg != null) {
            return receiver.filterByFurniture(Boolean.valueOf(arg));
        } else {
            throw new WrongInputException("Command filterByFurniture does not accept arguments");
        }
    }

}
