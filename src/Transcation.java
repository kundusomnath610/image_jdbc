import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transcation {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "Root_1234";
        String withdrawQuery = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ? ";
        String DepositeQuery = "UPDATE Accounts SET balance = balance + ? WHERE account_number =  ? ";


        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Succesfully");
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successfully");
          
            con.setAutoCommit(false);

            try{
                PreparedStatement withdrawPreparedStatement = con.prepareStatement(withdrawQuery);
                PreparedStatement deposiPreparedStatement = con.prepareStatement(DepositeQuery);
                withdrawPreparedStatement.setDouble(1, 500);
                withdrawPreparedStatement.setString(2, "abc456");

                deposiPreparedStatement.setDouble(1, 1000);
                deposiPreparedStatement.setString(2, "abc123");

                withdrawPreparedStatement.executeUpdate();
                deposiPreparedStatement.executeUpdate();

                con.commit();
                System.out.println("Transcation Successfully");
            } catch (SQLException e) {
                con.rollback();
                System.out.println(e.getMessage());
            }

        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
