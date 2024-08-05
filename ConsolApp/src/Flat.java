import java.util.Date;

public class Flat {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int area; //Максимальное значение поля: 858, Значение поля должно быть больше 0
    private Long numberOfRooms; //Значение поля должно быть больше 0
    private double price; //Значение поля должно быть больше 0
    private Boolean furniture; //Поле может быть null
    private View view; //Поле не может быть null
    private House house; //Поле может быть null

    public Flat(String name, Coordinates coordinates, int area, Long numberOfRooms, double price, Boolean furniture, View view, House house){
        this.id = 1L; //TODO how make unique
        if (name != null)
            this.name = name;
        else System.out.println("Name shouldn't be null");

        if (coordinates != null)
            this.coordinates = coordinates;
        else System.out.println("Coordinates shouldn't be null");
        this.creationDate = java.time.ZonedDateTime.now();
        if (area> 0 && area <= 858) this.area = area;
        else System.out.println("Area should be in diapason [0, 858]");
        if (numberOfRooms > 0) this.numberOfRooms = numberOfRooms;
        else System.out.println("Number of rooms should be > 0");

        if (price > 0) this.price = price;
        else System.out.println("Price should be > 0");
        this.furniture = furniture;
        if (view != null) this.view = view;
        else System.out.println("View should not be null");
        this.house = house;
    }


}