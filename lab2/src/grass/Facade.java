package grass;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(Type type, double pow, double acc) {
        super(type, pow, acc);
    }

    @Override
    protected String describe() {
        return "facade";
    }

    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        if (var1.getCondition().equals(Status.PARALYZE) ||  var1.getCondition().equals(Status.BURN) || var1.getCondition().equals(Status.POISON))
            return (var1.getStat(Stat.ATTACK)*2);
        else return super.calcBaseDamage(var1, var2);
    }

}
