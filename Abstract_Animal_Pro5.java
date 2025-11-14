// Animal.java
abstract class Animal {
    abstract void makeSound();

    void sleep() {
        System.out.println("Sleeping...");
    }
}

// Dog.java
class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark Bark");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
        d.sleep();
    }
}