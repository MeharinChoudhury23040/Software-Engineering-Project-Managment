// 1. Basic class
class Food1 {
    String name;
    String origin;
    int spiceLevel;
}

// 2. With constructor
class Food2 {
    String name;
    String origin;
    int spiceLevel;

    Food2(String name, String origin, int spiceLevel) {
        this.name = name;
        this.origin = origin;
        this.spiceLevel = spiceLevel;
    }
}

// 3. With method
class Food3 {
    String name;
    String origin;
    int spiceLevel;

    Food3(String name, String origin, int spiceLevel) {
        this.name = name;
        this.origin = origin;
        this.spiceLevel = spiceLevel;
    }

    void displayInfo() {
        System.out.println("Food: " + name);
        System.out.println("Origin: " + origin);
        System.out.println("Spice Level: " + spiceLevel + "/10");
    }
}

// 4. With getter, setter, toString
class Food4 {
    private String name;
    private String origin;
    private int spiceLevel;

    Food4(String name, String origin, int spiceLevel) {
        this.name = name;
        this.origin = origin;
        this.spiceLevel = spiceLevel;
    }

    public String getName() { return name; }
    public String getOrigin() { return origin; }
    public int getSpiceLevel() { return spiceLevel; }

    public void setName(String name) { this.name = name; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setSpiceLevel(int spiceLevel) { this.spiceLevel = spiceLevel; }

    public String toString() {
        return "Food: " + name + ", Origin: " + origin + ", Spice Level: " + spiceLevel + "/10";
    }
}