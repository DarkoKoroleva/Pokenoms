package src;

public class AirTransport extends Transport {
    public AirTransport(int wheelNumber, double speedRate, int passengerCount, Color color, Position position) {
        super("Самолееееет", wheelNumber, speedRate, passengerCount, color, position);
    }

    public void move(int timeMins) {
        double curX = getPosition().getX() + 5*timeMins;
        double curY = getPosition().getY() + 4*timeMins;
        this.setPosition(curX, curY);
    }


}
