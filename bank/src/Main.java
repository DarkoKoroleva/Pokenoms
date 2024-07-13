//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int x=2;
        Animal crocodile = new Animal("croco", 3, "male");
        Tiger tiger = new Tiger("tiger", 2, "female");
        Cat cat = new Cat("cat", 1, "female");

        Zoo zoo = new Zoo();
        zoo.add(tiger);
        zoo.add(cat);
        zoo.add(crocodile);

        zoo.see();
    }
}