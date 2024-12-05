package com.example.ericksonmodten;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FanDAO {
    private static final String SELECT_ALL_FANS = "SELECT id, firstName, lastName, favoriteTeam FROM fans";

    private static final String UPDATE_FAN = "UPDATE fans SET favoriteTeam = ? WHERE id = ?";

    public List<Fan> getAllFans() throws SQLException {
        List<Fan> fans = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try (
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_FANS);
            ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Fan fan = new Fan(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("favoriteTeam")
                );
                fans.add(fan);
            }
        }
        return fans;
    }

    public void updateFan(Fan fan) {

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_FAN)
        ) {
            statement.setString(1, fan.getFavoriteTeam());
            statement.setInt(2, fan.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    connections get closed automatically after try block

}
