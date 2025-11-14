import java.util.ArrayList;

public class ArrayListGrowth {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(4); // Initial capacity = 4

        // Adding 5 elements to exceed initial capacity
        list.add("A1");
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5"); // Triggers capacity increase

        System.out.println("ArrayList size after adding 5 elements: " + list.size());

        // Capacity is not directly accessible, but we can infer it using reflection
        try {
            java.lang.reflect.Field dataField = ArrayList.class.getDeclaredField("elementData");
            dataField.setAccessible(true);
            Object[] internalArray = (Object[]) dataField.get(list);
            System.out.println("ArrayList internal capacity after exceeding: " + internalArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}