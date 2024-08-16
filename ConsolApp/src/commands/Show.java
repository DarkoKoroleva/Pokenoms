public class Show extends Command {

    public Show(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute(String arg) {
        if (arg == null) {
            receiver.show();
        } else {
            throw new WrongInputException("Command Show have no arguments");
        }

    }
}
