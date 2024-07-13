public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public static void mrr(){
        System.out.println("Mrr");
    }
    public String toString(){
        return name + " " + gender+ "mrrr myaw";
    }
}
