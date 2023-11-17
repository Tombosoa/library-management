import Entity.Book;
import Operations.AuthorCrudOperations;
import Operations.BookCrudOperations;
import Operations.SubscribersCrudOperations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        SubscribersCrudOperations subscribersCrudOperations = new SubscribersCrudOperations();
       /* List<Book> booksToSave = new ArrayList<>();
        booksToSave.add(new Book("Harry Potter", 150, "OTHER", LocalDate.parse("1998-08-12"), "ecf5695d-9b3b-4221-804f-6552fcacad4b",false ));
        booksToSave.add(new Book("The Lord of the Rings", 200, "FANTASY", LocalDate.parse("1988-12-12"),  "ecf5695d-9b3b-4221-804f-6552fcacad4b",true));

        List<Book> savedBooks = bookCrudOperations.saveAll(booksToSave);
        System.out.println("Books saved: " + savedBooks);*/
        /*List<Author> authorsToSave = new ArrayList<>();
        authorsToSave.add(new Author("Rabe", "M"));
        authorsToSave.add(new Author("Raly", "F"));

        List<Author> savedAuthors = authorCrudOperations.saveAll(authorsToSave);
        System.out.println("Author saved: " + savedAuthors);*/
        /*List<Subscribers> subscribersToSave = new ArrayList<>();
        subscribersToSave.add(new Subscribers("Didi", "M"));
        subscribersToSave.add(new Subscribers("Vivi", "F"));

        List<Subscribers> savedSubscribers = subscribersCrudOperations.saveAll(subscribersToSave);
        System.out.println("Subscribers saved: " + savedSubscribers);*/

        /*Book bookToSave = new Book("The Hobbit", 200, "COMEDY",LocalDate.parse("1995-11-12"), "9be5cfd5-d4ba-4656-a0c2-1419c4093f48",true);
        Book savedBook = bookCrudOperations.save(bookToSave);
        System.out.println("Book saved: " + savedBook);*/

        /*Book bookToDelete = new Book(5,"The Hobbit", 200, "COMEDY",LocalDate.parse("1995-11-12"), true);
        Book deletedBook = bookCrudOperations.delete(bookToDelete);
        System.out.println("Book deleted: " + deletedBook);*/

        System.out.println("there are the list of books: " + "\n" + bookCrudOperations.findAll());
        //System.out.println("there are the list of authors: " + "\n" + authorCrudOperations.findAll());
        //System.out.println("there are the list of subscribers: " + "\n" + subscribersCrudOperations.findAll());
    }
}
