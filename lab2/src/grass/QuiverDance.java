package grass;

import ru.ifmo.se.pokemon.*;

public class QuiverDance extends SpecialMove {
    public QuiverDance(Type type) {
        super(type, 0, 0);
    }
    @Override
    protected double calcTypeEffect(Pokemon var1, Pokemon var2) {
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK, 1).stat(Stat.SPECIAL_DEFENSE, 1).stat(Stat.SPEED, 1);
        var1.addEffect(e);
        return super.calcTypeEffect(var1, var2);
    }

    @Override
    protected String describe() {
        return "QuiverDance";
    }
}
