package src;

public class Transport {

    private String name;
    private int wheelNumber;
    private double speedRate;
    private int passengerCount;
    private Color color;
    private Position position;

    public Transport(String name, int wheelNumber, double speedRate, int passengerCount, Color color, Position position) {
        this.name = name;
        this.wheelNumber = wheelNumber;
        this.speedRate = speedRate;
        this.passengerCount = passengerCount;
        this.color = color;
        this.position = position;
    }

    public void losePassenger(int count) {
        System.out.println("Человеки покинули транспорт");
        this.passengerCount -= count;
    }

    public void recolor(Color newColor) {
        this.color = newColor;
    }

    public void move(int timeMins) {
        double curX = position.getX();
        double newX = curX + this.speedRate * timeMins;
        this.position.setX(newX);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", wheelNumber=" + wheelNumber +
                ", speedRate=" + speedRate +
                ", passengerCount=" + passengerCount +
                ", color=" + color +
                ", position=" + position +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheelNumber() {
        return wheelNumber;
    }

    public void setWheelNumber(int wheelNumber) {
        this.wheelNumber = wheelNumber;
    }

    public double getSpeedRate() {
        return speedRate;
    }

    public void setSpeedRate(double speedRate) {
        this.speedRate = speedRate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(double x, double y) {
        this.position.setXY(x, y);
    }
}
