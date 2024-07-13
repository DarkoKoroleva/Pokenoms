package grass;

import ru.ifmo.se.pokemon.*;

public class Confide extends SpecialMove {
    public Confide(Type type){
        super(type, 0, 0);
    }

    protected double calcTypeEffect(Pokemon var1, Pokemon var2) {
        Effect e = new Effect().stat(Stat.ATTACK, -1);
        var2.addEffect(e);
        return super.calcTypeEffect(var1, var2);
    }

    @Override
    protected String describe() {
        return "Confide";
    }

}
