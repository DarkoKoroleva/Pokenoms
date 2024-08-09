public class RemoveById extends Command{
    Long id;

    public  RemoveById(Receiver receiver, Long id){
        super(receiver);
        this.id = id;
    }

    public void execute(){
        receiver.removeById(id);
    }
}
