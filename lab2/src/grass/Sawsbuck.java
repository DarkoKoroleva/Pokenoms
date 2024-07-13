package grass;

import ru.ifmo.se.pokemon.Type;

public class Sawsbuck extends Deerling{
    public Sawsbuck(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1){
        super(hp, attack, defense, s_attack, s_defense, speed, var1);
        QuiverDance q = new QuiverDance(Type.BUG);
        this.addMove(q);
    }

    public Sawsbuck(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1, Type var2){
        super(hp, attack, defense, s_attack, s_defense, speed, var1, var2);
        QuiverDance q = new QuiverDance(Type.BUG);
        this.addMove(q);
    }
}
