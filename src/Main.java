import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/mydb"; // Your DB name!
    private static final String username = "root";
    private static final String password = "18110229";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the JDBC driver. Error: " + e.getMessage());
        }

        try {
                Connection connection = DriverManager.getConnection(url, username, password);

//             Statement statement = connection.createStatement()) {
                // ADD Data
//            String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s' , %o, %f)","RC", 25,87.5);
//
//
//            int rowsAffected  = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Inserted Successfully");
//            }else{
//                System.out.println("Data Not Inserted");
//            }

            // Update Data
//            String query = String.format("UPDATE students SET MARKS = %f  WHERE id = %d", 89.5 ,2);
//            int rowsAffected  = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Updated Successfully !!");
//            }else{
//                System.out.println("Data Not Updated !!");
//            }

            // show data
//            while (resultSet.next()) {
//                int id  = resultSet.getInt("id");
//                String name  = resultSet.getString("name");
//                int age  = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("AGE: " + age);
//                System.out.println("MARKS: " + marks);
//            }
            // Delete Data
//            String query = "DELETE FROM students WHERE ID =2 ";
//            int rowsAffected  = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data DELETED Successfully !!");
//            }else{
//                System.out.println("Data Not Deleted !!");
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }


             //ADD Data  with prepared Statements

//            String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setString(1, "AC");
//            preparedStatement.setInt(2, 34);
//            preparedStatement.setDouble(3, 85.85);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Data Inserted Successfully!!");
//            } else {
//                System.out.println("Data Not Inserted!!");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
            // Data Retrive with prepared Statements
//            String query = "SELECT marks FROM students WHERE id =? ";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            preparedStatement.setInt(1, 1);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                double marks = resultSet.getDouble("marks");
//                System.out.println("Marks:"+ marks );
//            }else {
//                System.out.println("Marks Not Found!!");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

            // Update Studentns prepared Statements

//            String query = "UPDATE students SET marks =? WHERE id =?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setDouble(1,67);
//            preparedStatement.setInt(2,3);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected>0){
//                System.out.println("Data Updated Sucesfully ");
//            }else {
//                System.out.println("Data Not Updated !!");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }


        // Delete data with
//        String query = "DELETE  students SET marks =? WHERE id =?";
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setDouble(1,67);
//        preparedStatement.setInt(2,3);
//
//        int rowsAffected = preparedStatement.executeUpdate();
//        if (rowsAffected>0){
//            System.out.println("Data Updated Sucesfully ");
//        }else {
//            System.out.println("Data Not Updated !!");
//        }
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//    }

        // Batch patching
//            Statement statement = connection.createStatement();
//            Scanner scanner = new Scanner(System.in);
//            while (true){
//                System.out.print("Enter name : ");
//                String name =scanner.next();
//                System.out.print("Enter age : ");
//                int age =scanner.nextInt();
//                System.out.print("Enter marks : ");
//                double marks =scanner.nextDouble();
//                System.out.println("Enter more Data(Y/N): ");
//                String choice = scanner.next();
//                String query = String.format("INSERT INTO students (name,age,marks) VALUES ('%s', %d ,%f)");
//
//                statement.addBatch(query);
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//            int[] arr = statement.executeBatch();
//            for (int i =0; i<arr.length; i++){
//                if(arr[i]==0){
//                    System.out.println("Querry:"+i+ " not executed Successfully !!!!!");
//                }
//            }
//
//
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//    }


                    //Batch patching with prepprepared Statements
            String query = String.format("INSERT INTO students (name,age,marks) VALUES (?, ? ,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.print("Enter name : ");
                String name =scanner.next();
                System.out.print("Enter age : ");
                int age =scanner.nextInt();
                System.out.print("Enter marks : ");
                double marks =scanner.nextDouble();
                System.out.println("Enter more Data(Y/N): ");
                String choice = scanner.next();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);
                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr = preparedStatement.executeBatch();
            for (int i =0; i<arr.length; i++){
                if(arr[i]==0){
                    System.out.println("Querry:"+i+ " not executed Successfully !!!!!");
                }
            }


    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
