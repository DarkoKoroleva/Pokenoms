package bug;

import ru.ifmo.se.pokemon.*;

public class Amnesia extends SpecialMove {
    public Amnesia(Type type, double pow, double acc) {
        super(type, pow, acc);
    }

    @Override
    protected double calcTypeEffect(Pokemon var1, Pokemon var2) {
        var1.setMod(Stat.SPECIAL_DEFENSE, 2);
        return super.calcTypeEffect(var1, var2);
    }

    @Override
    protected String describe() {
        return "Amnesia";
    }
}
