import java.sql.*;

class MarksDAO
{
    Connection con;

    MarksDAO()
    {
        con = DBConnection.getConnection();
    }

    // ADD MARKS
    void addMarks(Marks m)
    {
        try
        {
            String sql =
                "INSERT INTO marks (student_id, subject, marks) VALUES (?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, m.studentId);
            ps.setString(2, m.subject);
            ps.setInt(3, m.marks);

            ps.executeUpdate();

            System.out.println("Marks added successfully!");

            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }

    // VIEW RESULT
    void viewResult(int studentId)
    {
        try
        {
            String sql =
                "SELECT s.name, m.subject, m.marks " +
                "FROM students s " +
                "JOIN marks m ON s.id = m.student_id " +
                "WHERE s.id = ?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            int total = 0;
            int count = 0;
            String studentName = "";

            System.out.println("\n--------------------------------");
            System.out.println("           STUDENT RESULT");
            System.out.println("--------------------------------");

            while(rs.next())
            {
                studentName = rs.getString("name");

                System.out.println(
                    rs.getString("subject") +
                    " : " +
                    rs.getInt("marks")
                );

                total = total + rs.getInt("marks");
                count++;
            }

            if(count == 0)
            {
                System.out.println("No marks found for this student.");
            }
            else
            {
                double percentage =
                    (double) total / count;

                System.out.println("--------------------------------");
                System.out.println("Student     : " + studentName);
                System.out.println("Total       : " + total);
                System.out.println("Percentage  : " + percentage + "%");
                System.out.println("--------------------------------");
            }

            rs.close();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
// UPDATE MARKS
void updateMarks(int studentId, String subject, int newMarks)
{
    try
    {
        String sql =
            "UPDATE marks SET marks = ? WHERE student_id = ? AND subject = ?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setInt(1, newMarks);
        ps.setInt(2, studentId);
        ps.setString(3, subject);

        int result = ps.executeUpdate();

        if(result > 0)
            System.out.println("Marks updated successfully!");
        else
            System.out.println("Marks record not found.");

        ps.close();
    }
    catch(Exception e)
    {
        System.out.println("Error: " + e);
    }
}
// DELETE MARKS
void deleteMarks(int studentId, String subject)
{
    try
    {
        String sql =
            "DELETE FROM marks WHERE student_id = ? AND subject = ?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setInt(1, studentId);
        ps.setString(2, subject);

        int result = ps.executeUpdate();

        if(result > 0)
            System.out.println("Marks deleted successfully!");
        else
            System.out.println("Marks record not found.");

        ps.close();
    }
    catch(Exception e)
    {
        System.out.println("Error: " + e);
    }
}
}