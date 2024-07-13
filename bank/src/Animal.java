public class Animal {
    String name;
    int age;
    String gender;
    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString(){
        return name + " " + gender;
    }
}
