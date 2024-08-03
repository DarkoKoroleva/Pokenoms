import java.util.Random;

public class MoneyBox {
    protected Coin era5;
    protected Coin era10;
    protected Coin era25;
    private Facade facade;
    private Weight mass;
    private double weight;

    public MoneyBox(int coin5, int coin10, int coin25, Facade status1, Weight status2) {
        era5 = new Coin(5, coin5, 2d);
        era10 = new Coin(10, coin10, 4d);
        era25 = new Coin(25, coin25, 10d);
        this.facade = status1;
        this.mass = status2;
        this.weight = era5.weight*era5.count + era10.weight*era10.count + era25.weight*era25.count;;
    }

    public MoneyBox(int count, Facade status1, Weight status2) {
        class GenerateCoins {
            public void generation(int count){
                Random r = new Random();
                for (int j = 0; j < count; j++) {
                    int i = r.nextInt(3);
                    switch (i) {
                        case 0:
                            era5.count += 1;
                            weight += era5.weight;
                            break;
                        case 1:
                            era10.count += 1;
                            weight += era10.weight;
                            break;
                        case 2:
                            era25.count += 1;
                            weight += era25.weight;
                            break;
                        default:
                            NoSuchIndexException e = new NoSuchIndexException();
                            System.out.println(e.getMessage());
                    }
                }
            }
        }

        GenerateCoins generateCoins = new GenerateCoins();
        generateCoins.generation(count);
        this.facade = status1;
        this.mass = status2;
    }

    public class Coin {
        private int value;
        protected int count;
        protected final double weight;

        Rolling rolling = new Rolling() {
            @Override
            public void roll() {
                System.out.println("Rolling...");
            }
        };

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


    public Facade getFacade() {
        return facade;
    }

    public Weight getMass() {
        return mass;
    }

    public void setFacade(Facade status1) {
        this.facade = status1;
    }

    public void setMass(Weight status2) {
        this.mass = status2;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
