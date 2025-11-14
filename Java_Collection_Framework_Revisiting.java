import java.util.*;

public class CollectionFrameworkRevisiting {

    // (1) Find the kth smallest element in an ArrayList
    public static int findKthSmallest(List<Integer> list, int k) {
        Collections.sort(list); // Sort the list
        return list.get(k - 1); // Return kth smallest (1-based index)
    }

    // (2) TreeMap for word frequency
    public static void wordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        TreeMap<String, Integer> freqMap = new TreeMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Frequencies:");
        freqMap.forEach((word, count) -> System.out.println(word + " : " + count));
    }

    // (3) Stack and Queue using PriorityQueue
    public static void simulateStackAndQueue() {
        // Stack (LIFO) using reverse order
        PriorityQueue<Integer> stack = new PriorityQueue<>(Collections.reverseOrder());
        stack.addAll(Arrays.asList(10, 20, 30));
        System.out.println("Stack (LIFO):");
        while (!stack.isEmpty()) {
            System.out.println(stack.poll());
        }

        // Queue (FIFO) using natural order
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(Arrays.asList(10, 20, 30));
        System.out.println("Queue (FIFO):");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // (4) TreeMap for student ID to details
    static class Student {
        String name;
        int age;
        String department;

        Student(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public String toString() {
            return name + ", Age: " + age + ", Dept: " + department;
        }
    }

    public static void studentDetailsMap() {
        TreeMap<Integer, Student> studentMap = new TreeMap<>();
        studentMap.put(101, new Student("Meharin", 22, "ICT"));
        studentMap.put(102, new Student("Rafi", 23, "CSE"));
        System.out.println("Student Details:");
        studentMap.forEach((id, student) -> System.out.println("ID: " + id + " -> " + student));
    }

    // (5) Check if two LinkedLists are equal
    public static void checkLinkedListEquality() {
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("A", "B", "C"));
        System.out.println("LinkedLists equal? " + list1.equals(list2));
    }

    // (6) HashMap for employee ID to department
    public static void employeeDepartmentMap() {
        HashMap<Integer, String> empMap = new HashMap<>();
        empMap.put(1001, "HR");
        empMap.put(1002, "Finance");
        empMap.put(1003, "Engineering");
        System.out.println("Employee Departments:");
        empMap.forEach((id, dept) -> System.out.println("ID: " + id + " -> " + dept));
    }

    // Main method to run all tasks
    public static void main(String[] args) {
        System.out.println("1. Kth Smallest Element:");
        List<Integer> nums = Arrays.asList(7, 2, 9, 4, 1);
        System.out.println("Kth smallest (k=3): " + findKthSmallest(nums, 3));

        System.out.println("\n2. Word Frequency:");
        wordFrequency("Java is powerful and Java is popular");

        System.out.println("\n3. Stack and Queue using PriorityQueue:");
        simulateStackAndQueue();

        System.out.println("\n4. Student Details TreeMap:");
        studentDetailsMap();

        System.out.println("\n5. LinkedList Equality Check:");
        checkLinkedListEquality();

        System.out.println("\n6. Employee Department HashMap:");
        employeeDepartmentMap();
    }
}