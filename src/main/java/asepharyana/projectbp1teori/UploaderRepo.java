package asepharyana.projectbp1teori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO uploader (id, output) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, uploader.getId());
            statement.setString(2, uploader.getOutput());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UploaderModel readUploader(int id) {
        String sql = "SELECT * FROM uploader WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new UploaderModel(
                    resultSet.getInt("id"),
                    resultSet.getString("output")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                    resultSet.getInt("id"),
                    resultSet.getString("output")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uploaders;
    }
}
