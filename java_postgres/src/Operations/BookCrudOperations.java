package Operations;

import Entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return null;
    }

    @Override
    public Book save(Book toSave) {
        return null;
    }

    @Override
    public Book delete(Book toDelete) {
        return null;
    }
}
