// Person.java
class Person {
    private String name;  // private: only accessible inside this class

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Alice");
        System.out.println(p.getName());
    }
}