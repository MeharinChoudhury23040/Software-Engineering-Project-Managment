// Animal.java
interface Animal {
    void sound();
}

// Cat.java
class Cat implements Animal {
    public void sound() {
        System.out.println("Meow");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.sound();
    }
}