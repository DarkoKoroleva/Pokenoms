package ghost;

import ru.ifmo.se.pokemon.*;

public class OminousWind extends SpecialMove {
    public OminousWind(Type type, double pow, double acc) {
        super(type, pow, acc);
    }

    @Override
    protected double calcTypeEffect(Pokemon pokemon, Pokemon pokemon1) {
        Effect e = new Effect().chance(0.1).stat(Stat.ATTACK, 1).stat(Stat.DEFENSE, 1);
        e.stat(Stat.SPECIAL_ATTACK, 1).stat(Stat.SPECIAL_DEFENSE, 1).stat(Stat.SPEED, 1);
        pokemon.addEffect(e);
        return super.calcTypeEffect(pokemon, pokemon1);
    }

    @Override
    protected String describe() {return "Ominous Wind";}
}
