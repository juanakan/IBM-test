import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/IBM?serverTimezone=UTC";
    private static String username = "root";
    private static String pass = "juanin";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, pass);
        }
        return connection;
    }

}
