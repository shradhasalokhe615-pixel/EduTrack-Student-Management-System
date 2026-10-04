import java.sql.Connection;

class TestConnection
{
    public static void main(String args[])
    {
        Connection con = DBConnection.getConnection();

        if(con != null)
        {
            System.out.println("Connection test successful!");
        }
    }
}