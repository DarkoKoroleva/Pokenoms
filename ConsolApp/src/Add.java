import java.util.Deque;

public class Add extends Command {
    private Flat flat;

    public Add(Receiver receiver) {
        super(receiver);
    }

    public void execute() {
        receiver.add(flat);//TODO и где мне задать этот флэт, хелп
    }
}
