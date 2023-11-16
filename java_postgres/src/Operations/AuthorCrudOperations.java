package Operations;

import Entity.Author;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AuthorCrudOperations implements CrudOperations<Author>{
    String userName = System.getenv("DB_USERNAME");
    String password = System.getenv("DB_PASSWORD");
    String databaseName = System.getenv("DB_NAME");
    DataBaseConnection dbConnection = new DataBaseConnection(userName, password, databaseName);
    Connection conn = dbConnection.getConnection();
    public Statement statement;
    @Override
    public List<Author> findAll() {
        List<Author> it = new ArrayList<>();
        Author someAuthor = null;
        try{
            String query = "SELECT * FROM author";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String sex = result.getString("sex");
                someAuthor = new Author(id, name, sex);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return it;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        List<Author> savedAuthors = new ArrayList<>();
        try {
            for (Author author : toSave) {
                String query = "INSERT INTO author (name, sex) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, author.getName());
                preparedStatement.setString(2, author.getSex());

                preparedStatement.executeUpdate();
                savedAuthors.add(author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return savedAuthors;
    }

    @Override
    public Author save(Author toSave) {
        try {
            String query = "INSERT INTO author (name, sex) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setString(2, toSave.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        try {
            String query = "DELETE FROM author WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toDelete.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    }
}
