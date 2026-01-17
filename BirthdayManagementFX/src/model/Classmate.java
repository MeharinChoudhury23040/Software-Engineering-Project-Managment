package model;

import java.time.LocalDate;

public class Classmate {
    private int id;
    private String name;
    private LocalDate birthDate;

    public Classmate(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
}
