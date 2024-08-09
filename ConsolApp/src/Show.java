public class Show extends Command{

    public Show(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.show();
    }
}
