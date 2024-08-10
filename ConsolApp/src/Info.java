public class Info extends Command{

    public Info(Receiver receiver){
        super(receiver);
    }

    @Override
    public void execute(String args) {
        if (args == null) {
            receiver.info();
        } else {
            WrongInputException e = new WrongInputException("Command Show have no arguments");
            Printer.println(e.getMessage());
        }
    }
}
