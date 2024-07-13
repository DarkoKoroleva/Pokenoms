package ghost;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends SpecialMove {
    public DoubleTeam(Type type){
        super(type, 0, 0);
    }

    @Override
    protected double calcTypeEffect(Pokemon pokemon, Pokemon pokemon1) {
        pokemon.setMod(Stat.EVASION, 1);
        return super.calcTypeEffect(pokemon, pokemon1);
    }

    @Override
    protected String describe() {return "DoubleTeam";}
}
