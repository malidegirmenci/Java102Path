import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String name;
    private int totalPage;
    private String author;
    private String releaseDate;
    @Override
    public int compareTo(Book o) {
        return this.getTotalPage() - o.getTotalPage();
    }
    @Override
    public String toString(){
        return "\nName   -> "+this.getName() +
                "\nPage   -> "+this.getTotalPage()+
                "\nAuthor -> "+this.getAuthor()+
                "\nYear   -> "+this.getReleaseDate()+
                "\n**************************************";
    }
    public Book(String name, int totalPage, String author, String releaseDate){
        this.name = name;
        this.totalPage = totalPage;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
