package ghost;

import ru.ifmo.se.pokemon.Type;

public class Lampent extends Litwick{
    public Lampent(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1, Type var2) {
        super(hp, attack, defense, s_attack, s_defense, speed, var1, var2);
        OminousWind d = new OminousWind(Type.GHOST, 60, 1.0);
        this.addMove(d);
    }
}
