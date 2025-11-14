import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.addFirst("B");
        linkedList.addLast("C");
        System.out.println("LinkedList: " + linkedList);

        // PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println("PriorityQueue (min first): " + pq.poll());

        // Deque
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Front");
        deque.addLast("Back");
        System.out.println("Deque: " + deque);

        // HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        System.out.println("HashMap: " + hashMap);

        // TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 3);
        treeMap.put("Apple", 2);
        treeMap.put("Cherry", 5);
        System.out.println("TreeMap (sorted): " + treeMap);

        // HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Red"); // Duplicate ignored
        System.out.println("HashSet: " + hashSet);
    }
}