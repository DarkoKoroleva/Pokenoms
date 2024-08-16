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

    public String getTitle(){
        return "remove_by_id";
    }

    public String getDescription(){
        return "remove_by_id id : remove an item from the collection by its id\n";
    }

}
