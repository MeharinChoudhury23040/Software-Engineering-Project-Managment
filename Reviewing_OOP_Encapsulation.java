// OOP Encapsulation Assignment
// Author: Meharin
// Topic: Encapsulation using Car and Car1 classes

class Car {
    // Private fields: encapsulated data
    private String color;
    private int year;

    // Public setters: allow controlled modification
    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Public getters: allow controlled access
    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    // Public method to show car status
    public void carStatus() {
        System.out.println("Car Status: Running!");
    }
}

class Car1 {
    // Private fields: encapsulated data
    private String color;
    private int year;

    // Constructor: sets values during object creation
    public Car1(String color, int year) {
        this.color = color;
        this.year = year;
    }

    // Public getters: allow controlled access
    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    // Public method to show car status
    public void carStatus() {
        System.out.println("Car Status: Running!");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Car object ...set with setter\n");

        // Using Car class with setters
        Car car = new Car();
        car.setColor("Red");
        car.setYear(2020);
        System.out.println("Color: " + car.getColor());
        System.out.println("Year: " + car.getYear());
        car.carStatus();

        System.out.println("\nCar1 object ...set with constructor\n");

        // Using Car1 class with constructor
        Car1 car1 = new Car1("Blue", 2018);
        System.out.println("Color: " + car1.getColor());
        System.out.println("Year: " + car1.getYear());
        car1.carStatus();
    }
}