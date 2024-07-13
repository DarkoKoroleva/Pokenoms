package ghost;

import ru.ifmo.se.pokemon.*;

public class Litwick extends Pokemon {
    public Litwick(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1, Type var2) {
        this.setStats(hp, attack, defense, s_attack, s_defense, speed);
        this.setType(var1);
        this.addType(var2);
        Rest r = new Rest(Type.PSYCHIC);
        this.setMove(r);
        DoubleTeam d = new DoubleTeam(Type.NORMAL);
        this.setMove(d);
    }
}
