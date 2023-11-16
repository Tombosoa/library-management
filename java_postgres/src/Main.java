import Operations.DataBaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String userName = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String databaseName = System.getenv("DB_NAME");

        DataBaseConnection dbConnection = new DataBaseConnection(userName, password, databaseName);
        Connection conn = dbConnection.getConnection();

        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
