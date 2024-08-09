public class Coordinates {
    public static final int MIN_Y = -114;
    public static final int MAX_X = 640;
    private Double x; //Максимальное значение поля: 640, Поле не может быть null
    private Float y; //Значение поля должно быть больше -114, Поле не может быть null

    public Coordinates(Double x, Float y) {
        setX(x);
        setY(y);
    }

    public void setX(Double x) {
        if (x <= MAX_X) {
            this.x = x;
        } else {
            throw new WrongInputException("x should be <= 640");
        }
    }

    public void setY(Float y) {
        if (y > MIN_Y) {
            this.y = y;
        } else {
            throw new WrongInputException("y should be > -114");
        }
    }

}
