public class Add extends Command {

    public Add(Receiver receiver) {
        super(receiver);
    }

    public void execute(String args) {
        receiver.add(FlatsBuilder.build());
    }
}
