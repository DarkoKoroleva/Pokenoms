package ghost;

import ru.ifmo.se.pokemon.Type;

public class Chandelure extends Lampent{
    public Chandelure(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1, Type var2) {
        super(hp, attack, defense, s_attack, s_defense, speed, var1, var2);
        Refresh r = new Refresh(Type.NORMAL);
        this.addMove(r);
    }
}
