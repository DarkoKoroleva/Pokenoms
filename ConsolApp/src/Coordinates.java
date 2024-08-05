public class Coordinates {
    private Double x; //Максимальное значение поля: 640, Поле не может быть null
    private Float y; //Значение поля должно быть больше -114, Поле не может быть null

    public Coordinates(Double x, Float y){
        if (x <= 640) {
            this.x = x;
        } else System.out.println("x should be < 640");

        if (y > -114) {
            this.y=y;
        } else System.out.println("y should be > -114");
    }
}
