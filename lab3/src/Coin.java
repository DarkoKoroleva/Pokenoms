public class Coin {
    private int value;
    protected int count;
    protected final double weight;

    public Coin(int value, int count, double weight) {
        this.value = value;
        this.count = count;
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
