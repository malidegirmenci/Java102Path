import java.io.PrintStream;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("War and Peace",506,"Lev N. Tolstoy","1866");
        Book book2 = new Book("Anna Karenina",592,"Lev N. Tolstoy","1877");
        Book book3 = new Book("Animal Farm",112,"George Orwell","1945");
        Book book4 = new Book("Zemheri",63,"Fatih Kot","2020");
        Book book5 = new Book("Aylak Adam",192,"Yusuf Atılgan","2019");

        TreeSet<Book> booksSortedByName = new TreeSet<>();
        booksSortedByName.add(book1);
        booksSortedByName.add(book2);
        booksSortedByName.add(book3);
        booksSortedByName.add(book4);
        booksSortedByName.add(book5);
        System.out.println("\nBooks sorted by name: \n");
        System.out.println(booksSortedByName);

        TreeSet<Book> booksSortedByPage = new TreeSet<>((o1, o2) -> o1.getTotalPage() - o2.getTotalPage());

        booksSortedByPage.add(book1);
        booksSortedByPage.add(book2);
        booksSortedByPage.add(book3);
        booksSortedByPage.add(book4);
        booksSortedByPage.add(book5);
        System.out.println("\nBooks sorted by page: \n");
        System.out.println(booksSortedByPage);
    }
}