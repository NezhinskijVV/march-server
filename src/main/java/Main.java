import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        try {
//            Connection conn = DriverManager.getConnection(
//                    "jdbc:MySQL://localhost:3306/new_schema?serverTimezone=UTC",
//                    "root", "12345678");
//            ResultSet resultSet = conn.prepareStatement("SELECT login, password from User").executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("login"));
//                System.out.println(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        new MyServer().start();
    }
}

