import java.util.Vector;

public class VectorGrowth {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(4); // Initial capacity = 4

        // Adding 5 elements to exceed initial capacity
        vector.add("V1");
        vector.add("V2");
        vector.add("V3");
        vector.add("V4");
        vector.add("V5"); // Triggers capacity increase

        System.out.println("Vector size after adding 5 elements: " + vector.size());
        System.out.println("Vector internal capacity after exceeding: " + vector.capacity());
    }
}