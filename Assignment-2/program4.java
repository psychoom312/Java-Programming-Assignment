import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String title;
    double price;

    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %-15s | Price: %.2f", id, title, price);
    }
}

class PriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Double.compare(b1.price, b2.price);
    }
}

public class BookSortingSystem {
    public static void main(String[] args) {
        List<Book> library = new ArrayList<>();
        library.add(new Book(103, "Java Mastery", 599.99));
        library.add(new Book(101, "Python Basics", 299.50));
        library.add(new Book(105, "C++ Guide", 450.00));
        library.add(new Book(102, "Algorithms", 800.00));

        System.out.println("--- Original List ---");
        library.forEach(System.out::println);

        Collections.sort(library);
        System.out.println("\n--- Sorted by ID (Comparable) ---");
        library.forEach(System.out::println);

        Collections.sort(library, new PriceComparator());
        System.out.println("\n--- Sorted by Price (Comparator Class) ---");
        library.forEach(System.out::println);

        library.sort((b1, b2) -> b1.title.compareTo(b2.title));
        System.out.println("\n--- Sorted by Title (Lambda Comparator) ---");
        library.forEach(System.out::println);
    }
}
