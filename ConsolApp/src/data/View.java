package data;

public enum View {
    YARD("Двор"),
    PARK("Парк"),
    BAD("Плохой"),
    NORMAL("Нормальный");

    private final String value;

    View(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
