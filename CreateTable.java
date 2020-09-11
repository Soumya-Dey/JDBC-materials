import java.sql.*;

public class CreateTable {
    public static void main(String args[]) {
        String tableName;
        // with try resources
        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            System.out.println("Database connected");

            // showing tables before new table creation
            stmt.execute("show tables");

            // getting the results
            ResultSet rs = stmt.getResultSet();
            System.out.println("Results before creating the table");
            while (rs.next()) {
                tableName = rs.getString("Tables_in_test_db");
                System.out.println("Table Name: " + tableName);
            }

            // creating new table
            stmt.execute("drop table if exists JavaCourse");
            stmt.execute(
                    "create table JavaCourse(Roll integer primary key, Name varchar(30), Marks integer not null, Grade char(2))");

            // showing tables after new table creation
            stmt.execute("show tables");

            // getting the results
            rs = stmt.getResultSet();
            System.out.println("Result after creating the table");
            while (rs.next()) {
                tableName = rs.getString("Tables_in_test_db");
                System.out.println("Table Name: " + tableName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
