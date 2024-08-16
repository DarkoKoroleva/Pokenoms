package commands;
import pattern.*;
import tools.*;

public class RemoveById extends Command {
    public  RemoveById(Receiver receiver){
        super(receiver);
    }

    public Response execute(String arg){
        try{
            return receiver.removeById(Long.valueOf(arg));
        } catch (WrongInputException | NumberFormatException e){
            return new Response(e.getMessage());
        }
    }
}