package asepharyana.database.repo;

import asepharyana.database.model.UploaderModel;
import asepharyana.database.lib.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asephs
 */
public class UploaderRepo {
    public void createUploader(UploaderModel uploader) {
        String sql = "INSERT INTO uploader (id, output, userId) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, uploader.getOutput());
            statement.setString(3, uploader.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Log the exception
            System.err.println("Error executing SQL: " + e.getMessage());
        }
    }

    public UploaderModel readUploader(String id) {
        String sql = "SELECT * FROM uploader WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new UploaderModel(
                        resultSet.getString("id"),
                        resultSet.getString("output"),
                        resultSet.getString("userId"));
            }
        } catch (SQLException e) {
            // Log the exception
            System.err.println("Error executing SQL: " + e.getMessage());
        }
        return null;
    }

    public List<UploaderModel> listUploaders() {
        List<UploaderModel> uploaders = new ArrayList<>();
        String sql = "SELECT * FROM uploader";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                uploaders.add(new UploaderModel(
                        resultSet.getString("id"),
                        resultSet.getString("output"),
                        resultSet.getString("userId")));
            }
        } catch (SQLException e) {
            // Log the exception
            System.err.println("Error executing SQL: " + e.getMessage());
        }
        return uploaders;
    }
    public List<UploaderModel> findByUsername(String username) {
        List<UploaderModel> uploaders = new ArrayList<>();
        String sql = "SELECT * FROM uploader WHERE userId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                uploaders.add(new UploaderModel(
                        resultSet.getString("id"),
                        resultSet.getString("output"),
                        resultSet.getString("userId")));
            }
        } catch (SQLException e) {
            // Log the exception
            System.err.println("Error executing SQL: " + e.getMessage());
        }
        return uploaders;
    }
    public List<UploaderModel> listFindById(String id) {
        List<UploaderModel> uploaders = new ArrayList<>();
        String sql = "SELECT * FROM uploader WHERE userId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                uploaders.add(new UploaderModel(
                        resultSet.getString("id"),
                        resultSet.getString("output"),
                        resultSet.getString("userId")));
            }
        } catch (SQLException e) {
            // Log the exception
            System.err.println("Error executing SQL: " + e.getMessage());
        }
        return uploaders;
    }
}
