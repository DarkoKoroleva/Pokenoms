public class RemoveById extends Command{
    public  RemoveById(Receiver receiver){
        super(receiver);
    }

    public void execute(String arg){
        try{
            receiver.removeById(Long.valueOf(arg));
        } catch (WrongInputException e){
            Printer.println("Command remove by id accepts a number as input");
        }
    }
}
