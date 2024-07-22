import java.sql.*;

public class MySQLConnection {

    public static void main(String[] args) throws Exception {
        // Create a connection to the MySQL database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");

        // Create a statement object
        Statement statement = connection.createStatement();

        // Execute a SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

        // Iterate over the result set and print the results
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }

        // Close the connection
        connection.close();
    }
}
