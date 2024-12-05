//package com.example.ericksonmodten;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class FanTable {
//    public static void main(String[] args) {
//
//    }
//
//}
//
////class CreateTable {
////
////    Connection con;
////
////    Statement stmt;
////
////    public CreateTable() {
////
////        try {
////
////            Class.forName("com.mysql.cj.jdbc.Driver");
////
////            String url = "jdbc:mysql://localhost:3306/databasedb?";
////
////            con = DriverManager.getConnection(url + "user=student1&password=pass");
////
////            stmt = con.createStatement();
////        } catch (Exception e) {
////
////            System.out.println("Error connection to database.");
////            System.exit(0);
////        }
////
////        try {
////
////            stmt.executeUpdate("DROP TABLE address33");
////            System.out.println("Table address Dropped");
////        } catch (SQLException e) {
////
////            System.out.println("Table address does not exist");
////        }
////
////        try {
////
////            stmt.executeUpdate("CREATE TABLE address2(ID int PRIMARY KEY,LASTNAME varchar(40)," +
////                    "FIRSTNAME varchar(40), STREET varchar(40), CITY varchar(40), STATE varchar(40)," +
////                    "ZIP varchar(40))");
////            System.out.println("Table address Created");
////        } catch (SQLException e) {
////
////            System.out.println("Table address Creation failed");
////        }
////
////        try {
////
////            stmt.close();
////
////            con.close();
////            System.out.println("Database connections closed");
////        } catch (SQLException e) {
////
////            System.out.println("Connection close failed");
////        }
////    }
////}
////
////class InsertData{
////
////    Connection con;
////
////    Statement stmt;
////    public InsertData(){
////
////        try{
////
////            Class.forName("com.mysql.cj.jdbc.Driver");
////
////            String url = "jdbc:mysql://localhost:3306/databasedb?";
////
////            con = DriverManager.getConnection(url + "user=student1&password=pass");
////
////            stmt = con.createStatement();
////        }
////        catch(Exception e){
////
////            System.out.println("Error connection to database.");
////            System.exit(0);
////        }
////
////        try{
////
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(55,'Larry','Rich','1111 Redwing Circle888','Bellevue','NE','68123')") + "row updated");
////
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(1,'Fine','Ruth','1111 Redwing Circle','Bellevue','NE','68123')") + "row updated");
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(2,'Howard','Curly','1000 Galvin Road South','Bellevue','NE','68005')") + "row updated");
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(3,'Howard','Will','2919 Redwing Circle','Bellevue','NE','68123')") + "row updated");
////
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(4,'Wilson','Larry','1121 Redwing Circle','Bellevue','NE','68124')") + "row updated");
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(5,'Johnson','George','1300 Galvin Road South','Bellevue','NE','68006')") + "row updated");
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(6,'Long','Matthew','2419 Redwing Circle','Bellevue','NE','68127')") + "row updated");
////
////            System.out.println(
////                    stmt.executeUpdate("INSERT INTO address2 VALUES(44,'Tom','Matthew','1999 Redwing Circle','Bellevue','NE','68123')") + "row updated");
////
////            stmt.executeUpdate("COMMIT");
////
////            System.out.println("Data Inserted");
////        }
////        catch(SQLException e){
////
////            System.out.println(e);
////            System.out.println("Insert Data Failed");
////        }
////
////        try{
////
////            stmt.close();
////
////            con.close();
////            System.out.println("Database connections closed");
////        }
////        catch(SQLException e){
////
////            System.out.println("Connection close failed");
////        }
////    }
////}
