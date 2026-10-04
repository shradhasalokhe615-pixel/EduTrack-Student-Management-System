import java.sql.*;

class StudentDAO
{
    Connection con;

    StudentDAO()
    {
        con = DBConnection.getConnection();
    }

    // ADD STUDENT
    void addStudent(Student s)
    {
        try
        {
            String sql =
                "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, s.id);
            ps.setString(2, s.name);
            ps.setString(3, s.email);
            ps.setString(4, s.phone);
            ps.setString(5, s.course);
            ps.setInt(6, s.year);

            ps.executeUpdate();

            System.out.println("Student added successfully!");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }


    // VIEW ALL STUDENTS
    void viewStudents()
    {
        try
        {
            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n---------------------------------------------------------------");
System.out.printf("%-8s %-15s %-25s %-15s %-5s%n",
                  "ID", "Name", "Email", "Course", "Year");
System.out.println("---------------------------------------------------------------");

while(rs.next())
{
    System.out.printf("%-8d %-15s %-25s %-15s %-5d%n",
                      rs.getInt("id"),
                      rs.getString("name"),
                      rs.getString("email"),
                      rs.getString("course"),
                      rs.getInt("year"));
}

System.out.println("---------------------------------------------------------------");

            rs.close();
            st.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }


    // SEARCH STUDENT
    void searchStudent(int id)
    {
        try
        {
            String sql =
                "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println("\nStudent Found!");
                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("Phone  : " + rs.getString("phone"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("Year   : " + rs.getInt("year"));
            }
            else
            {
                System.out.println("Student not found.");
            }

            rs.close();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }


    // UPDATE STUDENT
    void updateStudent(Student s)
    {
        try
        {
            String sql =
                "UPDATE students SET name=?, email=?, phone=?, course=?, year=? WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, s.name);
            ps.setString(2, s.email);
            ps.setString(3, s.phone);
            ps.setString(4, s.course);
            ps.setInt(5, s.year);
            ps.setInt(6, s.id);

            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("Student not found.");

            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }


    // DELETE STUDENT
    void deleteStudent(int id)
    {
        try
        {
            String sql =
                "DELETE FROM students WHERE id = ?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if(result > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student not found.");

            ps.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}