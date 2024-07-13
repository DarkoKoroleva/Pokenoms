package ghost;

import ru.ifmo.se.pokemon.*;

public class Rest extends SpecialMove {
    public Rest(Type type){
        super(type, 0, 0);
    }

    @Override
    protected double calcTypeEffect(Pokemon pokemon, Pokemon pokemon1) {
        Effect e = new Effect().turns(2).condition(Status.NORMAL);
        Effect.sleep(pokemon);
        pokemon.addEffect(e);
        return super.calcTypeEffect(pokemon, pokemon1);
    }

    @Override
    protected String describe() {
        return "rest";
    }
}
