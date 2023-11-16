import Entity.Book;
import Operations.BookCrudOperations;
import Operations.DataBaseConnection;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();
        List<Book> booksToSave = new ArrayList<>();
        booksToSave.add(new Book("Harry Potter", 150, "OTHER", LocalDate.parse("1998-08-12"), false));
        booksToSave.add(new Book("The Lord of the Rings", 200, "FANTASY", LocalDate.parse("1988-12-12"), true));

        List<Book> savedBooks = bookCrudOperations.saveAll(booksToSave);
        System.out.println("Books saved: " + savedBooks);
    }
}
