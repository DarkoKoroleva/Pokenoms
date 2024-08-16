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
