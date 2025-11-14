//Human Class:
package model;

public class Human {
    private String name;
    private int age;
    private String gender;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ". Age: " + age + ", Gender: " + gender);
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
}

//Music Class:
package media;

public class Music {
    private String title;
    private String artist;
    private int duration; // in seconds

    public void play() {
        System.out.println("Playing: " + title + " by " + artist);
    }

    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
}

//University Class:
package edu;

public class University {
    private String name;
    private String location;

    public University(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void showInfo() {
        System.out.println("University: " + name + ", Location: " + location);
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
}