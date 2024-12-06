package com.example.ericksonmodten;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.*;

public class EricksonModTenController {

    @FXML
    Integer fanId;

    @FXML
    Label welcomeText;

    @FXML
    VBox myVBox;

    @FXML
    VBox vboxContainer;

    @FXML
    TextField fanIdTextField;

    @FXML
    TextField favTeamTextField;


    @FXML
    protected void onDisplayButtonClick() {
        try {
            fanId = Integer.valueOf(fanIdTextField.getText());
            getFan();
        } catch (Exception e) {
            e.printStackTrace();
            Label errorLabel = new Label("Error loading data: " + e.getMessage());
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            vboxContainer.getChildren().add(errorLabel);
        }

    }

    @FXML
    protected void onUpdateButtonClick() {
        updateFavTeam(fanId, favTeamTextField.getText());
    }

    @FXML
    public void initialize() {
        welcomeText.setText(
                """
                        Let's view some of our favorite fans and their favorite teams!

                        - Enter fan's ID and click 'Display' to see the fan's information!
                        - Change a fan's favorite team by entering the new team name and clicking the 'Update' button!
                        - Click 'Display' again after you update favorite teams to view changes!
                """
        );

    }

    private void getFan() {

        vboxContainer.getChildren().clear();

        try {
            FanDAO fanDAO = new FanDAO();
            Fan fan = fanDAO.getFanData(fanId);

            HBox hBox = new HBox();
            hBox.setSpacing(75);
            hBox.setAlignment(Pos.CENTER);
            hBox.setStyle(
                    "-fx-border-style: solid inside;" +
                    "-fx-border-color: orange"
            );
            hBox.setPadding(new Insets(5, 5, 5, 5));

            HBox labelHBox = new HBox();
            labelHBox.setPadding(new Insets(10, 10, 10, 10));
            labelHBox.setStyle(
                    "-fx-border-style: solid inside;" +
                    "-fx-border-color: lightblue"
            );
            labelHBox.setSpacing(50);

            Label firstNameLabel = new Label("First Name: " + fan.getFirstName());
            Label lastNameLabel = new Label("Last Name: " + fan.getLastName());
            Label favoriteTeamLabel = new Label("Favorite Team: " + fan.getFavoriteTeam());

            labelHBox.getChildren().addAll(firstNameLabel, lastNameLabel, favoriteTeamLabel);
            hBox.getChildren().addAll(labelHBox);
            vboxContainer.getChildren().add(hBox);

        } catch (SQLException e) {
            e.printStackTrace();
            Label errorLabel = new Label("Error loading data: " + e.getMessage());
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            vboxContainer.getChildren().add(errorLabel);
        }
    }


    private void updateFavTeam(Integer fanId, String newFavTeam) {
        FanDAO fanDAO = new FanDAO();
        fanDAO.updateFan(fanId, newFavTeam);
        getFan();
        favTeamTextField.setText(null);
    }
}
