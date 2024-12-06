// Austen Rhyce Erickson
// Java 3 Module 10
// 12/05/2024
// Task:
// Write a program that views and updates fan information stored in a database
//  - db: databasedb
//  - userId: student1
//  - password: pass
//  - table: fans
//   - columns:
//       - id
//       - firstname
//       - lastname
//       - favoriteteam
// Interface:
//  - display button: gets fan by id from database and displays on screen
//  - update button: sets new favorite team for fan in database and re-retrieves updated fan from database
//  - text field for fan id
//  - text field for new favorite team

package com.example.ericksonmodten;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EricksonModTen extends Application {

//   boilerplate code for starting JavaFx application
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EricksonModTen.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 810, 500);
        stage.setTitle("EricksonModTen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
