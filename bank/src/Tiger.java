public class Tiger extends Animal{
    public Tiger(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void hit(){
        System.out.println("Tiger hit");
    }

    public String toString(){
        return name + " " + gender + "!!!!!";
    }
}
