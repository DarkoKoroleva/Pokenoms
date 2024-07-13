package src;

public enum Color {

    RED("красновый"),
    YELLOW("жёлтовый"),
    GREEN("зелёновый");

    private final String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
