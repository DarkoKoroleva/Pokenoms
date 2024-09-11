package data;

import tools.Printer;
import tools.Response;
import tools.WrongInputException;

import java.time.ZonedDateTime;

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
    private IdGenerator idGenerator = IdGenerator.getInstance();
    private Printer printer = Printer.getInstance();

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

    public Flat(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int area, Long numberOfRooms, double price, Boolean furniture, View view, House house) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setArea(area);
        setNumberOfRooms(numberOfRooms);
        setPrice(price);
        setFurniture(furniture);
        setView(view);
        setHouse(house);
    }

    public void setId() {
        id = idGenerator.getNewId();
    }

    public void setId(Long id) {
        try {
            idGenerator.setId(id);
            this.id = id;
        } catch (WrongInputException e) {
            printer.println(e.getMessage());
        }
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
            throw new WrongInputException("Coordinates consists of 2 numbers");
        }
    }

    public void setCreationDate(java.time.ZonedDateTime creationDate){
        this.creationDate = creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCreationDate() {
        this.creationDate = java.time.ZonedDateTime.now();
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setArea(int area) throws WrongInputException {
        if (area <= MAX_AREA && area > MIN_AREA) {
            this.area = area;
        } else {
            throw new WrongInputException("Area should be in diapason (" + MIN_AREA + ", " + MAX_AREA + "]");
        }
    }

    public int getArea() {
        return area;
    }

    public void setNumberOfRooms(Long numberOfRooms) throws WrongInputException {
        if (numberOfRooms > 0) {
            this.numberOfRooms = numberOfRooms;
        } else {
            throw new WrongInputException("Number of rooms must be positive");
        }
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setPrice(double price) throws WrongInputException {
        if (price > 0) {
            this.price = price;
        } else {
            throw new WrongInputException("Price should be positive");
        }
    }

    public double getPrice() {
        return price;
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

    public View getView() {
        return view;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public int compareTo(Flat o) {
        if (!name.equals(o.name)) {
            return name.compareTo(o.name);
        }
        if (!coordinates.equals(o.coordinates)) {
            return coordinates.compareTo(o.coordinates);
        }
        if (area != o.area) {
            return Integer.compare(area, o.area);
        }
        if (!numberOfRooms.equals(o.numberOfRooms)) {
            return numberOfRooms.compareTo(o.numberOfRooms);
        }
        if (price != o.price) {
            return Double.compare(price, o.price);
        }
        if (!furniture.equals(o.furniture)) {
            return Boolean.compare(furniture, o.furniture);
        }
        if (!view.equals(o.view)) {
            return view.compareTo(o.view);
        }
        if (!house.equals(house)) {
            return house.compareTo(o.house);
        }
        if (!creationDate.equals(o.creationDate)) {
            return creationDate.compareTo(o.creationDate);
        }
        return 0;
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}