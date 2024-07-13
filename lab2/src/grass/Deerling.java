package grass;

import ru.ifmo.se.pokemon.*;

public class Deerling extends Pokemon {

    public Deerling(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1) {
        this.setStats(hp, attack, defense, s_attack, s_defense, speed);
        this.setType(var1);//а как второй установить
        Facade f = new Facade(Type.NORMAL, 70, 1.0);
        this.addMove(f);
        Confide c = new Confide(Type.NORMAL);
        this.addMove(c);
        Swagger s = new Swagger(Type.NORMAL, 0.85);
        this.addMove(s);
    }
    public Deerling(double hp, double attack, double defense, double s_attack, double s_defense, double speed, Type var1, Type var2) {
        this.setStats(hp, attack, defense, s_attack, s_defense, speed);
        this.setType(var1);
        this.addType(var2);
        Facade f = new Facade(Type.NORMAL, 70, 1.0);
        this.addMove(f);
        Confide c = new Confide(Type.NORMAL);
        this.addMove(c);
        Swagger s = new Swagger(Type.NORMAL, 0.85);
        this.addMove(s);
    }
}
