package com.example.ericksonmodten;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.*;

public class EricksonModTenController {

//  instantiate variables to be used in program
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

//  function to be called when user wants to view a fan
    @FXML
    protected void onDisplayButtonClick() {
        try {
//          update the fanId to current user input
            fanId = Integer.valueOf(fanIdTextField.getText());
//          if the current user input is valid, look for the fan in database
            getFan();
        } catch (Exception e) {
//          for invalid user input, display error
            e.printStackTrace();
            Label errorLabel = new Label("Error loading data: " + e.getMessage());
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            vboxContainer.getChildren().add(errorLabel);
        }
    }

//  function to be called when user wants to save an update
    @FXML
    protected void onUpdateButtonClick() {
//      update favorite team for current fan with current desired team name
        updateFavTeam(fanId, favTeamTextField.getText());
    }

//  this runs on application start, it sets the welcome message and instructions
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

//  function to look for the fan in the database and display it nicely,
//  if there is no fan found for the provided id, the display fields will read "none"
    private void getFan() {
//      we want to remove whichever fan is currently displayed to make way
//      for the new fan. Otherwise, there would be multiple fans on the page
        vboxContainer.getChildren().clear();

        try {
//          use data access object to get the desired fan by id
            FanDAO fanDAO = new FanDAO();
            Fan fan = fanDAO.getFanData(fanId);

//          adding hboxes and styling for nice display
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

//          populate the display with fan data if any is found
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

//  function to update the favorite team for current fan
    private void updateFavTeam(Integer fanId, String newFavTeam) {
//      use data access object to update the fan data
        FanDAO fanDAO = new FanDAO();
        fanDAO.updateFan(fanId, newFavTeam);
//      re-retrieve fan and display again to view successful update
        getFan();
//      for neatness, clear text field upon submission
        favTeamTextField.setText(null);
    }
}
