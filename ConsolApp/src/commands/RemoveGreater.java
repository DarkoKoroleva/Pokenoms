package commands;
import data.*;
import pattern.*;
import tools.*;

public class RemoveGreater extends Command {
    public RemoveGreater(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.removeGreater(FlatReader.build());
        } else {
            throw new WrongInputException("Command RemoveGreater does not accept arguments");
        }
    }
}
