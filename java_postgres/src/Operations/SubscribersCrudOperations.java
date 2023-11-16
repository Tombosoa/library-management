package Operations;


import Entity.Subscribers;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SubscribersCrudOperations implements CrudOperations<Subscribers>{
    String userName = System.getenv("DB_USERNAME");
    String password = System.getenv("DB_PASSWORD");
    String databaseName = System.getenv("DB_NAME");
    DataBaseConnection dbConnection = new DataBaseConnection(userName, password, databaseName);
    Connection conn = dbConnection.getConnection();
    public Statement statement;
    @Override
    public List<Subscribers> findAll() {
        List<Subscribers> it = new ArrayList<>();
        Subscribers someSubscribers = null;
        try{
            String query = "SELECT * FROM subscribers";
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String sex = result.getString("sex");
                someSubscribers = new Subscribers(id, name, sex);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return it;
    }

    @Override
    public List<Subscribers> saveAll(List<Subscribers> toSave) {
        List<Subscribers> savedSubscribers = new ArrayList<>();
        try {
            for (Subscribers subscribers : toSave) {
                String query = "INSERT INTO subscribers (name, sex) VALUES (?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, subscribers.getName());
                preparedStatement.setString(2, subscribers.getSex());

                preparedStatement.executeUpdate();
                savedSubscribers.add(subscribers);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return savedSubscribers;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        try {
            String query = "INSERT INTO subscribers (name, sex) VALUES (?, ?)";
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
    public Subscribers delete(Subscribers toDelete) {
        try {
            String query = "DELETE FROM subscribers WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toDelete.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    }
}
