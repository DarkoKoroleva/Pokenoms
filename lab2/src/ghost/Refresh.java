package ghost;

import ru.ifmo.se.pokemon.*;

public class Refresh extends SpecialMove {
    public Refresh(Type type){
        super(type, 0, 0);
    }

    @Override
    protected double calcTypeEffect(Pokemon pokemon, Pokemon pokemon1) {
        if (pokemon.getCondition().equals(Status.PARALYZE) || pokemon.getCondition().equals(Status.BURN) || pokemon.getCondition().equals(Status.POISON)){
            Effect e = new Effect().condition(Status.NORMAL);
            pokemon.setCondition(e);
        }
        return super.calcTypeEffect(pokemon, pokemon1);
    }

    @Override
    protected String describe() {
        return "rest";
    }
}
