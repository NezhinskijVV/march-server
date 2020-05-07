package dao;

import domain.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO {


    @Override
    public Client getClientByLogin(String login) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:MySQL://localhost:3306/new_schema?serverTimezone=UTC",
                "root", "12345678")) {

            ResultSet resultSet = conn.prepareStatement("SELECT login, password from User where login = '" +
                    login + "'").executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getString("login"));
                System.out.println(resultSet.getString("password"));
                return new Client(resultSet.getString("login"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
