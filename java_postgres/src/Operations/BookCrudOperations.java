package Operations;

import Entity.Author;
import Entity.Book;
import Entity.Subscribers;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>{
    String userName = System.getenv("DB_USERNAME");
    String password = System.getenv("DB_PASSWORD");
    String databaseName = System.getenv("DB_NAME");
    DataBaseConnection dbConnection = new DataBaseConnection(userName, password, databaseName);
    Connection conn = dbConnection.getConnection();
    public Statement statement;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            String query = "SELECT b.id, b.bookname, b.pagenumbers, b.topic, b.releasedate, b.status, a.name AS author_name " +
                    "FROM Book b " +
                    "INNER JOIN author a ON b.id_author = a.id " ;
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                int id = result.getInt("id");
                String bookName = result.getString("bookname");
                int pageNumbers = result.getInt("pagenumbers");
                String topic = result.getString("topic");
                LocalDate releaseDate = result.getDate("releasedate").toLocalDate();
                boolean status = result.getBoolean("status");
                String authorName = result.getString("author_name");
                //String subscriberName = result.getString("subscriber_name");


              //  Subscribers subscriber = new Subscribers(subscriberName);

                Book book = new Book(id, bookName, pageNumbers, topic, releaseDate, status, authorName);
              //  book.addBorrowers(subscriber);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        List<Book> savedBooks = new ArrayList<>();
        try {
            for (Book book : toSave) {
                String query = "INSERT INTO book (bookName, pageNumbers, releaseDate, topic, status, id_author) VALUES (?,?, ?, ?, ?, ?::uuid)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setInt(2, book.getPageNumbers());
                preparedStatement.setDate(3, java.sql.Date.valueOf(book.getReleaseDate()));
                preparedStatement.setString(4, book.getTopic());
                preparedStatement.setBoolean(5, book.isStatus());
                preparedStatement.setString(6, book.getIdAuthor());
                preparedStatement.executeUpdate();
                savedBooks.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return savedBooks;
    }

    @Override
    public Book save(Book toSave) {
        try {
            String query = "INSERT INTO book (bookName, pageNumbers, releaseDate, topic, status, id_author) VALUES (?, ?, ?, ?, ?, ?::uuid)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toSave.getBookName());
            preparedStatement.setInt(2, toSave.getPageNumbers());
            preparedStatement.setDate(3, java.sql.Date.valueOf(toSave.getReleaseDate()));
            preparedStatement.setString(4, toSave.getTopic());
            preparedStatement.setBoolean(5, toSave.isStatus());
            preparedStatement.setString(6, toSave.getIdAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        try {
            String query = "DELETE FROM book WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, toDelete.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    }
}
