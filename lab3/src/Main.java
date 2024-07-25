public class Main {
    public static void main(String[] args) {
        Carlson carlson = new Carlson(Status.HOPE);
        Malysh malysh = new Malysh(Status.CONFUSED);
        MoneyBox pig = new MoneyBox(2, 1, 2, Facade.BEAUTIFUL, Weight.HEAVY);
        Knife knife = new Knife(1);
        Scenario1 scenario1 = new Scenario1();
        scenario1.script(malysh, pig, carlson, knife);
    }
}