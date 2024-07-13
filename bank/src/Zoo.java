public class Zoo {
    protected final Animal[] pets;
    protected int pointer = 0;
    public Zoo() {
        pets = new Animal[5];
    }

    public void add(Animal animal){
        pets[pointer] = animal;
        pointer++;
    }

    public void see(){
        for(int i = 0; i<pointer;i++){
            System.out.println(pets[i]);
        }
    }

    public Animal get(int i){
        return pets[i];
    }
}
