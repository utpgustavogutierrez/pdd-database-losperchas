import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sakila {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from film");
            while(rs.next()) {
                // read the result set
                System.out.println("title = " + rs.getString("title"));
            }
        } catch(SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}