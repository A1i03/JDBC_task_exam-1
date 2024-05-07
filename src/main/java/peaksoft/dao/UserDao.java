package peaksoft.dao;

import peaksoft.models.Product;
import peaksoft.models.Project;
import peaksoft.models.User;

public interface UserDao {
    String addUser(User user);
    void createUserTable();
    User getUserById(Long UserId);
    void updateUser(Long id,User newUser);
    void deleteUserByID(Long id);
    void getUserRole(String role);
}
