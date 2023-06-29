import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", 150, "Author 1","01-01-2020"));
        books.add(new Book("Book 2", 250, "Author 2","01-05-2020"));
        books.add(new Book("Book 3", 350, "Author 3","01-11-2023"));
        books.add(new Book("Book 4", 150, "Author 4","06-01-2020"));
        books.add(new Book("Book 5", 170, "Author 5","06-06-2019"));
        books.add(new Book("Book 6", 220, "Author 6","07-06-2020"));
        books.add(new Book("Book 7", 350, "Author 7","01-05-2012"));
        books.add(new Book("Book 8", 160, "Author 8","01-01-2023"));
        books.add(new Book("Book 9", 320, "Author 9","01-6-2020"));
        books.add(new Book("Book 10", 550, "Author 10","11-01-2023"));

        Map<String, String> map = new TreeMap<>();
        books.forEach(book -> map.put(book.getName(), book.getAuthorName()));
        map.forEach((name, author) -> System.out.println("Book name: "+ name + ", Author: "+ author));

        List<Book> books1 = books.stream().filter(book -> book.getPageCount() > 200).toList();
        System.out.println("\nBooks with more than 200 pages:");
        books1.forEach(book -> System.out.println("Book Name: "+book.getName() + ", Page Count: "+ book.getPageCount()));
    }
}