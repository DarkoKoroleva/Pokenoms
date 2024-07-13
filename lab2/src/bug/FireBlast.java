package bug;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
    public FireBlast(Type type, double pow, double acc){
        super(type, pow, acc);
    }

    @Override
    protected double calcTypeEffect(Pokemon var1, Pokemon var2) {
        Effect e = new Effect().condition(Status.BURN).chance(0.1);
        var2.addEffect(e);
        return super.calcTypeEffect(var1, var2);
    }

    @Override
    protected String describe() {
        return "FireBlast";
    }
}
