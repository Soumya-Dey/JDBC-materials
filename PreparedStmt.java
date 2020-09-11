import java.sql.*;
import java.util.*;

public class PreparedStmt {
    public static void main(String[] args) {
        // vars for getting values from user
        String name, grade;
        int marks;

        try (Connection conn = DriverManager.getConnection(UserUrlInfo.dbUrl, UserUrlInfo.userName,
                UserUrlInfo.password); Statement stmt = conn.createStatement();) {
            // showing records before update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse BEFORE update: ");
            System.out.println("---------------------------------------------------------------------\n");
            stmt.execute("select * from JavaCourse");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("Name") + "\t Roll: " + rs.getString("Roll") + "\t Marks: "
                        + rs.getString("Marks") + "\t Grade: " + rs.getString("Grade"));
            }
            System.out.println();

            // inserting records using a prepared statement
            Scanner sc = new Scanner(System.in);
            int answer;
            do {
                System.out.print("Enter Name: ");
                name = sc.nextLine();
                System.out.print("Enter Marks: ");
                marks = sc.nextInt();
                grade = (marks >= 90) ? "EX"
                        : ((marks >= 75) ? "A+" : ((marks >= 60) ? "A" : ((marks >= 50) ? "B" : "C")));

                String qryString = "insert into JavaCourse (Name, Marks, Grade) values (?, ?, ?)";

                // preparing the query
                PreparedStatement pstmt = conn.prepareStatement(qryString);
                pstmt.setString(1, name);
                pstmt.setInt(2, marks);
                pstmt.setString(3, grade);

                // executing the query
                pstmt.executeUpdate();

                System.out.print("More Records:(1. Yes, 2. No): ");
                answer = sc.nextInt();
                sc.nextLine();
            } while (answer == 1);
            sc.close();

            // showing records after update
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Contents of javacourse AFTER update: ");
            System.out.println("---------------------------------------------------------------------\n");
            stmt.execute("select * from JavaCourse");
            rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("Name") + "\t Roll: " + rs.getString("Roll") + "\t Marks: "
                        + rs.getString("Marks") + "\t Grade: " + rs.getString("Grade"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
