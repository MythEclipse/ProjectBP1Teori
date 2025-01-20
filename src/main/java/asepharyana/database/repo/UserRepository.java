package asepharyana.database.repo;

import asepharyana.database.lib.DatabaseUtil;
import asepharyana.database.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UserRepository {
    private static final String TABLE_NAME = "User";
    private List<UserModel> userCache = new ArrayList<>();
    private boolean isCacheLoaded = false;
    private Timer cacheTimer;

    public UserRepository() {
        startCacheTimer();
    }

    private void startCacheTimer() {
        cacheTimer = new Timer(true);
        cacheTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                loadCache();
            }
        }, 0, 5000); // 0 delay, 5000ms (5 seconds) period
    }

    public boolean create(UserModel user) {
        String query = "INSERT INTO " + TABLE_NAME
                + " (id, username, password, jk, alamat) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            String uniqueId = generateUniqueId(connection);
            user.setId(uniqueId);
            stmt.setString(1, uniqueId);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getJenisKelamin());
            stmt.setString(5, user.getAlamat());
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String generateUniqueId(Connection connection) throws SQLException {
        String uniqueId;
        boolean isUnique;
        do {
            uniqueId = java.util.UUID.randomUUID().toString();
            String query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, uniqueId);
                try (ResultSet rs = stmt.executeQuery()) {
                    rs.next();
                    isUnique = rs.getInt(1) == 0;
                }
            }
        } while (!isUnique);
        return uniqueId;
    }

    public List<UserModel> readAll() {
        List<UserModel> users = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setJenisKelamin(rs.getString("jk"));
                user.setAlamat(rs.getString("alamat"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateByUsername(UserModel user) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + TABLE_NAME + " SET ");
        List<Object> parameters = new ArrayList<>();

        if (user.getPassword() != null) {
            queryBuilder.append("password = ?, ");
            parameters.add(user.getPassword());
        }
        if (user.getJenisKelamin() != null) {
            queryBuilder.append("jk = ?, ");
            parameters.add(user.getJenisKelamin());
        }
        if (user.getAlamat() != null) {
            queryBuilder.append("alamat = ?, ");
            parameters.add(user.getAlamat());
        }

        // Remove the last comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(" WHERE username = ?");
        parameters.add(user.getUsername());

        String query = queryBuilder.toString();

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateById(String id, String username, String password, String jenisKelamin, String alamat) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + TABLE_NAME + " SET ");
        List<Object> parameters = new ArrayList<>();

        if (username != null) {
            queryBuilder.append("username = ?, ");
            parameters.add(username);
        }
        if (password != null) {
            queryBuilder.append("password = ?, ");
            parameters.add(password);
        }
        if (jenisKelamin != null) {
            queryBuilder.append("jk = ?, ");
            parameters.add(jenisKelamin);
        }
        if (alamat != null) {
            queryBuilder.append("alamat = ?, ");
            parameters.add(alamat);
        }

        // Remove the last comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(" WHERE id = ?");
        parameters.add(id);

        String query = queryBuilder.toString();

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserModel login(String username, String password) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel();
                    user.setId(rs.getString("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setJenisKelamin(rs.getString("jk"));
                    user.setAlamat(rs.getString("alamat"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserModel> findByUsername(String username) {
        if (!isCacheLoaded) {
            loadCache();
        }
        List<UserModel> result = new ArrayList<>();
        for (UserModel user : userCache) {
            if (user.getUsername().equals(username)) {
                result.add(user);
            }
        }
        return result;
    }

    public UserModel findById(String id) {
        if (!isCacheLoaded) {
            loadCache();
        }
        for (UserModel user : userCache) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private void loadCache() {
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            userCache.clear();
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setJenisKelamin(rs.getString("jk"));
                user.setAlamat(rs.getString("alamat"));
                userCache.add(user);
            }
            isCacheLoaded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean deleteByUsername(String username) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE username = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
