package src;

public class Main {
    public static void main(String[] args) {
//        WaterTransport lodka = new WaterTransport(
//                "Абобус",
//                5.0,
//                1000000000,
//                Color.RED,
//                Position.getDefaultPosition()
//        );
//        lodka.losePassenger(2);
//        lodka.move(12);
//        System.out.println(lodka.getPosition());

        AirTransport airplane = new AirTransport(
                3,
                300,
                1000,
                Color.YELLOW,
                Position.getDefaultPosition()
        );
        System.out.println(airplane);
        airplane.move(2);
        System.out.println(airplane.getPosition());

        EarthTransport car = new EarthTransport("бибика", 4, 100, 5, Color.YELLOW, Position.getDefaultPosition(), 20d);
        System.out.println(car);
        car.move(1200000);
        System.out.println(car);

    }
}
