package com.example.ericksonmodten;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Code is simplified and easier to understand when
// database transactions are abstracted into a data access object
public class FanDAO {

    private static final String UPDATE_FAN = "UPDATE fans SET favoriteteam = ? WHERE id = ?";

    private static final String GET_FAN = "SELECT * FROM fans WHERE id = ?";

//  database transaction to retrieve desired fan
    public Fan getFanData(Integer fanId) throws SQLException {
        Fan fan;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_FAN)
        ) {
            statement.setInt(1, fanId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
//              build fan object from result
                fan = new Fan(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("favoriteteam")
                );
                return fan;
            }
//          if there is no fan found for that id, return an empty fan
            fan = new Fan(
                    fanId, "none", "none", "none"
            );
            return fan;
        }
//    connections get closed automatically after try block
    }

//  transaction to update data in the desired fan record
    public void updateFan(Integer fanId, String newFavTeam) {

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_FAN)
        ) {
            statement.setString(1, newFavTeam);
            statement.setInt(2, fanId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    connections get closed automatically after try block
}
