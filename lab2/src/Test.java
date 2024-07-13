import bug.Illumise;
import ghost.Chandelure;
import ghost.Lampent;
import ghost.Litwick;
import grass.Deerling;
import grass.Sawsbuck;
import ru.ifmo.se.pokemon.*;

public class Test {
    public static void main(String[] args) {
        Battle b = new Battle();
        Deerling p1 = new Deerling(4, 4, 3, 3, 3, 5, Type.NORMAL, Type.GRASS);
        Sawsbuck p2 = new Sawsbuck(5, 6, 5, 4, 5, 6, Type.NORMAL, Type.GRASS);
        Illumise p3 = new Illumise(4, 3,4,4,4,4, Type.BUG);
        Litwick p4 = new Litwick(3, 2, 4, 4, 4,2, Type.GHOST, Type.FIRE);
        Lampent p5 = new Lampent(4, 3, 4, 6, 4, 4, Type.GHOST, Type.FIRE);
        Chandelure p6 = new Chandelure(4, 4, 6, 9, 6,5, Type.GHOST, Type.FIRE);
        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);
        b.go();
    }
}
