// -- Active: 1707299025167@@127.0.0.1@3306@mydatabase
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Batch_Processing {
    public static void main(String[] args) throws ClassNotFoundException {
        
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Root_1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loded Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successfully");
            connection.setAutoCommit(false);
            String query = ("INSERT INTO employees(name, job_title, salary) VALUES (?, ?, ?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Name: " );
                String name = scanner.nextLine();
                System.out.print("job_title: ");
                String job_title = scanner.nextLine();
                System.out.print("salary: ");
                Double salary = scanner.nextDouble();
                scanner.nextLine();

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, job_title);
                preparedStatement.setDouble(3, salary);

                preparedStatement.addBatch();

                System.out.println("Add more Value Y/N: ");
                String decision = scanner.nextLine();

                if(decision.toUpperCase().equals("N")) {
                    break;
                }

            }

            int[] batchResult = preparedStatement.executeBatch();
            connection.commit();
            System.out.println("Batched run sucessfully");

            
            



            // Statement smt = con.createStatement();
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Raja', 'Sql Developer', 38000)");
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('Sona', 'AWS Developer', 70000)");
            // smt.addBatch("INSERT INTO employees(name, job_title, salary) VALUES('DBC', 'Oracle Developer', 58000)");

            // int[] batchResult = smt.executeBatch();
            // con.commit();
            // System.out.println("Batch Executed!!!");
            

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
