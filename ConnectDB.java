import java.sql.*;

public class ConnectDB {
    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password)) {
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
