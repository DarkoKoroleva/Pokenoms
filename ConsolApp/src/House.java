public class House {
    private String name; //Поле не может быть null
    private Long year; //Значение поля должно быть больше 0
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    public House(String name, Long year, Long numberOfFlatsOnFloor){
        if (name != null){
            this.name = name;
        } else System.out.println("Name should not be null");

        if (year > 0){
            this.year = year;
        } else System.out.println("Year should be > 0");

        if (numberOfFlatsOnFloor > 0){
            this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        } else System.out.println("Number of flats on floor should be > 0");
    }
}