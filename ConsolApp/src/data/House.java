package data;

import tools.WrongInputException;

public class House implements Comparable<House> {
    private String name; //Поле не может быть null
    private Long year; //Значение поля должно быть больше 0
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    public House(String name, Long year, Long numberOfFlatsOnFloor) {
        setName(name);
        setYear(year);
        setNumberOfFlatsOnFloor(numberOfFlatsOnFloor);
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new WrongInputException("Enter house name");
        }
    }

    public String getName() {
        return name;
    }

    public void setYear(Long year) {
        if (year > 0) {
            this.year = year;
        } else {
            throw new WrongInputException("Year must be positive");
        }
    }

    public Long getYear() {
        return year;
    }

    public void setNumberOfFlatsOnFloor(Long numberOfFlatsOnFloor) {
        if (numberOfFlatsOnFloor > 0) {
            this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        } else {
            throw new WrongInputException("Number of flats on floor must be positive");
        }
    }

    public Long getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    @Override
    public int compareTo(House o) {
        if (!name.equals(o.getName())) {
            return name.compareTo(o.name);
        } else if (!year.equals(o.year)) {
            return (int) (year - o.year);
        } else if (!numberOfFlatsOnFloor.equals(o.numberOfFlatsOnFloor)) {
            return (int) (numberOfFlatsOnFloor - o.numberOfFlatsOnFloor);
        } else return 0;
    }

    @Override
    public String toString() {
        return name + " " + year + " " + numberOfFlatsOnFloor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        House h = (House) obj;
        return this.compareTo(h) == 0;
    }
}