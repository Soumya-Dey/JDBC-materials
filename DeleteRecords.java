import java.sql.*;

public class DeleteRecords {
    public static void main(String[] args) {
        String strName, strRoll, strMarks, strGrade;

        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            // showing records before update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse BEFORE delete: ");
            System.out.println("---------------------------------------------------------------------\n");
            stmt.execute("select * from JavaCourse");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                strName = rs.getString("Name");
                strRoll = rs.getString("Roll");
                strMarks = rs.getString("Marks");
                strGrade = rs.getString("Grade");
                System.out.println(
                        "Name: " + strName + "\t Roll: " + strRoll + "\t Marks: " + strMarks + "\t Grade: " + strGrade);
            }
            System.out.println();

            // performing delete
            stmt.execute("delete from JavaCourse where Marks < 66");

            // showing records after update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse AFTER delete: ");
            System.out.println("---------------------------------------------------------------------\n");
            stmt.execute("select * from JavaCourse");
            rs = stmt.getResultSet();
            while (rs.next()) {
                strName = rs.getString("Name");
                strRoll = rs.getString("Roll");
                strMarks = rs.getString("Marks");
                strGrade = rs.getString("Grade");
                System.out.println(
                        "Name: " + strName + "\t Roll: " + strRoll + "\t Marks: " + strMarks + "\t Grade: " + strGrade);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
