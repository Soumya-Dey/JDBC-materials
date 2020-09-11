import java.sql.*;

public class AvgMarks {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            System.out.println("Contents of javacourse: ");
            System.out.println("---------------------------------------------------------------------\n");
            stmt.execute("select * from JavaCourse");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("Name") + "\t Roll: " + rs.getString("Roll") + "\t Marks: "
                        + rs.getString("Marks") + "\t Grade: " + rs.getString("Grade"));
            }
            System.out.println();

            stmt.execute("select round(avg(Marks), 2) as Average_marks from javacourse");
            rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("Average_marks: " + rs.getString("Average_marks"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
