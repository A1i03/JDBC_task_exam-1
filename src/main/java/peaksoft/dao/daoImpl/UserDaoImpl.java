package peaksoft.dao.daoImpl;

import peaksoft.config.DataBaseJdbc;
import peaksoft.dao.UserDao;
import peaksoft.models.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private final Connection connection = DataBaseJdbc.getConnection();

    @Override
    public void createUserTable() {
        String sql = """
                create table if not exists users(
                id serial primary key,
                user_name varchar,
                password varchar,
                role varchar
                """;
        try (Statement statement = connection.prepareStatement(sql)){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public User getUserById(Long UserId) {
        User user = new User();
        String sql = "select * from users where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,UserId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateUser(Long id, User newUser) {
        String sql = "update users set user_name = ?, password =? , role = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,id);
            statement.setString(2,newUser.getUserName());
            statement.setString(3,newUser.getPassword());
            statement.setString(4,newUser.getRole());
            int i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully updated");
            }else System.out.println("Not found with id ");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteUserByID(Long id) {
        String sql = "delete from users where id =? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            int deleteUsers = preparedStatement.executeUpdate();
            if (deleteUsers > 0) {
                System.out.println("Successfully deleted");
            } else System.out.println("Author id not found!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getUserRole(String role) {
    String sql = "select * from users where role = ? ";

    try (PreparedStatement statement = connection.prepareStatement(sql)){
        statement.setString(1,role);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            String roleName  = resultSet.getString("role");
            System.out.println(roleName);
        }else {
            System.out.println("Role net:  " + role);
        }
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    }
}
