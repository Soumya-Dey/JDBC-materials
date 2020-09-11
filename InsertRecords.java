import java.sql.*;

public class InsertRecords {
    public static void main(String args[]) {
        String tableName, strName, strRoll, strMarks, strGrade;

        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            // droping table before execution
            stmt.execute("drop table if exists JavaCourse");

            // creating new table
            stmt.execute(
                    "create table JavaCourse(Roll integer primary key auto_increment, Name varchar(30), Marks integer not null, Grade char(2))");

            // showing the table
            stmt.execute("show tables");
            ResultSet rs = stmt.getResultSet();
            System.out.println("Tables in the stest database:");
            while (rs.next()) {
                tableName = rs.getString("Tables_in_test_db");
                System.out.println("Table Name: " + tableName);
            }
            System.out.println();

            // inserting records in the table
            stmt.execute(
                    "insert into JavaCourse values (1, 'Sherlock Holmes', 95, 'EX'), (2, 'Prodosh Mitra', 91, 'EX'), (3, 'Hercule Poirot', 75, 'B'), (4, 'Byomkesh Bakshi', 80, 'A'), (5, 'Raja Roychowdhury', 70, 'B')");

            // showing records after inserting
            stmt.execute("select * from JavaCourse");
            rs = stmt.getResultSet();
            System.out.println("Records in JavaCourse table:");
            while (rs.next()) {
                strName = rs.getString("Name");
                strRoll = rs.getString("Roll");
                strMarks = rs.getString("Marks");
                strGrade = rs.getString("Grade");
                System.out.println(
                        "Name: " + strName + "\t Roll: " + strRoll + "\t Marks: " + strMarks + "\t Grade: " + strGrade);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}