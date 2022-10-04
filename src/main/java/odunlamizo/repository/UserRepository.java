package odunlamizo.repository;

import static odunlamizo.util.PasswordUtils.encryptPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import odunlamizo.model.User;

public class UserRepository extends Repository<User, Long> {

    private UserRepository() {}

    private static class UserRepositoryHelper {

        private static final UserRepository INSTANCE = new UserRepository();

    }

    public static UserRepository getInstance() {
        return UserRepositoryHelper.INSTANCE;
    }

    @Override
    public User save(User entity) {
        try(Connection connection = connection()) {
            String sql = "INSERT INTO user(name, username, email, password) VALUES(?, ?, ?, ?)";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(2, entity.getUsername());
                preparedStatement.setString(3, entity.getEmail());
                preparedStatement.setString(4, encryptPassword(entity.getPassword()));
                preparedStatement.executeUpdate();
                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    resultSet.next();
                    entity.setId(resultSet.getLong(1));
                }
            }
            entity.setPassword(null);
            return entity;
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public User find(Long id) {
        try(Connection connection = connection()) {
            String sql = "SELECT id, name, username, email FROM user WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if(resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getLong(1));
                        user.setUsername(resultSet.getString(3));
                        user.setEmail(resultSet.getString(4));
                        return user;
                    }else {
                        return null;
                    }                   
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public User findUserWithIdAndPassword(String username) {
        try(Connection connection = connection()) {
            String sql = "SELECT id, password FROM user WHERE username=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if(resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getLong(1));
                        user.setPassword(resultSet.getString(2));
                        return user;
                    }else {
                        return null;
                    }                   
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public boolean exists(String username, String email) {
        try(Connection connection = connection()) {
            String sql = "SELECT COUNT(*) FROM user WHERE username=? OR email=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    return resultSet.getInt(1) == 1;
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}