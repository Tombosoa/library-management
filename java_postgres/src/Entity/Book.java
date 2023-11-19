package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book extends CrupdateBook{

    private String idAuthor;
    private boolean status;
    private Author author;
    private String name;
    private List<Subscribers> borrowers;

    public Book(int id, String bookName, int pageNumbers, String topic, LocalDate releaseDate, boolean status, String name) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Book(int id, String bookName, int pageNumbers, String topic, LocalDate releaseDate) {
        super(id, bookName, pageNumbers, topic, releaseDate);
    }

    public Book(String bookName, int pageNumbers, String topic, LocalDate releaseDate, String idAuthor, boolean status) {
        super(bookName, pageNumbers, topic, releaseDate);
        this.idAuthor = idAuthor;
        this.status = status;
    }

    public Book(int id, String bookName, int pageNumbers, String topic, LocalDate releaseDate, boolean status, Author author, List<Subscribers> borrowers) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.status = status;
        this.author = author;
        this.borrowers = new ArrayList<>();
    }

    public Book(int id, String bookName, int pageNumbers, String topic, LocalDate releaseDate, boolean status) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.status = status;
    }

    public Book(String bookName, int pageNumbers, String topic, LocalDate releaseDate, boolean status) {
        super(bookName, pageNumbers, topic, releaseDate);
        this.status = status;
    }



    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Subscribers> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Subscribers> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBorrowers(Subscribers borrower){
        this.borrowers.add(borrower);
    }

    @Override
    public String toString() {
        return "\n"+
                "bookName='" + getBookName() + '\'' + "\n" +
                "pageNumbers=" + getPageNumbers() + "\n" +
                "topic='" + getTopic() + '\'' + "\n" +
                "releaseDate='" + getReleaseDate() + '\'' + "\n"+
                "AuthorName='"+ name +'\''+ "\n"+
                "--------------------------" + "\n";
    }
}
