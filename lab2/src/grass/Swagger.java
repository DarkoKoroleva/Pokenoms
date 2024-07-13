package grass;

import ru.ifmo.se.pokemon.*;

public class Swagger extends SpecialMove {
    public Swagger(Type type, double acc){
            super(type, 0, acc);
    }

    @Override
    protected double calcTypeEffect(Pokemon var1, Pokemon var2) {
        //var2.setMod(Stat.ATTACK, 2);
        Effect e = new Effect().stat(Stat.ATTACK, 2);
        var2.addEffect(e);
        Effect.confuse(var2);
        return super.calcTypeEffect(var1, var2);
    }

    @Override
    protected String describe() {
        return "swagger";
    }

}
