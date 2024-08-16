package commands;
import pattern.*;
import tools.Response;

public class UpdateById extends Command {
    public UpdateById(Receiver receiver) {
        super(receiver);
    }

    @Override
    public Response execute(String arg) {
        Long id = Long.valueOf(arg);
        return receiver.updateById(id);
    }

    public String getTitle(){
        return "update_id";
    }

    public String getDescription(){
        return "update_id {element} : update the value of a collection item whose ID is equal to the specified one\n";
    }

}
