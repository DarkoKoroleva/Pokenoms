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
