package commands;
import data.FlatReader;
import pattern.Receiver;
import tools.Response;
import tools.WrongInputException;

public class Add extends Command {

    public Add(Receiver receiver) {
        super(receiver);
    }

    public Response execute(String arg) {
        if (arg == null){
            return receiver.add(FlatReader.build());
        } else {
            throw new WrongInputException("Command Add does not accept arguments");
        }
    }

}
