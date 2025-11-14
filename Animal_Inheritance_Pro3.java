// Animal.java
class Animal {
    protected String type = "Animal";

    void display() {
        System.out.println("This is an animal.");
    }
}

// Dog.java
class Dog extends Animal {
    void bark() {
        System.out.println(type + " says Woof!");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.display();
        d.bark();
    }
}