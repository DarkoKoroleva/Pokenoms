package commands;
import data.*;
import pattern.*;
import tools.*;

public class RemoveLower extends Command {
    public RemoveLower(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        if (arg == null) {
            return receiver.removeLower(FlatReader.build());
        } else {
            throw new WrongInputException("Command RemoveLower does not accept arguments");
        }
    }
}
