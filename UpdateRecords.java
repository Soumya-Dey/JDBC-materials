import java.sql.*;

public class UpdateRecords {
    public static void main(String[] args) {
        String strName, strRoll, strMarks, strGrade;

        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            // showing records before update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse BEFORE update: ");
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

            // performing update
            stmt.execute("update javacourse set Marks=85, Grade='A' where Roll=5");
            stmt.execute("update javacourse set Marks=70, Grade='B' where Roll=3");
            stmt.execute("update javacourse set Marks=65, Grade='C' where Roll=7");

            // showing records after update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse AFTER update: ");
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
