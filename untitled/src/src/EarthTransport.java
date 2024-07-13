package src;

public class EarthTransport extends Transport {
    private double fuel;
    public EarthTransport(String name, int wheelNumber, double speedRate, int passengerCount, Color color, Position position, double fuel){
        super(name,wheelNumber, speedRate, passengerCount, color, position);
        this.fuel = fuel;
    }
    public double getFuel(){
        return fuel;
    }

    @Override
    public void move(int timeMins) {
        if (this.fuel - 0.2*timeMins > 0) {
            this.fuel -= 0.2 * timeMins;
            super.move(timeMins);
        } else{
            System.out.println("Fuel exceeded");
        }
    }
    public String toString(){
        return "Transport{" +
                "name='" + getName() + '\'' +
                ", wheelNumber=" + getWheelNumber() +
                ", speedRate=" + getSpeedRate() +
                ", passengerCount=" + getPassengerCount() +
                ", color=" + getColor() +
                ", position=" + getPosition() +
                ", fuel=" + getFuel() +
                '}';
    }
}
