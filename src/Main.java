/*////////////////////////////////////////////////////////////////////////////////////////
IMAGE INSERT IN DATABASE AND EXTRACT FROM DATABASE IN JDBC
*////////////////////////////////////////////////////////////////////////////////////////


import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String Password = "Root_1234";
        //String image_path = "/Users/somnathkundu/Desktop/Intellij JAVA/pexels-photo-674010.jpeg";
        String Folder_Path = "/Users/somnathkundu/Desktop/Intellij JAVA/";
        //String Query = "INSERT INTO image_table(image_data) VALUES(?)";
        String Query = "Select image_data from image_table where image_id = (?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, Password);
            System.out.println("Connection Successfully");
//            FileInputStream fileInputstream = new FileInputStream(image_path);
//            byte[] imageData = new byte[fileInputstream.available()];
//            fileInputstream.read(imageData);
//            PreparedStatement preparedStatement = con.prepareStatement(Query);
//            preparedStatement.setBytes(1, imageData);
//            int affectedRow = preparedStatement.executeUpdate();
//
//            if(affectedRow > 0) {
//                System.out.println("Insert Complete");
//            } else {
//                System.out.println("Insert Not Complete");
//            }

            PreparedStatement preparedStatement = con.prepareStatement(Query);
            Statement smt = con.createStatement();
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                byte[] image_data = resultSet.getBytes("image_data");
                String image_path = Folder_Path + "New_Image.jpg";
                OutputStream outputStream = new FileOutputStream(image_path);
                outputStream.write(image_data);
                System.out.println("Image extract Successfully");
            } else {
                System.out.println("Image Not Found");
            }




        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}