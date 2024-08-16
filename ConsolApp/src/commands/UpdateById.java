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
        return getClass().getName();
    }

}
