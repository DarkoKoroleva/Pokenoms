package bug;

import ru.ifmo.se.pokemon.*;

public class Illumise extends Pokemon {
    public Illumise(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1){
        this.setStats(hp, attack, defense, s_attack, s_defense, speed);
        Overheat o = new Overheat(Type.FIRE, 130, 0.9);
        this.addMove(o);
        FireBlast f = new FireBlast(Type.FIRE, 110, 0.85);
        this.addMove(f);
        Flamethrower fl = new Flamethrower(Type.FIRE, 90, 1.0);
        this.addMove(fl);
        Amnesia a = new Amnesia(Type.PSYCHIC, 0, 0);
        this.addMove(a);
    }


}
