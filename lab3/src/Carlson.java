import java.util.Random;

public class Carlson extends Character {
    public Carlson(Status status) {
        super(status);
    }

    @Override
    public void takeKnife(Knife knife) {
        this.setHavingKnife(true);
        knife.setOwner(Owner.CARLSON);
        System.out.println("Carlson took knife");
    }

    public void enjoy() {
        this.setStatus(Status.VERY_ENJOY);
        System.out.println("Carlson enjoys five-era coins");
    }

    public String toString() {
        return getClass().getName() + ' ' + this.getStatus();
    }


    public int takeCoin(MoneyBox pig) throws NegativeWeightException {
        int f = 0;
        if (!this.getHavingKnife()) {
            KnifeIsMissingException e = new KnifeIsMissingException();
            System.out.println(e.getMessage());
        }

        if (pig.getMass() != Weight.LIGHTWEIGHT && pig.getWeight() < 10) {
            pig.setMass(Weight.LIGHTWEIGHT);
        }

        while (f == 0) {
            Random r = new Random();
            int i = r.nextInt(3);
            switch (i) {
                case 0:
                    if (pig.era5.getCount() > 0) {
                        pig.era5.setCount(pig.era5.getCount() - 1);
                        pig.setWeight(pig.getWeight() - pig.era5.weight);
                        System.out.println("A 5 era coin was obtained");
                        f = 1;
                        return 5;
                    }
                    break;
                case 1:
                    if (pig.era10.count > 0) {
                        pig.era10.count -= 1;
                        pig.setWeight(pig.getWeight() - pig.era10.weight);
                        System.out.println("A 10 era coin was obtained");
                        f = 1;
                        return 10;
                    }
                    break;
                case 2:
                    if (pig.era25.count > 0) {
                        pig.era25.count -= 1;
                        pig.setWeight(pig.getWeight() - pig.era25.weight);
                        System.out.println("A 25 era coin was obtained");
                        f = 1;
                        return 25;
                    }
                    break;
                default:
                    NoSuchIndexException e = new NoSuchIndexException();
                    System.out.println(e.getMessage());
            }
        }
        if (pig.getWeight() < 0 ) {
            NegativeWeightException e = new NegativeWeightException();
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Malysh malysh = (Malysh) obj;
        return (this.getStatus() == malysh.getStatus()) && (this.getHavingKnife() == malysh.getHavingKnife());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getStatus() == null) ? 0 : this.getStatus().hashCode());
        result = prime * result + (this.getHavingKnife() ? 1:0);
        return result;
    }
}