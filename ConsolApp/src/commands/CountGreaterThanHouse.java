package commands;
import data.*;
import pattern.*;
import tools.*;

import java.io.InputStream;

public class CountGreaterThanHouse extends Command {

    public CountGreaterThanHouse(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            FlatReader reader = new FlatReader();
            return receiver.countGreaterThanHouse(reader.readHouse());
        } else {
            throw new WrongInputException("Command " + getTitle() + " does not accept arguments");
        }
    }

    public String getTitle() {
        return "count_greater_than_house house";
    }

    public String getDescription(){
        return "count_greater_than_house house : print the number of elements whose house field value is greater than the specified one\n";
    }

}
