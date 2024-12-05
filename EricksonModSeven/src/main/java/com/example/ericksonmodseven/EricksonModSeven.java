// Austen Rhyce Erickson
// Java 3 Module 7
// 11/22/2024
// Task:
// - Create a CSS style sheet that defines a class for white fill and black stroke
//   and an ID for red and green color
// - Write a program that displays four circles and uses the style class and ID
package com.example.ericksonmodseven;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EricksonModSeven extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//      define a group component
        Group myGroup = new Group();

//      create circles with appropriate spacing
        Circle myFirstCircle = new Circle(120.0f, 250.0f, 80.f);
        Circle mySecondCircle = new Circle(310.0f, 250.0f, 80.f);
        Circle myThirdCircle = new Circle(500.0f, 250.0f, 80.f);
        Circle myFourthCircle = new Circle(690.0f, 250.0f, 80.f);

//      tie css rules to their respective circles
        myFirstCircle.getStyleClass().add("plaincircle");
        myFirstCircle.getStyleClass().add("circleborder");
        mySecondCircle.getStyleClass().add("plaincircle");
        mySecondCircle.getStyleClass().add("circleborder");
        myThirdCircle.setId("redcircle");
        myFourthCircle.setId("greencircle");

//      the circles are ready, add them to the group
        myGroup.getChildren().add(myFirstCircle);
        myGroup.getChildren().add(mySecondCircle);
        myGroup.getChildren().add(myThirdCircle);
        myGroup.getChildren().add(myFourthCircle);

//      set scene, load stylesheet, set title, load scene to the stage and show
        Scene scene = new Scene( myGroup, 810, 500);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
        stage.setTitle("EricksonModSeven");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
