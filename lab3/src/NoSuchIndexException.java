public class NoSuchIndexException extends RuntimeException {
    public NoSuchIndexException() {
        super("There is no such index");
    }
}
