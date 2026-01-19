import java.sql.*;

// Meharin Choudhury
// IT23040

public class PrintMessage {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_db";
        String user = "root";
        String password = "12345678";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM messages");

            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Sender: "+rs.getString("sender"));
                System.out.println("Message: "+rs.getString("message"));
                System.out.println("===================\n");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
