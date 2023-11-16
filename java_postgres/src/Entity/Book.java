package Entity;

import java.util.ArrayList;
import java.util.List;

public class Book extends CrupdateBook{

    private boolean status;
    private Author author;

    private List<Visitor> borrowers;


    public Book(int id, String bookName, int pageNumbers, String topic, String releaseDate) {
        super(id, bookName, pageNumbers, topic, releaseDate);
    }

    public Book(int id, String bookName, int pageNumbers, String topic, String releaseDate, boolean status, Author author, List<Visitor> borrowers) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.status = status;
        this.author = author;
        this.borrowers = new ArrayList<>();
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

    public List<Visitor> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Visitor> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBorrowers(Visitor borrower){
        this.borrowers.add(borrower);
    }
}
