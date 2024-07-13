package src;

public class WaterTransport extends Transport {

    public WaterTransport(String name, double speedRate, int passengerCount, Color color, Position position) {
        super(name, 0, speedRate, passengerCount, color, position);
    }

    @Override
    public void losePassenger(int count) {
        // он знает
        System.out.println("Человеки начинают тонуть...");
        for (int i = 0; i < count; i++) {
            System.out.println("Тонет " + i + "-ый");
            setPosition(getPosition().getX() + 2, getPosition().getY());
            System.out.println("Новая позиция: " + getPosition());
        }
    }
}
