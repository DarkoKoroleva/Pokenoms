package commands;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class FilterByFurniture extends Command {

    public FilterByFurniture(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg != null) {
            return receiver.filterByFurniture(Boolean.valueOf(arg));
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle(){
        return "filter_by_furniture";
    }

    public String getDescription(){
        return "filter_by_furniture furniture : output elements whose value of the furniture field is equal to the specified\n";
    }
}
