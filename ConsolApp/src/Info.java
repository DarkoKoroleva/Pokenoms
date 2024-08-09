public class Info extends Command{

    public Info(Receiver receiver){
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.info();
    }
}
