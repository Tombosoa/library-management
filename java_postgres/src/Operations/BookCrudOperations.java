package Operations;

import Entity.Book;

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
    List<Book> it = new ArrayList<>();
    Book someBook = null;
    try{
        String query = "SELECT * FROM book";
        statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()){
            int id = result.getInt("id");
            String bookName = result.getString("bookname");
            int bookNumbers = result.getInt("pagenumbers");
            LocalDate releaseDate = result.getDate("releasedate").toLocalDate();
            String topic = result.getString("topic");
            boolean status = result.getBoolean("status");

            someBook = new Book(id, bookName, bookNumbers, topic,releaseDate, status);
        }
    }catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return it;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        List<Book> savedBooks = new ArrayList<>();
        try {
            for (Book book : toSave) {
                String query = "INSERT INTO book (bookName, pageNumbers, releaseDate, topic, status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setInt(2, book.getPageNumbers());
                preparedStatement.setDate(3, java.sql.Date.valueOf(book.getReleaseDate()));
                preparedStatement.setString(4, book.getTopic());
                preparedStatement.setBoolean(5, book.isStatus());
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
            String query = "INSERT INTO book (bookName, pageNumbers, releaseDate, topic, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toSave.getBookName());
            preparedStatement.setInt(2, toSave.getPageNumbers());
            preparedStatement.setDate(3, java.sql.Date.valueOf(toSave.getReleaseDate()));
            preparedStatement.setString(4, toSave.getTopic());
            preparedStatement.setBoolean(5, toSave.isStatus());
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
