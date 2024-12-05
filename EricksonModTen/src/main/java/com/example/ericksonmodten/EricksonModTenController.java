package com.example.ericksonmodten;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.sql.*;
import java.util.List;

public class EricksonModTenController {

    @FXML
    Label welcomeText;

    @FXML
    VBox myVBox;

    @FXML
    VBox vboxContainer;

    @FXML
    protected void onHelloButtonClick() {
        getFanData();
    }

//    @FXML
//    public void initialize() {
//        fanFirstName.setCellValueFactory(new PropertyValueFactory<>("fanFirstName"));
//        fanLastName.setCellValueFactory(new PropertyValueFactory<>("fanLastName"));
//        fanFavoriteTeam.setCellValueFactory(new PropertyValueFactory<>("fanFavoriteTeam"));
//
////        loadData();
//        getFanData();
//    }

    @FXML
    public void initialize() {
        welcomeText.setText("Let's view some of our favorite characters and their favorite teams!\n\nClick 'Display' to see the characters\nClick an 'Update' button to change a character's favorite team!\nClick 'Refresh' after you update favorite teams to display again to view changes!");
    }

    private void getFanData() {

        vboxContainer.getChildren().clear();

        try {
            FanDAO fanDAO = new FanDAO();
            List<Fan> fans = fanDAO.getAllFans();
            for(Fan fan: fans) {

                HBox hBox = new HBox();
                hBox.setSpacing(75);
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setStyle(
                        "-fx-border-style: solid inside;" +
                        "-fx-border-color: orange"
                );
                hBox.setPadding(new Insets(5, 5, 5, 5));

                VBox labelVBox = new VBox();
                labelVBox.setPadding(new Insets(5, 5, 5, 5));
                labelVBox.setStyle(
                        "-fx-border-style: solid inside;" +
                        "-fx-border-color: lightblue"
                );

                Label firstNameLabel = new Label("First Name: " + fan.getFirstName());
                Label lastNameLabel = new Label("Last Name: " + fan.getLastName());
                Label favoriteTeamLabel = new Label("Favorite Team: " + fan.getFavoriteTeam());

                Button updateButton = new Button("Update Team");
                updateButton.setStyle("-fx-background-color: lightblue;");

                labelVBox.getChildren().addAll(firstNameLabel, lastNameLabel, favoriteTeamLabel);

//                BorderPane borderPane = new BorderPane();
//                borderPane.setStyle(
//                        "-fx-border-style: solid inside;" +
//                                "-fx-border-color: orange"
//                );
//                borderPane.setLeft(labelVBox);
//                borderPane.setCenter(updateButton);

                hBox.getChildren().addAll(labelVBox, updateButton);
                updateButton.setOnAction(event -> handleButtonClick(fan, hBox));
//                updateButton.setOnAction(event -> handleButtonClick(fan, borderPane));


//                HBox hbox = addHBox()
//                border.setTop(hbox);
//                border.setLeft(addVBox());
//                addStackPane(hbox);         // Add stack to HBox in top region
//
//                border.setCenter(addGridPane());
//                border.setRight(addFlowPane());

                vboxContainer.getChildren().add(hBox);
//                vboxContainer.getChildren().add(borderPane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Label errorLabel = new Label("Error loading data: " + e.getMessage());
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            vboxContainer.getChildren().add(errorLabel);
        }
    }

    private void handleButtonClick(Fan fan, HBox hBox) {
//private void handleButtonClick(Fan fan, BorderPane borderPane) {
        System.out.println("Button clicked for User ID: " + fan.getId());
        VBox aVBox = new VBox();
        aVBox.setSpacing(5);
        TextField textField = new TextField();
        Button submitButton = new Button("submit");
        submitButton.setOnAction(event -> handleSubmit(fan, textField, aVBox, hBox));
//    submitButton.setOnAction(event -> handleSubmit(fan, textField, aVBox, borderPane));
        aVBox.getChildren().addAll(textField, submitButton);
//        borderPane.setRight(aVBox);
        hBox.getChildren().add(aVBox);
    }

    private void handleSubmit(Fan fan, TextField textField, VBox aVbox, HBox hBox) {
//private void handleSubmit(Fan fan, TextField textField, VBox aVbox, BorderPane borderPane) {
        fan.setFavoriteTeam(textField.getText());
        FanDAO fanDAO = new FanDAO();
        fanDAO.updateFan(fan);
        hBox.getChildren().remove(aVbox);
//    borderPane.setRight(null);
    }
}
