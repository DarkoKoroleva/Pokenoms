import java.util.Date;

public class Flat implements Comparable<Flat> {
    public static final int MIN_AREA = 0;
    public static final int MAX_AREA = 858;

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

    public Flat(String name, Coordinates coordinates, int area, Long numberOfRooms, double price, Boolean furniture, View view, House house) {
        setId();
        setName(name);
        setCoordinates(coordinates);
        setCreationDate();
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setPrice(price);
        setFurniture(furniture);
        setView(view);
        setHouse(house);
    }

    public void setId() {
        id = 1L;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) throws WrongInputException {
        if (name != null) {
            this.name = name;
        } else {
            throw new WrongInputException("Enter name");
        }
    }

    public String getName() {
        return name;
    }

    public void setCoordinates(Coordinates coordinates) throws WrongInputException {
        if (coordinates != null) {
            this.coordinates = coordinates;
        } else {
            throw new WrongInputException("Enter coordinates");
        }
    }

    public void setCreationDate() {
        this.creationDate = java.time.ZonedDateTime.now();
    }

    public void setArea(int area) throws WrongInputException {
        if (area <= MAX_AREA && area > MIN_AREA) {
            this.area = area;
        } else {
            throw new WrongInputException("Area should be in diapason (0, 858]");
        }
    }

    public void setNumberOfRooms(Long numberOfRooms) throws WrongInputException {
        if (numberOfRooms > 0) {
            this.numberOfRooms = numberOfRooms;
        } else {
            throw new WrongInputException("Number of rooms must be positive");
        }
    }

    public void setPrice(double price) throws WrongInputException {
        if (price > 0) {
            this.price = price;
        } else {
            throw new WrongInputException("Price should be positive");
        }
    }

    public void setFurniture(Boolean furniture) {
        this.furniture = furniture;
    }

    public Boolean getFurniture() {
        return furniture;
    }

    public void setView(View view) throws WrongInputException {
        if (view != null) {
            this.view = view;
        } else {
            throw new WrongInputException("View should not be null");
        }
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public int compareTo(Flat o) {
        return (int) (this.id - o.id);
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}