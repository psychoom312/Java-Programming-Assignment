import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class CollectionsCRUD {
    public static void main(String[] args) {
        
        // 1. ArrayList CRUD (Index-based)
        System.out.println("--- ArrayList CRUD ---");
        List<Student> list = new ArrayList<>();
        list.add(new Student(101, "Alice")); // Create
        list.add(new Student(102, "Bob"));
        System.out.println("Read: " + list); // Read
        list.get(0).name = "Alice Smith";    // Update
        list.remove(1);                      // Delete
        System.out.println("After Update/Delete: " + list);

        // 2. HashMap CRUD (Key-based, Unordered)
        System.out.println("\n--- HashMap CRUD ---");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Java");              // Create
        hashMap.put(2, "Python");
        System.out.println("Read Key 1: " + hashMap.get(1)); // Read
        hashMap.replace(2, "C++");           // Update
        hashMap.remove(1);                   // Delete
        System.out.println("Final Map: " + hashMap);

        // 3. TreeMap CRUD (Key-based, Sorted)
        System.out.println("\n--- TreeMap CRUD ---");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(30, "Large");            // Create
        treeMap.put(10, "Small");
        treeMap.put(20, "Medium");
        System.out.println("Sorted Read: " + treeMap); // Read (Auto-sorted by Key)
        treeMap.put(20, "Extra Medium");     // Update (Overwrites existing key)
        treeMap.pollFirstEntry();            // Delete (Removes smallest key)
        System.out.println("Final Sorted Map: " + treeMap);
    }
}
