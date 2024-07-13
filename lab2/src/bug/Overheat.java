package bug;

import ru.ifmo.se.pokemon.*;

public class Overheat extends SpecialMove {
    public Overheat(Type type, double pow, double acc) {
        this.type = type;
        this.power = pow;
        this.accuracy = acc;
    }

    @Override
    protected double calcTypeEffect(Pokemon var1, Pokemon var2){
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK, -2);
        var1.addEffect(e);
        return super.calcTypeEffect(var1, var2);
    }


    @Override
    protected String describe() {
        return "Overheat";
    }

}
