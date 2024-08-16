package commands;
import data.*;
import pattern.*;
import tools.*;

public class AddIfMax extends Command {
    public AddIfMax(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.addIfMax(FlatReader.build());
        } else {
            throw new WrongInputException("Command AddIfMax does not accept arguments");
        }
    }
}
