// Flyable.java
interface Flyable {
    void fly();
}

// Swimmable.java
interface Swimmable {
    void swim();
}

// Duck.java
class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying...");
    }

    public void swim() {
        System.out.println("Duck is swimming...");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
    }
}